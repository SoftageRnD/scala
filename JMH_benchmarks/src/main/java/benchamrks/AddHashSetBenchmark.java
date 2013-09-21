package benchamrks;

import benchamrks.states.addelements.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

/**
 * User: alex42rus
 * mvn clean install
 * java -jar target/microbenchmarks.jar ".*AddHashSetBenchmark.*"
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class AddHashSetBenchmark {

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddJava0_0(BlackHole bl, AddElementsCollisions0_0 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.javaHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddScala0_0(BlackHole bl, AddElementsCollisions0_0 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.scalaHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddNewHashSetScala0_0(BlackHole bl, AddElementsCollisions0_0 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.newHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.newHashSet);
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddJava20_2(BlackHole bl, AddElementsCollisions20_2 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.javaHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddScala20_2(BlackHole bl, AddElementsCollisions20_2 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.scalaHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddNewHashSetScala20_2(BlackHole bl, AddElementsCollisions20_2 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.newHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.newHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddJava20_16(BlackHole bl, AddElementsCollisions20_16 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.javaHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddScala20_16(BlackHole bl, AddElementsCollisions20_16 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.scalaHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddNewHashSetScala20_16(BlackHole bl, AddElementsCollisions20_16 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.newHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.newHashSet);
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddJava100_16(BlackHole bl, AddElementsCollisions100_16 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.javaHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddScala100_16(BlackHole bl, AddElementsCollisions100_16 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.scalaHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddNewHashSetScala100_16(BlackHole bl, AddElementsCollisions100_16 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.newHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.newHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddJava100_2(BlackHole bl, AddElementsCollisions100_2 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.javaHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddScala100_2(BlackHole bl, AddElementsCollisions100_2 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.scalaHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OperationsPerInvocation(value = 10000)
    public void timeAddNewHashSetScala100_2(BlackHole bl, AddElementsCollisions100_2 addHashSetBenchmarkState) {
        for (int i = 0; i < 10000; i++) {
            addHashSetBenchmarkState.newHashSet.add(addHashSetBenchmarkState.controlList.get(i));
        }
        bl.consume(addHashSetBenchmarkState.newHashSet);
    }
}
