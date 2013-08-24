package benchamrks;

import benchamrks.states.ContainsNotExistsElementBenchmarkState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;

import java.util.ArrayList;
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
    public void containsJava0_0(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample1.javaHashSet.contains(hashSetBenchmark.sample1.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsScala0_0(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample1.scalaHashSet.contains(hashSetBenchmark.sample1.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsNewScala0_0(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample1.newHashSet.contains(hashSetBenchmark.sample1.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsJava20_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample2.javaHashSet.contains(hashSetBenchmark.sample2.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsScala20_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample2.scalaHashSet.contains(hashSetBenchmark.sample2.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsNewScala20_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample2.newHashSet.contains(hashSetBenchmark.sample2.control.get(i));
        }
        bl.consume(array);

    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsJava20_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample3.javaHashSet.contains(hashSetBenchmark.sample3.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsScala20_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample3.scalaHashSet.contains(hashSetBenchmark.sample3.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsNewScala20_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample3.newHashSet.contains(hashSetBenchmark.sample3.control.get(i));
        }
        bl.consume(array);

    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsNewScala100_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample4.newHashSet.contains(hashSetBenchmark.sample4.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsNewScala100_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample5.newHashSet.contains(hashSetBenchmark.sample5.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsScala100_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample4.scalaHashSet.contains(hashSetBenchmark.sample4.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsScala100_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample5.scalaHashSet.contains(hashSetBenchmark.sample5.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsJava100_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample4.javaHashSet.contains(hashSetBenchmark.sample4.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void containsJava100_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample5.javaHashSet.contains(hashSetBenchmark.sample5.control.get(i));
        }
        bl.consume(array);
    }

}
