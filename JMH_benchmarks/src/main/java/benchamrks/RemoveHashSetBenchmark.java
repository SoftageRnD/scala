package benchamrks;

import benchamrks.states.RemoveHashSetBenchmarkState;
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
    @OperationsPerInvocation(value = 1000)
    public void removeJava0_0(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample1.javaHashSet.remove(hashSetBenchmark.sample1.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeScala0_0(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample1.scalaHashSet.remove(hashSetBenchmark.sample1.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeNewScala0_0(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample1.newHashSet.remove(hashSetBenchmark.sample1.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeJava20_2(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample2.javaHashSet.remove(hashSetBenchmark.sample2.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeScala20_2(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample2.scalaHashSet.remove(hashSetBenchmark.sample2.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeNewScala20_2(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample2.newHashSet.remove(hashSetBenchmark.sample2.control.get(i));
        }
        bl.consume(array);

    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeJava20_16(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample3.javaHashSet.remove(hashSetBenchmark.sample3.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeScala20_16(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample3.scalaHashSet.remove(hashSetBenchmark.sample3.control.get(i));
        }
        bl.consume(array);

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeNewScala20_16(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample3.newHashSet.remove(hashSetBenchmark.sample3.control.get(i));
        }
        bl.consume(array);

    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeNewScala100_16(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample4.newHashSet.remove(hashSetBenchmark.sample4.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeNewScala100_2(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample5.newHashSet.remove(hashSetBenchmark.sample5.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeScala100_16(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample4.scalaHashSet.remove(hashSetBenchmark.sample4.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeScala100_2(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample5.scalaHashSet.remove(hashSetBenchmark.sample5.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeJava100_16(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample4.javaHashSet.remove(hashSetBenchmark.sample4.control.get(i));
        }
        bl.consume(array);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 1000)
    public void removeJava100_2(BlackHole bl, RemoveHashSetBenchmarkState hashSetBenchmark) {
        Object[] array = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = hashSetBenchmark.sample5.javaHashSet.remove(hashSetBenchmark.sample5.control.get(i));
        }
        bl.consume(array);
    }
}
