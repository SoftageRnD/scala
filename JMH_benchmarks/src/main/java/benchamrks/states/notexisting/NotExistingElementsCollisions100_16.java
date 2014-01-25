package benchamrks.states.notexisting;

import benchamrks.states.StateProperties;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * 1M objects
 * 100 - percents collision
 * 16 - collision deep
 */
@State(Scope.Thread)
public class NotExistingElementsCollisions100_16 extends NotExistingElementsState {

    @Setup(Level.Trial)
    public void up() {
        setUp(StateProperties.elementsCount, 100, 16);
    }

}
