package benchamrks.states.common;

import benchamrks.states.HashSetBenchmarkState;
import benchamrks.states.HashSetProbabilityState;
import benchamrks.states.StateProperties;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * 1M objects
 * 20 - percents collision
 * 2 - collision deep
 */
@State(Scope.Thread)
public class CommonCollisions20_2 extends HashSetProbabilityState {

    @Setup(Level.Trial)
    public void up() {
        setUp(StateProperties.elementsCount, 20, 2);

    }

}
