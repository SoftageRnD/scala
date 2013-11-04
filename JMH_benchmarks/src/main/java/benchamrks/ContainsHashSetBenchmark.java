package benchamrks;


import benchamrks.states.common.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

/**
 * mvn clean install
 * java -jar target/microbenchmarks.jar ".*ContainsHashSetBenchmark.*"
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ContainsHashSetBenchmark {

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsJava0_0(BlackHole bl, CommonCollisions0_0 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.javaHashSet.contains(state.control.get(i));
        }
        bl.consume(array);

    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsScala0_0(BlackHole bl, CommonCollisions0_0 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.scalaHashSet.contains(state.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsNewScala0_0(BlackHole bl, CommonCollisions0_0 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.newHashSet.contains(state.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsJava20_2(BlackHole bl, CommonCollisions20_2 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.javaHashSet.contains(state.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsScala20_2(BlackHole bl, CommonCollisions20_2 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.scalaHashSet.contains(state.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsNewScala20_2(BlackHole bl, CommonCollisions20_2 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.newHashSet.contains(state.control.get(i));
        }
        bl.consume(array);

    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsJava20_16(BlackHole bl, CommonCollisions20_16 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.javaHashSet.contains(state.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsScala20_16(BlackHole bl, CommonCollisions20_16 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.scalaHashSet.contains(state.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsNewScala20_16(BlackHole bl, CommonCollisions20_16 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.newHashSet.contains(state.control.get(i));
        }
        bl.consume(array);

    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsNewScala100_16(BlackHole bl, CommonCollisions100_16 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.newHashSet.contains(state.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsScala100_16(BlackHole bl, CommonCollisions100_16 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.scalaHashSet.contains(state.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsJava100_16(BlackHole bl, CommonCollisions100_16 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.javaHashSet.contains(state.control.get(i));
        }
        bl.consume(array);
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsNewScala100_2(BlackHole bl, CommonCollisions100_2 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.newHashSet.contains(state.control.get(i));
        }
        bl.consume(array);
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsScala100_2(BlackHole bl, CommonCollisions100_2 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.scalaHashSet.contains(state.control.get(i));
        }
        bl.consume(array);
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    @Fork(10)
    public void containsJava100_2(BlackHole bl, CommonCollisions100_2 state) {
        Object[] array = new Object[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = state.javaHashSet.contains(state.control.get(i));
        }
        bl.consume(array);
    }

}