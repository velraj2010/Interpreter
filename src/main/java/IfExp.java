

/**
 * @author velraj.
 */
public class IfExp extends Expr {
    public static final String EXPR_NOT_BOOLEAN = "Error: test expression in if is not of type bool [overload conflict]";
    public static final String OPERATOR_OPERAND_DO_NOT_AGREE
            = "Error: types of if branches do not agree [overload conflict]";

    private final Expr _expr1;
    private final Expr _expr2;
    private final Expr _expr3;


    public IfExp(Expr e1, Expr e2, Expr e3) {
        _expr1 = e1;
        _expr2 = e2;
        _expr3 = e3;
    }

    public Value eval(Env e) throws EvalError {
        Value expr1Val = _expr1.eval(e);
        if(!(expr1Val instanceof BoolVal)) {
            throw new EvalError(EXPR_NOT_BOOLEAN);
        }
        Value expr2Val = _expr2.eval(e);
        if(((BoolVal) expr1Val).value) {
            return _expr2.eval(e);
        }
        Value expr3Val = _expr3.eval(e);
        if(expr2Val.getClass() != expr3Val.getClass()){
            throw new EvalError(OPERATOR_OPERAND_DO_NOT_AGREE);
        }
        return _expr3.eval(e);
    }

    public String toString() {
        return "if " + _expr1 + " then " + _expr2 + " else " + _expr3;
    }
}
