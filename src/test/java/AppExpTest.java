

import org.junit.Assert;
import org.junit.Test;

/**
 * @author velraj.
 */
public class AppExpTest {
    @Test
    public void testEval() throws EvalError {
        String unknown = "unknown";
        String f = "f";
        String x = "x";
        String y = "y";
        Value value = null;
        AppExp appExpUnknown = new AppExp(unknown, IntConstTest.intConst12);
        // let fun f(x) = x*x in unknown(3) end ;
        LetFunExp letFunExpUnbound = new LetFunExp(f, x,
                new BinExp(VarExpTest.varExpX, VarExpTest.varExpX, BinOp.TIMES.getOperator()), appExpUnknown);
        try {
            letFunExpUnbound.eval(new EnvImp());
            throw new EvalError("Should have not come here");
        } catch (EvalError error) {
            Assert.assertEquals("Unbound variable: unknown", error.getMessage());
        }
        // let val x = 12 in let fun f(x) = x*x in x(12) end end ;
        AppExp appExpX = new AppExp(x, IntConstTest.intConst12);
        LetFunExp letFunExpNotFunction = new LetFunExp(f, x,
                new BinExp(VarExpTest.varExpX, VarExpTest.varExpX, BinOp.TIMES.getOperator()), appExpX);
        LetValExp letValExpNotValidFn = new LetValExp(x, IntConstTest.intConst12, letFunExpNotFunction);
        try {
            letValExpNotValidFn.eval(new EnvImp());
            throw new EvalError("Should have not come here");
        } catch (EvalError error) {
            Assert.assertEquals(AppExp.NOT_VALID_FUNTION, error.getMessage());
        }
        // let val x = 12 in let fun f(x) = x*x in f(true) end end ;
        AppExp appExpFTrue = new AppExp(f, BoolConstExprTest.boolConstTrue);
        LetFunExp letFunExpInvalidArg = new LetFunExp(f, x,
                new BinExp(VarExpTest.varExpX, VarExpTest.varExpX, BinOp.TIMES.getOperator()), appExpFTrue);
        LetValExp letValExpInvalidArg = new LetValExp(x, IntConstTest.intConst12, letFunExpInvalidArg);
        try{
            value = letValExpInvalidArg.eval(new EnvImp());
            throw new EvalError("Should have not come here");
        }
        catch (EvalError error) {
            Assert.assertEquals(EvalError.INCOMPATIBLE_ARG_TYPES, error.getMessage());
        }
        // let val x = 12 in let fun f(x) = x*x in f(12) end end ;
        AppExp appExpF12 = new AppExp(f, IntConstTest.intConst12);
        LetFunExp letFunExp144 = new LetFunExp(f, x,
                new BinExp(VarExpTest.varExpX, VarExpTest.varExpX, BinOp.TIMES.getOperator()), appExpF12);
        LetValExp letValExp144 = new LetValExp(x, IntConstTest.intConst12, letFunExp144);
        value = letValExp144.eval(new EnvImp());
        Assert.assertTrue(value instanceof IntVal);
        Assert.assertEquals(144, ((IntVal)value).value);

        // let val x = 24 in let fun f(y) = x*y in f(12) end end ;
        LetFunExp letFunExp288 = new LetFunExp(f, y,
                new BinExp(VarExpTest.varExpX, VarExpTest.varExpY, BinOp.TIMES.getOperator()), appExpF12);
        LetValExp letValExp288 = new LetValExp(x, IntConstTest.intConst24, letFunExp288);
        value = letValExp288.eval(new EnvImp());
        Assert.assertTrue(value instanceof IntVal);
        Assert.assertEquals(288, ((IntVal)value).value);

    }
}
