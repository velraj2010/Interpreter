/**
 * @author velraj.
 */
public class EnvImp implements Env {
    private EnvImp.EnvCell root;

    public EnvImp() {
        this.root = null;
    }

    private EnvImp(EnvImp.EnvCell var1) {
        this.root = var1;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public Value lookup(String var1) throws UnboundVar {
        for(EnvImp.EnvCell var2 = this.root; var2 != null; var2 = var2.next) {
            if (var2.var.equals(var1)) {
                return var2.val;
            }
        }

        throw new UnboundVar("Unbound variable: " + var1);
    }

    public Env addBinding(String var1, Value var2) {
        EnvImp.EnvCell var3 = new EnvImp.EnvCell(var1, var2, this.root);
        return new EnvImp(var3);
    }

    public Env updateBinding(String var1, Value var2) throws UnboundVar {
        for(EnvImp.EnvCell var3 = this.root; var3 != null; var3 = var3.next) {
            if (var3.var.equals(var1)) {
                var3.val = var2;
                return this;
            }
        }

        throw new UnboundVar("Unbound variable: " + var1);
    }

    public String toString() {
        return "ENV";
    }

    private static class EnvCell {
        String var;
        Value val;
        EnvImp.EnvCell next;

        EnvCell(String var1, Value var2, EnvImp.EnvCell var3) {
            this.var = var1;
            this.val = var2;
            this.next = var3;
        }
    }
}
