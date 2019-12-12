

import org.junit.Assert;
import org.junit.Test;

/**
 * @author velraj.
 */
public class AssnExpTest {

    @Test
    public void testEval() throws EvalError {
        String x = "x";
        String y = "y";
        Env env = new EnvImp();
        //test unbounded x
        try{
            Value value = env.lookup(x);
            throw new UnboundVar("Should not have come here");
        } catch (UnboundVar uv) {
            //Exception is expected
            Assert.assertEquals(UnboundVar.UNBOUND_VARIABLE + x, uv.getMessage());
        }

        //test let val x=12 in x := true end;
        LetValExp letValExpIncompatibleAssn = new LetValExp(x, IntConstTest.intConst12,
                new AssnExp(VarExpTest.varExpX.toString(), BoolConstExprTest.boolConstTrue));

        try{
            Value value = letValExpIncompatibleAssn.eval(env);
        }
        catch (EvalError error) {
            Assert.assertEquals(AssnExp.INCOMPATIBLE_TYPE_ASSIGNMENT, error.getMessage());
        }


        //test y := x+21;
//        VarExp varExpX = new VarExp(x);
//        intConst1 = new IntConst(21);
//        Expr arithExpr1 = new BinExp(varExpX, intConst1, BinOp.PLUS.getOperator());
//        assignExpr1 = new AssnExp(y, arithExpr1);
//        value = assignExpr1.eval(env);
//        Assert.assertTrue(value instanceof IntVal);
//        Assert.assertEquals(String.valueOf(33), value.toString());
    }
}
