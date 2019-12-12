

/**
 * @author velraj.
 */
public class VarExp extends Expr {
    private String _id;
    public VarExp(String id) {
        _id = id;
    }

    public Value eval(Env e) throws EvalError {
        return e.lookup(_id);
    }

    public String toString() {
        return _id;
    }
}
