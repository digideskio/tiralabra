package joosakur.regexptulkki.regexp;

class State {
    private int character;
    private Out out1;
    private Out out2;
    private int lastlist;

    static final int SPLIT = 256;
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
