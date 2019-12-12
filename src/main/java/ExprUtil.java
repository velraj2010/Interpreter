

/**
 * @author velraj.
 */
public final class ExprUtil {
    private ExprUtil(){}

    public static Value evaluate(Value value1, Expr expr2, Env env, BinOp binOp) throws EvalError{

        switch (binOp.getType()) {
            case ARITHMETIC:
                return evaluateArithmetic(value1, expr2, env, binOp);
            case LOGICAL:
                if(value1 instanceof IntVal) {
                    return evaluateArithmetic(value1, expr2, env, binOp);
                }
                return evaluateLogical(value1, expr2 , env, binOp);
            case RELATIONAL:
                if(value1 instanceof IntVal) {
                    return evaluateRelational(value1, expr2, env, binOp);
                }
                return evaluateLogical(value1, expr2, env, binOp);
        }
        return null;
    }

    private static Value evaluateArithmetic(Value value1, Expr expr2, Env env, BinOp binOp) throws EvalError {
        Value value2 = expr2.eval(env);
        if(!(value2 instanceof IntVal)
                || !(value1 instanceof IntVal)) {
            throw new EvalError(EvalError.INCOMPATIBLE_ARG_TYPES);
        }
        IntVal intVal1 = (IntVal) value1;
        IntVal intVal2 = (IntVal) value2;
        switch (binOp) {
            case PLUS:
                return new IntVal(intVal1.value + intVal2.value);
            case MINUS:
                return new IntVal(intVal1.value - intVal2.value);
            case TIMES:
                return new IntVal(intVal1.value * intVal2.value);
            case DIV:
                return new IntVal(intVal1.value / intVal2.value);
            case OR:
                return new IntVal(intVal1.value | intVal2.value);
            case AND:
                return new IntVal(intVal1.value & intVal2.value);
            default:
                return null;
        }
    }

    private static Value evaluateLogical(Value value1, Expr expr2, Env env, BinOp binOp) throws EvalError {

        BoolVal boolVal1 = (BoolVal) value1;
        switch (binOp) {
            case OR:
                if(!boolVal1.value){
                    Value value2 = expr2.eval(env);
                    if(!(value2 instanceof BoolVal)) {
                        throw new EvalError(EvalError.INCOMPATIBLE_ARG_TYPES);
                    }
                    return value2;
                }
                return new BoolVal(true);
            case AND:
                if(boolVal1.value){
                    Value value2 = expr2.eval(env);
                    if(!(value2 instanceof BoolVal)) {
                        throw new EvalError(EvalError.INCOMPATIBLE_ARG_TYPES);
                    }
                    return value2;
                }
                return new BoolVal(false);
            case EQ:
                Value value2 = expr2.eval(env);
                if(!(value2 instanceof BoolVal)) {
                    throw new EvalError(EvalError.INCOMPATIBLE_ARG_TYPES);
                }
                return new BoolVal(boolVal1.value == ((BoolVal) value2).value);
            default:
                return null;
        }
    }

    private static Value evaluateRelational(Value value1, Expr expr2, Env env, BinOp binOp) throws EvalError {
        Value value2 = expr2.eval(env);
        if(!(value1 instanceof IntVal) ||
                !(value2 instanceof IntVal)) {
            throw new EvalError(EvalError.INCOMPATIBLE_ARG_TYPES);
        }
        IntVal intVal1 = (IntVal) value1;
        IntVal intVal2 = (IntVal) value2;
        switch (binOp) {
            case LT:
                return new BoolVal(intVal1.value < intVal2.value);
            case EQ:
                return new BoolVal(intVal1.value == intVal2.value);
            default:
                return null;
        }
    }

}
