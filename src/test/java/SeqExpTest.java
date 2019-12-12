

import org.junit.Assert;
import org.junit.Test;

/**
 * @author velraj.
 */
public class SeqExpTest {
    @Test
    public void testEval() throws EvalError {
        String x = "x";
        //test let val x=36 in (if (false | {(x:=12) ;false}) then x else x) end
        SeqExp seqExp9 = new SeqExp(new AssnExp(VarExpTest.varExpX.toString(), IntConstTest.intConst12));
        seqExp9.addExpr(BoolConstExprTest.boolConstFalse);
        BinExp binExpOr = new BinExp(BoolConstExprTest.boolConstFalse, seqExp9, BinOp.OR.getOperator());
        IfExp ifExpFalse = new IfExp(binExpOr, VarExpTest.varExpX, VarExpTest.varExpX);
        LetValExp letValExp12 = new LetValExp(x, IntConstTest.intConst36, ifExpFalse);
        Value value = letValExp12.eval(new EnvImp());
        Assert.assertTrue(value instanceof IntVal);
        Assert.assertEquals(12, ((IntVal)value).value);

        //test {12+24;true}
        SeqExp seqExp = new SeqExp(BinExpTest.binExp36);
        seqExp.addExpr(BoolConstExprTest.boolConstTrue);
        value = seqExp.eval(new EnvImp());
        Assert.assertTrue(value instanceof  BoolVal);
        Assert.assertTrue(((BoolVal)value).value);
    }
}
