package joosakur.regexptulkki.regexp;


class Out {
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
