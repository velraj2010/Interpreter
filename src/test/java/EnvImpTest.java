

import org.junit.Assert;
import org.junit.Test;

/**
 * @author velraj.
 */
public class EnvImpTest {

    public static final Env emptyEnv = new EnvImp();

    @Test
    public void testLookup() throws UnboundVar {
        try{
            Assert.assertEquals(true, emptyEnv.lookup(VarExpTest.varExpX.toString()));
        } catch (UnboundVar unboundVar) {
            Assert.assertEquals(UnboundVar.UNBOUND_VARIABLE + VarExpTest.varExpX, unboundVar.getMessage());
        }

    }
}
