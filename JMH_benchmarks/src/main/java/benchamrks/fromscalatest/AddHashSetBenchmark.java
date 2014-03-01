package benchamrks.fromscalatest;

import benchamrks.fromscalatest.states.AddHashSetBenchmarkState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class AddHashSetBenchmark {

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala1H(BlackHole bl, AddHashSetBenchmarkState state) {
        addScala(bl, state, 100000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala2H(BlackHole bl, AddHashSetBenchmarkState state) {
        addScala(bl, state, 200000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala3H(BlackHole bl, AddHashSetBenchmarkState state) {
        addScala(bl, state, 300000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala4H(BlackHole bl, AddHashSetBenchmarkState state) {
        addScala(bl, state, 400000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala5H(BlackHole bl, AddHashSetBenchmarkState state) {
        addScala(bl, state, 500000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala6H(BlackHole bl, AddHashSetBenchmarkState state) {
        addScala(bl, state, 600000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala7H(BlackHole bl, AddHashSetBenchmarkState state) {
        addScala(bl, state, 700000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala8H(BlackHole bl, AddHashSetBenchmarkState state) {
        addScala(bl, state, 800000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala9H(BlackHole bl, AddHashSetBenchmarkState state) {
        addScala(bl, state, 900000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala10H(BlackHole bl, AddHashSetBenchmarkState state) {
        addScala(bl, state, 1000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala1H(BlackHole bl, AddHashSetBenchmarkState state) {
        addNewScala(bl, state, 100000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala2H(BlackHole bl, AddHashSetBenchmarkState state) {
        addNewScala(bl, state, 200000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala3H(BlackHole bl, AddHashSetBenchmarkState state) {
        addNewScala(bl, state, 300000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala4H(BlackHole bl, AddHashSetBenchmarkState state) {
        addNewScala(bl, state, 400000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala5H(BlackHole bl, AddHashSetBenchmarkState state) {
        addNewScala(bl, state, 500000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala6H(BlackHole bl, AddHashSetBenchmarkState state) {
        addNewScala(bl, state, 600000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala7H(BlackHole bl, AddHashSetBenchmarkState state) {
        addNewScala(bl, state, 700000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala8H(BlackHole bl, AddHashSetBenchmarkState state) {
        addNewScala(bl, state, 800000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala9H(BlackHole bl, AddHashSetBenchmarkState state) {
        addNewScala(bl, state, 900000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala10H(BlackHole bl, AddHashSetBenchmarkState state) {
        addNewScala(bl, state, 1000000);
    }

    private void addScala(BlackHole bl, AddHashSetBenchmarkState state, int size) {
        for (Integer value : state.valuesMap.get(size)) {
            state.scalaHashSet.add(value);
        }
        bl.consume(state.scalaHashSet);
    }

    private void addNewScala(BlackHole bl, AddHashSetBenchmarkState state, int size) {
        for (Integer value : state.valuesMap.get(size)) {
            state.newHashSet.add(value);
        }
        bl.consume(state.newHashSet);
    }

}
