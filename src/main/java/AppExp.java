

/**
 * @author velraj.
 */
public class AppExp extends Expr {

    public static final String NOT_VALID_FUNTION = "Evaluation error. Not a function: ";
    private final String _funName;
    private final Expr _expr;

    public AppExp(String funName, Expr expr) {
        _funName = funName;
        _expr = expr;
    }

    public Value eval(Env e) throws EvalError {
        Value value = e.lookup(_funName);
        if(!(value instanceof FunVal)) {
            throw new EvalError(NOT_VALID_FUNTION);
        }
        FunVal funVal = (FunVal)value;
        Env funEnv = funVal.getEnv();
        try{
            funEnv.lookup(_funName);
        } catch (EvalError error) {
            funEnv = funEnv.addBinding(_funName, funVal);
        }
        Value funParamVal = _expr.eval(e);
        funEnv = funEnv.addBinding(funVal.getInputVar(), funParamVal);
        return funVal.getExpr().eval(funEnv);
    }

    public String toString() {
        return _funName + "(" + _expr + ")";
    }
}
