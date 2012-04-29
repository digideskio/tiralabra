package joosakur.regexptulkki.regexp;

import joosakur.regexptulkki.queue.MyQueue;
import joosakur.regexptulkki.queue.Queue;
import joosakur.regexptulkki.stack.MyStack;
import joosakur.regexptulkki.stack.Stack;

/**
 * Luokka postfix-muotoisen säännöllisen lausekkeen tuottamiseen.
 */
public class PostfixGenerator {
    /**
     * Muuntaa infix-muotoisen lausekkeen postfix-muotoiseksi.
     * 
     * Mukaillun algoritmin lähde: https://gist.github.com/1239804
     * 
     * @param infix infix-muotoinen lauseke
     * @return postfix-muotoinen lauseke
     */
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
    
    

}
