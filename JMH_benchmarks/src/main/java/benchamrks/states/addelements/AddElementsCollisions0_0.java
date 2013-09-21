package benchamrks.states.addelements;

import benchamrks.states.notexisting.NotExistingElementsState;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * 1M objects
 * 0 - percents collision
 * 0 - collision deep
 */
@State
public class AddElementsCollisions0_0 extends AddElementsState {

    @Setup(Level.Trial)
    public void up() {
        setUp(1000000, 0, 0);

    }
}