public enum BinOp {
    PLUS("+", Type.ARITHMETIC),
    MINUS("-", Type.ARITHMETIC),
    TIMES("*", Type.ARITHMETIC),
    DIV("/", Type.ARITHMETIC),
    EQ("=", Type.RELATIONAL),
    LT("<", Type.RELATIONAL),
    AND("&", Type.LOGICAL),
    OR("|", Type.LOGICAL);

    private Type _type;
    private String _operation;
    BinOp(String operation, Type type) {
        _operation = operation;
        _type = type;

    }
    public Type getType(){
        return _type;
    }
    public String getOperator(){
        return _operation;
    }

    public enum Type{
        ARITHMETIC, RELATIONAL, LOGICAL
    }



    public static BinOp getBinOp(String operation) {
        for(BinOp binOp : BinOp.values()) {
            if(binOp._operation.equals(operation)) {
                return binOp;
            }
        }
        return null;
    }
}
