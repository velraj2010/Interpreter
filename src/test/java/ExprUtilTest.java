

import org.junit.Assert;
import org.junit.Test;

/**
 * @author velraj.
 */
public class ExprUtilTest {
    @Test
    public void testEvaluate() throws EvalError {
        Value intValue1 = new IntVal(14);
        Expr expr2 = IntConstTest.intConst2;
        Value intValue2 = new IntVal(2);
        Env env = new EnvImp();
        //Arithmetic
        Assert.assertEquals(String.valueOf(16), ExprUtil.evaluate(intValue1, expr2 , env,  BinOp.PLUS).toString());
        Assert.assertEquals(String.valueOf(12), ExprUtil.evaluate(intValue1, expr2 , env , BinOp.MINUS).toString());
        Assert.assertEquals(String.valueOf(28), ExprUtil.evaluate(intValue1, expr2 , env, BinOp.TIMES).toString());
        Assert.assertEquals(String.valueOf(7), ExprUtil.evaluate(intValue1, expr2 , env, BinOp.DIV).toString());
        //Logical
        Assert.assertEquals(String.valueOf(2), ExprUtil.evaluate(intValue1, expr2 , env, BinOp.AND).toString());
        Assert.assertEquals(String.valueOf(14), ExprUtil.evaluate(intValue1, expr2 , env, BinOp.OR).toString());
        //Relational
        Assert.assertEquals(String.valueOf(false), ExprUtil.evaluate(intValue1, expr2 , env , BinOp.LT).toString());
        Assert.assertEquals(String.valueOf(false), ExprUtil.evaluate(intValue1, expr2 , env , BinOp.EQ).toString());
    }
}
