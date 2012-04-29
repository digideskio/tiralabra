package joosakur.regexptulkki.regexp;

import joosakur.regexptulkki.stack.MyStack;
import joosakur.regexptulkki.stack.Stack;

/**
 * Oma toteutus säännöllisten lausekkeiden tulkista.
 */
public class MyRegExpMatcher implements RegExpMatcher{

    
    @Override
    public boolean matches(String regex, CharSequence input) {
        PostfixGenerator postfixGenerator = new PostfixGenerator();
        NFAGenerator nFAGenerator = new NFAGenerator();
        State startState = nFAGenerator.generateNFA(postfixGenerator.infixToPostfix(regex));
        return match(startState, input);
    }

    
    
    private boolean match(State startState, CharSequence input) {
        StateList currentStates = startList(startState);
        
        for (int i = 0; i < input.length(); i++) {
            currentStates = step(currentStates, input.charAt(i));
        }
        return isMatch(currentStates);
    }

    private StateList startList(State startState) {
        int firstId = 1;
        StateList states = new StateList(firstId);
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
