

import org.junit.Assert;
import org.junit.Test;

/**
 * @author velraj.
 */
public class IfExpTest {
    public static final IfExp ifExpTestNotBoolean = new IfExp(IntConstTest.intConst12, IntConstTest.intConst12,
            IntConstTest.intConst24);
    public static final IfExp ifExpBranchNotAgreeError = new IfExp(BoolConstExprTest.boolConstFalse,
            BoolConstExprTest.boolConstTrue, IntConstTest.intConst24);
    public static final IfExp ifExp12 = new IfExp(BoolConstExprTest.boolConstTrue, IntConstTest.intConst12,
            IntConstTest.intConst24);
    public static final IfExp ifExp24 = new IfExp(BoolConstExprTest.boolConstFalse, IntConstTest.intConst12,
            IntConstTest.intConst24);
    public static final IfExp ifExpFalse = new IfExp(BoolConstExprTest.boolConstFalse, BoolConstExprTest.boolConstTrue,
            BoolConstExprTest.boolConstFalse);
    @Test
    public void testEval() throws EvalError {
        try{
            ifExpTestNotBoolean.eval(EnvImpTest.emptyEnv);
            throw new EvalError("Should not have come here");
        } catch (EvalError error) {
            Assert.assertEquals(IfExp.EXPR_NOT_BOOLEAN, error.getMessage());
        }

        try{
            ifExpBranchNotAgreeError.eval(EnvImpTest.emptyEnv);
            throw new EvalError("Should not have come here");
        } catch (EvalError error) {
            Assert.assertEquals(IfExp.OPERATOR_OPERAND_DO_NOT_AGREE, error.getMessage());
        }
        Assert.assertEquals(IntConstTest.intConst12.toString(), ifExp12.eval(EnvImpTest.emptyEnv).toString());
        Assert.assertEquals(IntConstTest.intConst24.toString(), ifExp24.eval(EnvImpTest.emptyEnv).toString());
        Assert.assertEquals(String.valueOf(false), ifExpFalse.eval(EnvImpTest.emptyEnv).toString());
    }
}
