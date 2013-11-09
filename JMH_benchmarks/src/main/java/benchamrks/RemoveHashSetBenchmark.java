package benchamrks;

import benchamrks.states.StateProperties;
import benchamrks.states.common.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

/**
 * mvn clean install
 * java -jar target/microbenchmarks.jar ".*RemoveHashSetBenchmark.*"
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class RemoveHashSetBenchmark {

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeJava0_0(BlackHole bl, CommonCollisions0_0 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.javaHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeScala0_0(BlackHole bl, CommonCollisions0_0 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.scalaHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeNewScala0_0(BlackHole bl, CommonCollisions0_0 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.newHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeJava20_2(BlackHole bl, CommonCollisions20_2 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.javaHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeScala20_2(BlackHole bl, CommonCollisions20_2 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.scalaHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeNewScala20_2(BlackHole bl, CommonCollisions20_2 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.newHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);

    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeJava20_16(BlackHole bl, CommonCollisions20_16 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.javaHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeScala20_16(BlackHole bl, CommonCollisions20_16 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.scalaHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeNewScala20_16(BlackHole bl, CommonCollisions20_16 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.newHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);

    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeNewScala100_16(BlackHole bl, CommonCollisions100_16 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.newHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeNewScala100_2(BlackHole bl, CommonCollisions100_2 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.newHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeScala100_16(BlackHole bl, CommonCollisions100_16 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.scalaHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeScala100_2(BlackHole bl, CommonCollisions100_2 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.scalaHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeJava100_16(BlackHole bl, CommonCollisions100_16 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.javaHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = StateProperties.operationPerInvocation)
    @Fork(10)
    public void removeJava100_2(BlackHole bl, CommonCollisions100_2 hashSetBenchmark) {
        Object[] array = new Object[StateProperties.operationPerInvocation];
        for (int i = 0; i < StateProperties.operationPerInvocation; i++) {
            array[i] = hashSetBenchmark.javaHashSet.remove(hashSetBenchmark.control.get(i));
        }
        bl.consume(array);
    }
}
