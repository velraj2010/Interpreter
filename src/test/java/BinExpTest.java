

import org.junit.Assert;
import org.junit.Test;


/**
 * @author velraj.
 */
public class BinExpTest {

    private final static String plusOp = "+";
    private final static String unsupportedOp = "^";
    public static final String INCOMPATIBLE_ARG_TYPES = "Evaluation error: Incompatible arg types";

    public final static BinExp binExp36 = new BinExp(IntConstTest.intConst12, IntConstTest.intConst24, plusOp);
    public final BinExp binExpArgError = new BinExp(IntConstTest.intConst12, BoolConstExprTest.boolConstTrue, plusOp);
    public final BinExp binExpOpError = new BinExp(IntConstTest.intConst12, BoolConstExprTest.boolConstTrue, unsupportedOp);


    @Test
    public void testEvaluate() throws EvalError {
        Env env = EnvImpTest.emptyEnv;
        Assert.assertEquals(String.valueOf(36), binExp36.eval(env).toString());
        try{
            binExpArgError.eval(env);
            throw new EvalError("Should not have come here");
        } catch (EvalError e) {
            //Exception is expected to thrown here
            Assert.assertEquals(INCOMPATIBLE_ARG_TYPES, e.getMessage());
        }
        try{
            binExpOpError.eval(env);
            throw new EvalError("Should not have come here");
        } catch (EvalError e) {
            //Exception is expected to thrown here
            Assert.assertEquals(BinExp.OPERATION_NOT_SUPPORTED, e.getMessage());
        }

    }
}
