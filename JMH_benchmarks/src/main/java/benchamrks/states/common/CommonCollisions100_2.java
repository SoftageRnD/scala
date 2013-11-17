package benchamrks.states.common;

import benchamrks.states.HashSetBenchmarkState;
import benchamrks.states.HashSetProbabilityState;
import benchamrks.states.StateProperties;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * 1M objects
 * 100 - percents collision
 * 2 - collision deep
 */
@State
public class CommonCollisions100_2 extends HashSetProbabilityState {

    @Setup(Level.Trial)
    public void up() {
        setUp(StateProperties.elementsCount, 100, 2);

    }

}