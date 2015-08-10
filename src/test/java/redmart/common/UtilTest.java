package redmart.common;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sathya on 10/8/15.
 */
public class UtilTest {

    @Test
    public void testCanParseAsInt() {
        assertTrue(Util.canParseAsInt("100"));
        assertTrue(Util.canParseAsInt("0"));

        assertFalse(Util.canParseAsInt("abc"));
    }

    @Test
    public void testEnsure() {
        Util.ensure(true, "message");
        //no exception

        try {
            Util.ensure(false, "message");
            assertTrue(false);
        } catch (RedmartException e) {
            assertEquals("message", e.getMessage());
        }
    }
}
