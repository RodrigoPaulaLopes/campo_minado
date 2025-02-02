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


    public boolean addAdjacentFields(Field field){
        var diffLine = line != field.line;
        var diffColumn = collumn != field.collumn;
        var diagonal = diffLine && diffColumn;
        var deltaLine = Math.abs(line - field.line);
        var deltaColumn = Math.abs(collumn - field.collumn);
        var deltaGeneral = deltaLine + deltaColumn;

        if(deltaGeneral == 1 && !diagonal){
            adjacentFields.add(field);
            return true;
        }else if(deltaColumn == 2 && diagonal){
            adjacentFields.add(field);
            return true;
        }else{
            return false;
        }
    }

    
}
