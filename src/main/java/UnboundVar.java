public class UnboundVar extends EvalError {

    public static final String UNBOUND_VARIABLE = "Unbound variable: ";

    public UnboundVar() { super(); }
    public UnboundVar(String s) { super(s); }
}
