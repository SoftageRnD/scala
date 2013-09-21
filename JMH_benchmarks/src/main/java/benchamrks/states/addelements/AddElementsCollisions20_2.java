package benchamrks.states.addelements;

import benchamrks.states.notexisting.NotExistingElementsState;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * 1M objects
 * 20 - percents collision
 * 2 - collision deep
 */
@State
public class AddElementsCollisions20_2 extends AddElementsState {

    @Setup(Level.Trial)
    public void up() {
        setUp(1000000, 20, 2);

    }

}
