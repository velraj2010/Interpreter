

import org.junit.Assert;
import org.junit.Test;

/**
 * @author velraj.
 */
public class WhileExpTest {

    WhileExp whileExpTestNotBoolean = new WhileExp(IntConstTest.intConst12, IntConstTest.intConst24);

    //while x do x:=false
    WhileExp whileExpTestFalse =
            new WhileExp(VarExpTest.varExpX,
                    new AssnExp(VarExpTest.varExpX.toString(), BoolConstExprTest.boolConstFalse));

    @Test
    public void testEval() throws EvalError {
        try{
            whileExpTestNotBoolean.eval(new EnvImp());
            throw new EvalError("Should not have come here");
        }
        catch (EvalError error) {
            Assert.assertEquals(WhileExp.TEST_NOT_BOOLEAN, error.getMessage());
        }
        //let x = true in while x do x:=false end;
        LetValExp letValExpWithWhile = new LetValExp(VarExpTest.varExpX.toString(), BoolConstExprTest.boolConstTrue,
                whileExpTestFalse);
        Value value = letValExpWithWhile.eval(new EnvImp());
        Assert.assertTrue(value instanceof BoolVal);
        Assert.assertFalse(((BoolVal)value).value);
    }
}
