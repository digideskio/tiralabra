package joosakur.regexptulkki.regexp;

/**
 * Tila Finite Automata algoritmissa.
 */
class State {
    /**
     * Merkki tai tila.
     */
    private int character;
    /**
     * Polku seuraavaan tilaan
     */
    private Out out1;
    /**
     * Polku seuraavaan tilaan
     */
    private Out out2;
    /**
     * Tilalistan (StateList) id, jolla varmistetaan ettei samaa tilaa (State) lisätä listalle kahdesti
     */
    private int lastlist;

    /**
     * Alternaatiota kuvaava tila.
     */
    static final int SPLIT = 256;
    /**
     * Lopputila.
     */
    static final int MATCH = 257;

    public State() {
    }

    public State(int character) {
        this.character = character;
    }
    
    public State(int character, Out out1, Out out2) {
        this.character = character;
        this.out1 = out1;
        this.out2 = out2;
    }

    
    public int getCharacter() {
        return character;
    }

    public void setCharacter(int character) {
        this.character = character;
    }

    public int getLastlist() {
        return lastlist;
    }

    public void setLastlist(int lastlist) {
        this.lastlist = lastlist;
    }

    public Out getOut1() {
        return out1;
    }

    public void setOut1(Out out1) {
        this.out1 = out1;
    }

    public Out getOut2() {
        return out2;
    }

    public void setOut2(Out out2) {
        this.out2 = out2;
    }

    
}
