

/**
 * @author velraj.
 */
public class FunVal extends Value {
    private final String _inputVar;
    private final Expr _expr;
    private final Env _env;
    public FunVal(String inputVar, Expr expr, Env env) {
        _inputVar = inputVar;
        _expr = expr;
        _env = env;
    }

    public Env getEnv() {
        return _env;
    }

    public String getInputVar() {
        return _inputVar;
    }

    public Expr getExpr() {
        return _expr;
    }

    public String toString() {
        return "( " + _inputVar + " ) -> ( " +_expr + " )" ;
    }
}
