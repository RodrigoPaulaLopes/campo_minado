package com.cod3r.models;

import java.util.ArrayList;
import java.util.List;

import com.cod3r.exception.ExplosionException;

public class Field {
    
    private final int line;
    private final int collumn;


    private boolean open = false;
    private boolean mined = false;
    private boolean flagged = false;


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

    public void onFlagged(){
        if(this.flagged) {
            this.flagged = !this.flagged;
        }
    }

    public boolean open(){
        if(!this.open && !this.flagged){
            open = true;

            if(mined){
                throw new ExplosionException();
            }
            if(secureAdjacentFields()){
                adjacentFields.forEach(field -> field.open());
            }
            return true;
        }else {
            return false;
        }
    }

    public boolean secureAdjacentFields(){
        return this.adjacentFields.stream().noneMatch(field -> !field.mined);
    }
    public boolean isFlagged(){
        return this.flagged;
    }

    
}
