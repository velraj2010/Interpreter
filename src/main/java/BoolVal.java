/**
 * @author velraj.
 */
public class BoolVal extends Value {
    public final boolean value;
    public BoolVal(boolean val) {
        value = val;
    }
    public String toString() {
        return String.valueOf(value);
    }
}
