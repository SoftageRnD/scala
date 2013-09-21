package benchamrks.states.notexisting;

import benchamrks.states.HashSetBenchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * 1M objects
 * 20 - percents collision
 * 2 - collision deep
 */
@State
public class NotExistingElementsCollisions20_2 extends NotExistingElementsState {

    @Setup(Level.Trial)
    public void up() {
        setUp(1000000, 20, 2);

    }

}
