package models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.cod3r.models.Field;

public class FieldTest {
    
    private Field field;
    @Before
    public void initialize(){
        field = new Field(3, 3);

    }
    
    @Test
    public void mustReturnTrueWhenAddAdjacentField(){
        Field adjacentField = new Field(3, 2);

        var result = field.addAdjacentFields(adjacentField);
        
        assertTrue(result);
    }
    @Test
    public void mustReturnFalseWhenAddAdjacentField(){
        Field adjacentField = new Field(5, 4);

        var result = field.addAdjacentFields(adjacentField);
        
        assertFalse(result);
    }
}
