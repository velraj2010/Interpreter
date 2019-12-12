

/**
 * @author velraj.
 */
public class WhileExp extends Expr {

    private final Expr _expr1;
    private final Expr _expr2;
    static final String TEST_NOT_BOOLEAN = "Evaluation error: Test condition is not a boolean expression ";

    public WhileExp(Expr expr1, Expr expr2) {
        _expr1 = expr1;
        _expr2 = expr2;
    }

    public Value eval(Env e) throws EvalError {
        Value val1 = _expr1.eval(e);
        if(!(val1 instanceof BoolVal)) {
            throw new EvalError(TEST_NOT_BOOLEAN);
        }
        Value val2 = new BoolVal(false);
        while( ((BoolVal)val1).value ) {
            val2 = _expr2.eval(e);
            val1 = _expr1.eval(e);
        }
        return val2;
    }

    public String toString() {
        return "while " + _expr1.toString() + " do " + _expr2.toString();
    }
}
