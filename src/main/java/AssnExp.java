/**
 * @author velraj.
 */
public class AssnExp extends Expr {
    private String _id;
    private Expr _expr;
    private Env _env;

    public final static String INCOMPATIBLE_TYPE_ASSIGNMENT = "Evaluation error: Incompatible types in assignment";

    public AssnExp(String id, Expr expr) {
        _id = id;
        _expr = expr;
    }

    public Env getEnv(){
        return _env;
    }

    public Value eval(Env e) throws EvalError {
        Value currVal = e.lookup(_id);
        Value newVal  = _expr.eval(e);
        if(currVal.getClass() != newVal.getClass()) {
            throw new EvalError(INCOMPATIBLE_TYPE_ASSIGNMENT);
        }
        _env = e.updateBinding(_id, newVal);
        return newVal;
    }

    public String toString() {
        return _id + ":=" + _expr.toString();
    }
}
