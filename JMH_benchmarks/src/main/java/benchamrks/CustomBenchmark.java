package benchamrks;

import benchamrks.states.StateProperties;
import benchamrks.states.notexisting.NotExistingElementsCollisions20_16;
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
    @OperationsPerInvocation(value = 1000)
    public void containsNewScala20_16(BlackHole bl, NotExistingElementsCollisions20_16 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.newHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsScala20_16(BlackHole bl, NotExistingElementsCollisions20_16 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.scalaHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsJava20_16(BlackHole bl, NotExistingElementsCollisions20_16 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.javaHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

}
