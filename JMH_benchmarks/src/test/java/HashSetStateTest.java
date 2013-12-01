import benchamrks.states.HashSetProbabilityState;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 12/1/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */

public class HashSetStateTest {

    @Test
    public void testProbabilityState() {
        HashSetProbabilityState state = new HashSetProbabilityState();
        state.setUp(100000, 20, 16);
        state.control.size();

    }
}
