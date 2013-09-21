package benchamrks.states.notexisting;

import benchamrks.HashObject;
import benchamrks.states.HashSetBenchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;

/**
 * 1M objects
 * 100 - percents collision
 * 16 - collision deep
 */
@State
public class NotExistingElementsCollisions100_16 extends NotExistingElementsState {

    @Setup(Level.Trial)
    public void up() {
        setUp(1000000, 100, 16);
    }

}
