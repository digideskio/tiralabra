package joosakur.regexptulkki.regexp;

import joosakur.regexptulkki.list.List;


class FragCatenation extends Frag {
    
    public FragCatenation() {
    }

    public FragCatenation(State start, List<Out> outs) {
        this.setStart(start);
        this.setOuts(outs);
    }

    public FragCatenation(Frag frag2, Frag frag1) {
        connectFrags(frag1.getOuts(), frag2.getStart());
        this.setStart(frag1.getStart());
        this.setOuts(frag2.getOuts());
    }
    
    
    
}
