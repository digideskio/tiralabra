package joosakur.regexptulkki.regexp;

import joosakur.regexptulkki.list.List;
import joosakur.regexptulkki.list.MyList;


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
        List<Out> outs = new MyList<Out>();
        outs.add(state.getOut2());
        this.setStart(state);
        this.setOuts(outs);
    }
    
    
    
}
