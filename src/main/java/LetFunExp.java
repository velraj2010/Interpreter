
/**
 * @author velraj.
 */
public class LetFunExp extends Expr {


    private final String _funName;
    private final Expr _expr1;
    private final String _inputVar;
    private final Expr _expr2;
    private FunVal _funVal;


    public LetFunExp(String funName, String inputVar, Expr expr1, Expr expr2) {
        _funName = funName;
        _inputVar = inputVar;
        _expr1 = expr1;
        _expr2 = expr2;
    }

    public Value eval(Env e) throws EvalError {
        _funVal = new FunVal(_inputVar, _expr1, e);
        e = e.addBinding(_funName, _funVal);
        return _expr2.eval(e);
    }

    public String toString() {
        return "let fun " +_funName + "(" + _inputVar + ") = " + _expr1
                + " in " + _expr2 + " end" ;
    }
}
