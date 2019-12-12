

import org.junit.Assert;
import org.junit.Test;

/**
 * @author velraj.
 */
public class VarExpTest {
    private static String x = "x";
    private static String y = "y";
    public static final VarExp varExpX = new VarExp(x);
    public static final VarExp varExpY = new VarExp(y);

    @Test
    public void testEval() throws EvalError {
        Env env = new EnvImp().addBinding(x, new IntVal(10));
        varExpX.eval(env);
        try{
            varExpY.eval(env);
        } catch (UnboundVar unboundVar) {
            Assert.assertEquals(UnboundVar.UNBOUND_VARIABLE + y, unboundVar.getMessage());
        }
    }
}
