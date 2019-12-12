

/**
 * @author velraj.
 */
public class NotExp extends Expr {

    private Expr _expr;
    public NotExp(Expr expr) {
        _expr= expr;
    }
    public Value eval(Env e) throws EvalError {
        Value result = _expr.eval(e);
        if(!(result instanceof BoolVal)) {
            throw new EvalError(EvalError.INCOMPATIBLE_ARG_TYPES);
        }
        return new BoolVal(!((BoolVal) result).value);
    }

    public String toString() {
        return String.valueOf("!" + _expr.toString());
    }
}
