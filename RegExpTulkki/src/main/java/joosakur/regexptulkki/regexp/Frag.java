package joosakur.regexptulkki.regexp;

import joosakur.regexptulkki.list.List;

/**
 * NFA-fragmentti
 */
abstract class Frag {
    /**
     * Fragmentin tila
     */
    private State start;
    /**
     * Etenemispolut fragmentista
     */
    private List<Out> outs;

    public List<Out> getOuts() {
        return outs;
    }

    public void setOuts(List<Out> outs) {
        this.outs = outs;
    }

    public State getStart() {
        return start;
    }

    public void setStart(State start) {
        this.start = start;
    }
    
    /**
     * connects outs of the previous fragment to the next fragment's start state
     * 
     * @param prevFragOuts edellisen fragmentin ulostulot
     * @param nextFragStart seuraavan fragmentin tila
     */
    protected static void connectFrags(List<Out> prevFragOuts, State nextFragStart){
        for (int i = 0; i < prevFragOuts.size(); i++) {
            prevFragOuts.get(i).setState(nextFragStart);
        }
    }
}
