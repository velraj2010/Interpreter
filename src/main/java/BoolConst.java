/**
 * @author velraj.
 */
public class BoolConst extends Expr {
    private final BoolVal _boolVal;
    public BoolConst(boolean val) {
        _boolVal = new BoolVal(val);
    }

    public Value eval(Env e) throws EvalError {
        return _boolVal;
    }

    public String toString() {
        return _boolVal.toString();
    }

}
