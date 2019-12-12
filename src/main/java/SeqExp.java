

import java.util.ArrayList;
import java.util.List;

/**
 * @author velraj.
 */
public class SeqExp extends Expr {

    private final List<Expr> _exprList = new ArrayList<Expr>();

    public SeqExp(Expr expr) {
        _exprList.add(expr);
    }

    public void addExpr(Expr expr){
        _exprList.add(expr);
    }

    public Value eval(Env e) throws EvalError {
        Value value = null;
        for(Expr expr : _exprList) {
            if(expr == null) {
                throw new EvalError(EvalError.EXPRESSION_INVALID);
            }
            value = expr.eval(e);
            if(expr instanceof AssnExp) {
                e = ((AssnExp)expr).getEnv();
            }
        }
        return value;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");
        for(Expr expr : _exprList) {
            stringBuilder.append(expr.toString());
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
