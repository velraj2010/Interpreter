

/**
 * @author velraj.
 */
public class BinExp extends Expr {
    private final Expr _expr1;
    private final Expr _expr2;
    private final String _operator;

    public static final String OPERATION_NOT_SUPPORTED =
            "Evaluation error: Operation not supported for Binary Expression";

    public BinExp(Expr expr1, Expr expr2, String operator) {
        _expr1 = expr1;
        _expr2 = expr2;
        _operator = operator;
    }

    public Value eval(Env e) throws EvalError {
        BinOp binOp = BinOp.getBinOp(_operator);
        if(binOp == null) {
            throw new EvalError(OPERATION_NOT_SUPPORTED);
        }
        return ExprUtil.evaluate(_expr1.eval(e), _expr2, e, binOp);
    }

    public String toString() {
        return _expr1 + _operator + _expr2;
    }
}
