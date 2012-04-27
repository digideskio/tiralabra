package joosakur.regexptulkki.regexp;

import joosakur.regexptulkki.queue.MyQueue;
import joosakur.regexptulkki.queue.Queue;
import joosakur.regexptulkki.stack.MyStack;
import joosakur.regexptulkki.stack.Stack;


public class MyRegExpMatcher implements RegExpMatcher{

    
    @Override
    public boolean matches(String regex, CharSequence input) {
        State startState = generateNFA(infixToPostfix(regex));
        return match(startState, input);
    }

    
    
    //Muuntaa infix-muotoisen lausekkeen postfix-muotoiseksi.
    //Mukaillun algoritmin lähde: https://gist.github.com/1239804
    public String infixToPostfix(String infix){
        infix = addExplicitConcatenation(infix);
        
        Queue<Character> output = new MyQueue<Character>();
        Stack<Character> stack = new MyStack<Character>();
        
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            switch (c) {
                case '(':
                    handleBracketOpen(stack);
                    break;
                case ')':
                    handleBracketClose(stack, output);
                    break;
                default:
                    handleNonBracket(c, stack, output);
                    break;
            }
        }
        
        while (!stack.isEmpty()) {
            output.offer(stack.pop());
        }
        
        return charQueueToString(output);
    }
    
    private String addExplicitConcatenation(String expression) {
        Queue<Character> output = new MyQueue<Character>();
        
        for (int i = 0; i < expression.length()-1; i++) {
            char currentChar = expression.charAt(i);
            char nextChar = expression.charAt(i+1);
            
            output.offer(currentChar);
            if(currentChar != '|' && currentChar != '(' && !isRegexpOperator(nextChar) && nextChar != ')')
                output.offer('.');
        }
        output.offer(expression.charAt(expression.length()-1));
        
        return charQueueToString(output);
    }
    
    private boolean isRegexpOperator(char c){
        if (c=='*' || c=='|' ) return true;
        else return false;
    }
    
    private void handleBracketOpen(Stack<Character> stack){
        stack.push('(');
    }
    
    private void handleBracketClose(Stack<Character> stack, Queue<Character> output){
        while(stack.peek() != '(') {
            output.offer(stack.pop());
        }
        stack.pop();
    }
    
    private void handleNonBracket(char c, Stack<Character> stack, Queue<Character> output){
        while(!stack.isEmpty()) {
            if(getPrecedence(stack.peek()) >= getPrecedence(c)) {
                output.offer(stack.pop());
            }
            else break;
        }
        stack.push(c);   
    }
    
    private int getPrecedence(char c){
        switch (c) {
            case '(': 
                return 1;
            case '|':
                return 2;
            case '.':
                return 3;
            case '*':
                return 4;
            default:
                return 5;
        }
    }
    
    private String charQueueToString(Queue<Character> output){
        String string = "";
        while (!output.isEmpty()) {
            string += output.poll().toString();
        }
        return string;
    }
    
    

    
    
    
    
    private State generateNFA(String postfixExpression){
        Stack<Frag> fragmentStack = new MyStack<Frag>();
        for (int i = 0; i < postfixExpression.length(); i++) {
            switch (postfixExpression.charAt(i)) {
                case '.':
                    fragmentStack.push(new FragCatenation(fragmentStack.pop(), fragmentStack.pop()));
                    break;
                case '|':
                    fragmentStack.push(new FragAlternation(fragmentStack.pop(), fragmentStack.pop()));
                    break;
                case '*':
                    fragmentStack.push(new FragZeroOrMore(fragmentStack.pop()));
                    break;    
                default:
                    fragmentStack.push(new FragLiteral(postfixExpression.charAt(i)));
                    break;
            }
        }

        Frag frag = fragmentStack.pop();
        Frag.connectFrags(frag.getOuts(), new State(State.MATCH));
        return frag.getStart();
    }

    
    
    boolean match(State startState, CharSequence input) {
        StateList currentStates = startList(startState);
        
        for (int i = 0; i < input.length(); i++) {
            currentStates = step(currentStates, input.charAt(i));
        }
        return isMatch(currentStates);
    }

    private StateList startList(State startState) {
        StateList states = new StateList(1);
        states = addState(states, startState);
        return states;
    }

    private StateList addState(StateList stateList, State state) {
        if(state == null || state.getLastlist() == stateList.getId())
            return stateList;
        state.setLastlist(stateList.getId());
        if(state.getCharacter() == State.SPLIT) {
            stateList = addState(stateList, state.getOut1().getState());
            stateList = addState(stateList, state.getOut2().getState());
            return stateList;
        }
        stateList.getStates().add(state);
        return stateList;
    }

    private StateList step(StateList currentStates, char c) {
        StateList nextStates = new StateList(currentStates.getId()+1);
        for (int i = 0; i < currentStates.getStates().size(); i++) {
            State state = currentStates.getStates().get(i);
            if(state.getCharacter() == c){
                nextStates = addState(nextStates, state.getOut1().getState());
            }
        }
        return nextStates;
    }

    private boolean isMatch(StateList stateList) {
        for (int i = 0; i < stateList.getStates().size(); i++) {
            if(stateList.getStates().get(i).getCharacter() == State.MATCH)
                return true;
        }
        return false;
    }
    
}
