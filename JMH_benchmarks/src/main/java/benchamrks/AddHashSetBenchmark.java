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
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class AddHashSetBenchmark {

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addJava0_0(BlackHole bl, AddElementsCollisions0_0 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.javaHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addScala0_0(BlackHole bl, AddElementsCollisions0_0 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.scalaHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addNewScala0_0(BlackHole bl, AddElementsCollisions0_0 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.newHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.newHashSet);
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addJava20_2(BlackHole bl, AddElementsCollisions20_2 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.javaHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addScala20_2(BlackHole bl, AddElementsCollisions20_2 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.scalaHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addNewScala20_2(BlackHole bl, AddElementsCollisions20_2 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.newHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.newHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addJava20_16(BlackHole bl, AddElementsCollisions20_16 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.javaHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addScala20_16(BlackHole bl, AddElementsCollisions20_16 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.scalaHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addNewScala20_16(BlackHole bl, AddElementsCollisions20_16 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.newHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.newHashSet);
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addJava100_16(BlackHole bl, AddElementsCollisions100_16 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.javaHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addScala100_16(BlackHole bl, AddElementsCollisions100_16 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.scalaHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addNewScala100_16(BlackHole bl, AddElementsCollisions100_16 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.newHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.newHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addJava100_2(BlackHole bl, AddElementsCollisions100_2 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.javaHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addScala100_2(BlackHole bl, AddElementsCollisions100_2 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.scalaHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(20)

    public void addNewScala100_2(BlackHole bl, AddElementsCollisions100_2 state) {
        for (int i = 0; i < state.controlList.size(); i++) {
            state.newHashSet.add(state.controlList.get(i));
        }
        bl.consume(state.newHashSet);
    }
}
