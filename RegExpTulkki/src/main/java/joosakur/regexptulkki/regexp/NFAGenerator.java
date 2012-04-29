package joosakur.regexptulkki.regexp;

import joosakur.regexptulkki.stack.MyStack;
import joosakur.regexptulkki.stack.Stack;

/**
 * Luokka NFA:n (nondeterministic finite automata) generoimiseen
 */
public class NFAGenerator {

    /**
     * Generoi NFA:n postfix-muotoisesta säännöllisestä lausekkeesta, jossa katenaatio on merkitty pisteellä ja palauttaa alkutilan.
     * 
     * @param postfixExpression postfix-muotoinen säännöllinen lauseke
     * @return NFA-algoritmin alkutila
     */
    protected State generateNFA(String postfixExpression){
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
    
}
