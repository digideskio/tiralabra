package joosakur.regexptulkki.regexp;

import java.util.ArrayList;
import java.util.List;

class FragZeroOrMore extends Frag {
    
    public FragZeroOrMore() {
    }

    public FragZeroOrMore(State start, List<Out> outs) {
        this.setStart(start);
        this.setOuts(outs);
    }

    public FragZeroOrMore(Frag frag) {
        State state = new State(State.SPLIT, new Out(frag.getStart()), new Out());
        connectFrags(frag.getOuts(), state);
        List<Out> outs = new ArrayList<Out>();
        outs.add(state.getOut1());
        this.setStart(state);
        this.setOuts(outs);
    }
    
    
    
}
