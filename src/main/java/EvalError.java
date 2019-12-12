public class EvalError extends Exception {
    public static final String INCOMPATIBLE_ARG_TYPES = "Evaluation error: Incompatible arg types";
    public static final String EXPRESSION_INVALID = "Evaluation error: Input Expression is invalid";

    EvalError() { super(); }
    public EvalError(String s) { super(s); }
}
