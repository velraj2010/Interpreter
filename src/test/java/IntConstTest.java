import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author velraj.
 */
public class IntConstTest {

    public static final Expr intConst2 = new IntConst(2);
    public static final Expr intConst12 = new IntConst(12);
    public static final Expr intConst24 = new IntConst(24);
    public static final Expr intConst36 = new IntConst(36);

    @Test
    public void testEval() throws EvalError {
        assertEquals(String.valueOf(12), intConst12.eval(new EnvImp()).toString());
    }

}
