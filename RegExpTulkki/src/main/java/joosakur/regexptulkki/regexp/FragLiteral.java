package joosakur.regexptulkki.regexp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class FragLiteral extends Frag {
    
    public FragLiteral() {
    }

    public FragLiteral(State start, List<Out> outs) {
        this.setStart(start);
        this.setOuts(outs);
    }

    public FragLiteral(char character) {
        State state = new State(character, new Out(), null);
        this.setStart(state);
        
        List<Out> outs = new ArrayList<Out>();
        outs.add(state.getOut());
        this.setOuts(outs);
    }
    
    
    
}
