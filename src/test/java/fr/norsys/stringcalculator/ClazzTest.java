package fr.norsys.stringcalculator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClazzTest {
    @Test
    void should_return_0(){
        assertEquals(0, Clazz.add(""));
    }
    @Test
    void should_return_1(){
        assertEquals(1, Clazz.add("1"));
    }
    @Test
    void should_return_2(){
        assertEquals(3, Clazz.add("1,2"));
    }

    @Test
    void should_return_6(){
        assertEquals(6, Clazz.add("1,2,3"));
    }

    @Test
    void should_return_0_withNewLines(){
        assertEquals(0, Clazz.add(""));
    }
    @Test
    void should_return_1_withNewLines(){
        assertEquals(1, Clazz.add("1"));
    }
    @Test
    void should_return_2_withNewLines(){
        String str = "1\n2";
        assertEquals(3, Clazz.add(str));
    }

    @Test
    void should_return_6_withNewLines(){
        String str = "1\n2\n3";
        assertEquals(6, Clazz.add(str));
    }

    @Test
    void should_return_6_WithCommasNewLines(){
        assertEquals(6,Clazz.add("1\n2,3"));
    }

    @Test
    void should_return_3_WithDelimiter(){
        assertEquals(3,Clazz.add("//\n\n1\n2"));
    }

    @Test
    void should_throw_exception_with_negative_numbers(){
        assertThrows(RuntimeException.class, () -> Clazz.add("//;\n1;-2;-3"));
    }



}