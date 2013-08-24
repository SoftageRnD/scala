package benchamrks.states;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State
public class RemoveHashSetBenchmarkState {
    /**
     * 100000, 0, 0
     */
    public HashSetBenchmark sample1;

    /**
     * 100000, 20, 2
     */
    public HashSetBenchmark sample2;

    /**
     * 100000, 20, 16
     */
    public HashSetBenchmark sample3;

    /**
     * 100000, 100, 16
     */
    public HashSetBenchmark sample4;

    /**
     * 100000, 100, 2
     */
    public HashSetBenchmark sample5;

    @Setup(Level.Trial)
    public void up() {
        sample1 = new HashSetBenchmark();
        sample1.setUp(100000, 0, 0);

        sample2 = new HashSetBenchmark();
        sample2.setUp(100000, 20, 2);

        sample3 = new HashSetBenchmark();
        sample3.setUp(100000, 20, 16);

        sample4= new HashSetBenchmark();
        sample4.setUp(100000, 100, 16);

        sample5 = new HashSetBenchmark();
        sample5.setUp(100000, 100, 2);
    }


}
