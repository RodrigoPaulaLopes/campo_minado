package com.cod3r.models;

import java.util.ArrayList;
import java.util.List;

public class Field {
    
    private final int line;
    private final int collumn;


    private boolean open = false;
    private boolean mined = false;
    private boolean Flagged = false;


    private List<Field> adjacentFields = new ArrayList<Field>();


    public Field(int line, int collumn) {
        this.line = line;
        this.collumn = collumn;
    }


    boolean addAdjacentFields(Field field){
        return true;
    }

    
}
