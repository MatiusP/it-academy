package by.it.protsko.calc;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCalc {

    @Test
    public void TestCalc_Add() throws CalcException{
        Parser parser = new Parser();
        Var actual = parser.calc("A=2+5.3");
        assertEquals("Error: incorrect result", "7.3", actual.toString());
    }

    @Test
    public void TestCalc_Sub() throws Exception{
        Parser parser = new Parser();
        Var actual = parser.calc("B2=A/2-1");
        assertEquals("Error: incorrect result", "2.65", actual.toString());
    }

    @Test
    public void TestCalc_Mul() throws Exception{
        Parser parser = new Parser();
        Var actual = parser.calc("B=A*3.5");
        assertEquals("Error: incorrect result", "25.55", actual.toString());
    }

    @Test
    public void TestCalc_Div() throws Exception{
        Parser parser = new Parser();
        Var actual = parser.calc("A/2");
        assertEquals("Error: incorrect result", "3.65", actual.toString());
    }

}

