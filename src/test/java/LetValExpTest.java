

import org.junit.Assert;
import org.junit.Test;

/**
 * @author velraj.
 */
public class LetValExpTest {
    String x = "x";
    LetValExp _letValExp36 = new LetValExp(x, IntConstTest.intConst12,
            new BinExp(VarExpTest.varExpX, IntConstTest.intConst24, BinOp.PLUS.getOperator()) );


    @Test
    public void testEval() throws EvalError {
        Env env = new EnvImp();
        //test let val x = true in x + 30 end;
        LetValExp _letValExpInvalidArg = new LetValExp(x, BoolConstExprTest.boolConstTrue,
                new BinExp(VarExpTest.varExpX, IntConstTest.intConst24, BinOp.PLUS.getOperator()) );
        try {
            _letValExpInvalidArg.eval(env);
            throw new EvalError("Should not have come here");
        } catch (EvalError error) {
            Assert.assertEquals(EvalError.INCOMPATIBLE_ARG_TYPES, error.getMessage());
        }

        //test let val x = 12 in x + 24 end;
        Assert.assertEquals("let val x=12 in x+24", _letValExp36.toString());
        Value value = _letValExp36.eval(env);
        Assert.assertTrue(value instanceof IntVal);
        Assert.assertEquals(36, ((IntVal)value).value);
    }
}
