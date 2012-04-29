package joosakur.regexptulkki.regexp;

import joosakur.regexptulkki.list.List;
import joosakur.regexptulkki.list.MyList;


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
        
        List<Out> outs = new MyList<Out>();
        outs.add(state.getOut1());
        this.setOuts(outs);
    }
    
    
    
}
