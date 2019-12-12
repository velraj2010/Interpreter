public class IntConst extends Expr {
    public final IntVal _value;
    public IntConst(int value) {
	    _value = new IntVal(value);
    }
    public Value eval(Env e) throws EvalError {
	    return _value;
    }
    public String toString() {
	    return _value.toString();
    }
}
