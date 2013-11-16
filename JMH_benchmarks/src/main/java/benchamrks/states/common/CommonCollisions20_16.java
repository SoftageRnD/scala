package benchamrks.states.common;

import benchamrks.states.HashSetBenchmark;
import benchamrks.states.StateProperties;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * 1M objects
 * 20 - percents collision
 * 16 - collision deep
 */
@State
public class CommonCollisions20_16 extends HashSetBenchmark {
    @Setup(Level.Trial)
    public void up() {
        setUp(StateProperties.elementsCount, 20, 16);

    }

}