package by.it.protsko.calc;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ScalarTest {

    @Test
    public void testAdd() throws Exception{
        Var res = Scalar.createVar("156");
        assertEquals(3, res);
    }

}
