

/**
 * @author velraj.
 */
public class LetValExp extends Expr {

    private String _id;
    private Expr _decExpr;
    private Expr _expr;
    private Env _env;

    public LetValExp(String id, Expr decExpr, Expr expr){
        _id = id;
        _decExpr = decExpr;
        _expr = expr;
    }

    public Env getEnv() {
        return _env;
    }

    public void setEnv(Env env) {
        _env = env;
    }

    public Value eval(Env e) throws EvalError {
        if((_decExpr==null) || (_expr==null)){
            throw new EvalError(EvalError.EXPRESSION_INVALID);
        }
        Value decValue = _decExpr.eval(e);
        _env = e.addBinding(_id, decValue);
        return _expr.eval(_env);
    }

    public String toString() {
        return "let val " + _id.toString() + "=" + _decExpr+ " in " + _expr;
    }
}
