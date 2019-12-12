

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author velraj.
 */
public class BoolConstExprTest {
    private static String strTrue = "true";
    private static String strFalse = "false";

    public static final Expr boolConstTrue = new BoolConst(Boolean.valueOf(strTrue));
    public static final Expr boolConstFalse = new BoolConst(Boolean.valueOf(strFalse));

    @Test
    public void testEval() throws EvalError {
        assertEquals(String.valueOf(true), boolConstTrue.eval(new EnvImp()).toString());
        assertEquals(String.valueOf(false), boolConstFalse.eval(new EnvImp()).toString());
    }
}
