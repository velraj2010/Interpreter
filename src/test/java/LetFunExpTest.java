

import org.junit.Assert;
import org.junit.Test;

/**
 * @author velraj.
 */
public class LetFunExpTest {
    @Test
    public void testEval() throws EvalError {
        String f = "f";
        String x = "x";
        // let val x = 2 in let fun f(x) = x*x in x+2 end end ;
        LetFunExp letFunExp36 = new LetFunExp(f, x,
                new BinExp(VarExpTest.varExpX, VarExpTest.varExpX, BinOp.TIMES.getOperator()), BinExpTest.binExp36);
        Value value = letFunExp36.eval(new EnvImp());
        Assert.assertTrue(value instanceof IntVal);
        Assert.assertEquals(36, ((IntVal)value).value);
    }
}
