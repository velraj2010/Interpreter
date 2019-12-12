

import org.antlr.runtime.RecognitionException;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author velraj.
 */
public class InterpretMainTest {

    private Env _env = new EnvImp();
    private final String x = "x";
    private final String y = "y";

    Expr idConstX = new VarExp(x);
    Expr idConstY = new VarExp(y);
    private final Value intValue10 = new IntVal(10);
    private final Value intValue17 = new IntVal(17);

    private final Expr intConst10 = new IntConst(10);
    private final Expr intConst12 = new IntConst(12);
    private final Expr intConst5 = new IntConst(5);

    @Test
    public void testEvalWithParser_ERRORS() throws EvalError, IOException, RecognitionException {
        //err1.sml
        testParseError("3 * 2 + 4);", false);
        //err2.sml
        testParseError("let  fun cube(x) = x * x * x  cube(2) end;", true);
        //err3.sml
        testParseError("let val y = 2 in  let fun mult( x,y ) = x * y  in mult(3) * 4 end;",false);
        //err4.sml
        testParseError("let  val x : = 3 in if true | ({x := 9; false}) then x else x end;",false);
        //err5.sml
        testParseError("let  val x = 3 in if false & ({x : = 9; false}) then x else x end",true);
        //err6.sml
        testParseError("1 < 2 < 3;", false);
        //err7.sml
        testParseError("1", false);
        //err8.sml
        testParseError("let val x < 2 in x end;", false);
        //err9.sml
        testParseError("let fun f(x) < x * x in f(2) end;", false);
    }

    @Test
    public void testEvalWithParser_EXPRESSIONS() throws EvalError, IOException, RecognitionException {
        //expr1.sml
        testExpression("3 * (2 + 4);", String.valueOf(18));
        //expr2.sml
        testExpression("let fun cube(x) = x * x * x in  cube(2) end;", String.valueOf(8));
        //expr3.sml
        testExpression("let val y = 2 in let fun mult( x ) = x * y in mult(3) * 4 end end;", String.valueOf(24));
        //expr4.sml
        testExpression("let  val x = 3 in if true | ({x := 9; false}) then x else x end;", String.valueOf(3));
        //expr5.sml
        testExpression("let val x = 3 in if false & ({x := 9; false}) then x else x end;", String.valueOf(3));
        //expr6.sml
        testExpression("let val x = 3 in if false | ({x := 9; false}) then x else x end;", String.valueOf(9));
        //expr7.sml
        testExpression("let val x = 3 in if true & ({x := 9; false}) then x else x end;", String.valueOf(9));
        //expr8.sml
        testExpression("let val x = 3 in if true = ({x:=9; false}) then x else x end;", String.valueOf(9));
        //expr9.sml
        testExpression("let val x = 9 in let  fun sum(x) = x + 2 in  sum(4) + x end end;", String.valueOf(15));
        //expr10.sml
        testExpression("let val x = 2 in let  fun f(y) = y + x in  let   val x = 3  in   f(1)  end end end;", String.valueOf(3));
        //expr11.sml
        testExpression("let fun fact(x) = if x < 2 then 1 else x * fact( x - 1) in fact(6) end;", String.valueOf(720));
        //expr12.sml
        testExpression("let  fun fibo(x) = if x = 1 then 1 else if x = 2 then 1 else fibo(x-1) +  fibo(x-2) in  fibo(10) end;", String.valueOf(55));
        //expr13.sml
        testExpression("let val x = 0 in { if 2 < 3 then x := 1 else x := 5 ; x } end;", String.valueOf(1));
        //expr14.sml
        testExpression("let  val x = 0 in { if 2 = 3 then x := 1 else x := 5 ; x } end;", String.valueOf(5));
        //expr15.sml
        testExpression("let  val x = 1 in  { while x < 100 do x := x * 2; x } end;", String.valueOf(128));
        //expr16.sml
        testExpression("x := 12;", "Unbound variable: x");
        //expr17.sml
        testExpression("let val x = 0 in x := false end;", "Evaluation error: Incompatible types in assignment");
        //expr18.sml
        testExpression("let val x = 2 in (let val y = 3 in x * y end) * ({ x := 7; x + 2 }) end;", String.valueOf(54));
        //expr19.sml
        testExpression("let val x = 101 in (let fun g(x) = ( { while x < 10 do x := x + 3; x } ) in g(6) end) * x end;", String.valueOf(1212));
        //expr20.sml
        testExpression("let  fun f(x) = let fun g(y) = x + y in g(2) end in   f(3) end; ", String.valueOf(5));
        //expr21.sml
        testExpression("let fun f(h) = h(5) in f(let fun g(x) = x*x in g end) end;", String.valueOf(25));
        //expr22.sml
        testExpression("let  fun sq(x) = x * x in  let  fun applyTwice(f) = f(f(2))  in   applyTwice(sq)  end end;", String.valueOf(16));
        //expr23.sml
        testExpression("1 = 2;", String.valueOf(false));
        //expr24.sml
        testExpression("!2+3;", "Evaluation error: Incompatible arg types");
        //ok1.sml
        testExpression("let fun sq ( x ) = x*x in let fun applyTwice ( f ) = f(f(2)) in applyTwice ( sq ) end end ;", String.valueOf(16));
        //ok2.sml
        testExpression("let  val  x  =  1 in  x  *  x end     ;", String.valueOf(1));


    }

    private void testExpression(String input, String output) throws IOException, RecognitionException {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            Value value = InterpretMain.evaluateExprWithParser(inputStream);
            Assert.assertEquals(output, value.toString());
        } catch (EvalError error) {
            Assert.assertEquals(output, error.getMessage());
        }
    }

    private void testParseError(String input, boolean expectToThrowEvalError) throws IOException, RecognitionException {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            Value value = InterpretMain.evaluateExprWithParser(inputStream);
            if(expectToThrowEvalError) {
                throw new EvalError("Should have not come here");
            }
        } catch (EvalError error) {
            Assert.assertEquals(EvalError.EXPRESSION_INVALID, error.getMessage());
        }
    }

    private void setupEnv(){
        _env = new EnvImp();
        _env = _env.addBinding(x, intValue10);
        _env = _env.addBinding(y, intValue17);
    }

    @Test
    public void testEvaluateExpr_BinaryExpr() throws EvalError {
        setupEnv(); //x:10, y:17
        //test 5+10 < (12+10);
        Expr arithExpr1 = new BinExp(intConst5, intConst10, BinOp.PLUS.getOperator());
        Expr arithExpr2 = new BinExp(intConst12, intConst10, BinOp.PLUS.getOperator());
        Expr relExpr1 = new BinExp(arithExpr1, arithExpr2, BinOp.LT.getOperator());
        Value value = relExpr1.eval(_env);
        Assert.assertTrue(value instanceof BoolVal);
        Assert.assertEquals(String.valueOf(true), value.toString());

        // test x < (y+5);
        arithExpr1 = new BinExp(idConstY, intConst5, BinOp.PLUS.getOperator());
        relExpr1 = new BinExp(idConstX, arithExpr1, BinOp.LT.getOperator());
        value = relExpr1.eval(_env);
        Assert.assertTrue(value instanceof BoolVal);

    }
}
