package benchamrks;

import benchamrks.states.StateProperties;
import benchamrks.states.notexisting.NotExistingElementsCollisions100_16;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

/**
 /**
 * mvn clean install
 * java -jar target/microbenchmarks.jar ".*CustomBenchmark.*"
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class CustomBenchmark  {

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void containsNewScala100_16(BlackHole bl, NotExistingElementsCollisions100_16 hashSetBenchmark) {
        for (int i = 0; i < hashSetBenchmark.control.size(); i++) {
            bl.consume(hashSetBenchmark.newHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void containsScala100_16(BlackHole bl, NotExistingElementsCollisions100_16 hashSetBenchmark) {
        for (int i = 0; i < hashSetBenchmark.control.size(); i++) {
            bl.consume(hashSetBenchmark.scalaHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void containsJava100_16(BlackHole bl, NotExistingElementsCollisions100_16 hashSetBenchmark) {
        for (int i = 0; i < hashSetBenchmark.control.size(); i++) {
            bl.consume(hashSetBenchmark.javaHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

}
