package benchamrks;

import benchamrks.states.StateProperties;
import benchamrks.states.notexisting.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

/**
 * mvn clean install
 * java -jar target/microbenchmarks.jar ".*ContainsNotExistsElementBenchmark.*"
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ContainsNotExistsElementBenchmark {
    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsJava0_0(BlackHole bl, NotExistingElementsCollisions0_0 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.javaHashSet.contains(hashSetBenchmark.control.get(i)));
        }

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsScala0_0(BlackHole bl, NotExistingElementsCollisions0_0 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.scalaHashSet.contains(hashSetBenchmark.control.get(i)));
        }

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsNewScala0_0(BlackHole bl, NotExistingElementsCollisions0_0 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.newHashSet.contains(hashSetBenchmark.control.get(i)));
        }

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsJava20_2(BlackHole bl, NotExistingElementsCollisions20_2 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.javaHashSet.contains(hashSetBenchmark.control.get(i)));
        }

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsScala20_2(BlackHole bl, NotExistingElementsCollisions20_2 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.scalaHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsNewScala20_2(BlackHole bl, NotExistingElementsCollisions20_2 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.newHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsJava20_16(BlackHole bl, NotExistingElementsCollisions20_16 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.javaHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsScala20_16(BlackHole bl, NotExistingElementsCollisions20_16 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.scalaHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsNewScala20_16(BlackHole bl, NotExistingElementsCollisions20_16 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.newHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsNewScala100_16(BlackHole bl, NotExistingElementsCollisions100_16 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.newHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsScala100_16(BlackHole bl, NotExistingElementsCollisions100_16 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.scalaHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsJava100_16(BlackHole bl, NotExistingElementsCollisions100_16 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.javaHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsNewScala100_2(BlackHole bl, NotExistingElementsCollisions100_2 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.newHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsScala100_2(BlackHole bl, NotExistingElementsCollisions100_2 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.scalaHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    @Fork(10)
    public void containsJava100_2(BlackHole bl, NotExistingElementsCollisions100_2 hashSetBenchmark) {
        for (int i = 0; i < 1000; i++) {
            bl.consume(hashSetBenchmark.javaHashSet.contains(hashSetBenchmark.control.get(i)));
        }
    }
}
