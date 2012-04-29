package joosakur.regexptulkki.regexp;

/**
 * 
 * Etenemispolku seuraavaan tilaan.
 */
class Out {
    /**
     * Seuraava tila.
     */
    private State state;

    public Out() {
    }

    public Out(State state) {
        this.state = state;
    }

    
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    
}
