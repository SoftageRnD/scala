package benchamrks.states.addelements;

import benchamrks.states.notexisting.NotExistingElementsState;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * 1M objects
 * 100 - percents collision
 * 16 - collision deep
 */
@State
public class AddElementsCollisions100_16 extends AddElementsState {

    @Setup(Level.Trial)
    public void up() {
        setUp(1000000, 100, 16);
    }

}
