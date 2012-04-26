package joosakur.regexptulkki.regexp;

class State {
    private int c;
    private Out out;
    private Out out1;
    private int lastlist;

    static final int SPLIT = 256;
    static final int MATCH = 257;

    public State() {
    }

    public State(int c) {
        this.c = c;
    }
    
    public State(int c, Out out, Out out1) {
        this.c = c;
        this.out = out;
        this.out1 = out1;
    }

    
    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getLastlist() {
        return lastlist;
    }

    public void setLastlist(int lastlist) {
        this.lastlist = lastlist;
    }

    public Out getOut() {
        return out;
    }

    public void setOut(Out out) {
        this.out = out;
    }

    public Out getOut1() {
        return out1;
    }

    public void setOut1(Out out1) {
        this.out1 = out1;
    }

    
}
