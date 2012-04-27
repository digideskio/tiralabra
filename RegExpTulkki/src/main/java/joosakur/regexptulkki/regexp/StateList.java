package joosakur.regexptulkki.regexp;

import joosakur.regexptulkki.list.JavaList;
import joosakur.regexptulkki.list.List;

public class StateList {
    List<State> states;
    int id;

    public StateList(int id) {
        this.states = new JavaList<State>();
        this.id = id;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
    
    
}
