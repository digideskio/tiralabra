package joosakur.regexptulkki.regexp;

import java.util.ArrayList;
import java.util.List;

class FragAlternation extends Frag {
    
    public FragAlternation() {
    }

    public FragAlternation(State start, List<Out> outs) {
        this.setStart(start);
        this.setOuts(outs);
    }

    public FragAlternation(Frag frag2, Frag frag1) {
        State state = new State(State.SPLIT, new Out(frag1.getStart()), new Out(frag2.getStart()));
        List<Out> outs = new ArrayList<Out>();
        outs.addAll(frag1.getOuts());
        outs.addAll(frag2.getOuts());
        this.setStart(state);
        this.setOuts(outs);
    }
    
    
    
}
