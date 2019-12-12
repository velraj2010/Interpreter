

import org.junit.Assert;
import org.junit.Test;

/**
 * @author velraj.
 */
public class NotExpTest {

    @Test
    public void testEval() throws EvalError {
        Env env = new EnvImp();
        Expr boolExpr = new BoolConst(true);
        NotExp notExp = new NotExp(boolExpr);
        Value value = notExp.eval(env);
        Assert.assertEquals(String.valueOf(false), value.toString());

        Expr intExpr = new IntConst(12);
        notExp = new NotExp(intExpr);
        try{
            value = notExp.eval(env);
            throw new EvalError("Should not have come here");
        } catch (EvalError e) {
            //Exception is expected to thrown here
            Assert.assertEquals(EvalError.INCOMPATIBLE_ARG_TYPES, e.getMessage());
        }
    }
}
