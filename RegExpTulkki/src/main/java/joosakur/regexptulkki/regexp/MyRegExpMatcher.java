package joosakur.regexptulkki.regexp;

import joosakur.regexptulkki.queue.JavaQueue;
import joosakur.regexptulkki.queue.Queue;
import joosakur.regexptulkki.stack.JavaStack;
import joosakur.regexptulkki.stack.Stack;


public class MyRegExpMatcher implements RegExpMatcher{

    
    @Override
    public boolean matches(String regex, CharSequence input) {
        generateNFA(infixToPostfix(regex));
        throw new UnsupportedOperationException();
    }

    
    
    //Muuntaa infix-muotoisen lausekkeen postfix-muotoiseksi.
    //Mukaillun algoritmin lähde: https://gist.github.com/1239804
    public String infixToPostfix(String infix){
        infix = addExplicitConcatenation(infix);
        
        Queue<Character> output = new JavaQueue<Character>();
        Stack<Character> stack = new JavaStack<Character>();
        
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
        Queue<Character> output = new JavaQueue<Character>();
        
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
        Stack<Frag> stack = new JavaStack<Frag>();
        for (int i = 0; i < postfixExpression.length(); i++) {
            switch (postfixExpression.charAt(i)) {
                case '.':
                    stack.push(new FragCatenation(stack.pop(), stack.pop()));
                    break;
                case '|':
                    stack.push(new FragAlternation(stack.pop(), stack.pop()));
                    break;
                case '*':
                    stack.push(new FragZeroOrMore(stack.pop()));
                    break;    
                default:
                    stack.push(new FragLiteral(postfixExpression.charAt(i)));
                    break;
            }
        }
        
        Frag frag = stack.pop();
        Frag.connectFrags(frag.getOuts(), new State(State.MATCH));
        return frag.getStart();
    }
    
}
