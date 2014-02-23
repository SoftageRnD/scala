package benchamrks.fromscalatest;

import benchamrks.fromscalatest.states.HashSetBenchmarkState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class AddHashSetBenchmark {

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    public void addScala3M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 3000000);
    }

    /*@GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala4M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 4000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala5M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 5000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala6M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 6000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala7M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 7000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala9M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 9000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala10M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 10000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala11M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 11000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala12M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 12000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala13M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 13000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala14M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 14000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addScala15M(BlackHole bl, HashSetBenchmarkState state) {
        addScala(bl, state, 15000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala3M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 3000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala4M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 4000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala5M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 5000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala6M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 6000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala7M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 7000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala8M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 8000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala9M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 9000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala10M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 10000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala11M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 11000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala12M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 12000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala13M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 13000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala14M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 14000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void addNewScala15M(BlackHole bl, HashSetBenchmarkState state) {
        addNewScala(bl, state, 15000000);
    }*/

    private void addScala(BlackHole bl, HashSetBenchmarkState state, int size) {
        for (Integer value : state.valuesMap.get(size)) {
            state.scalaHashSet.add(value);
        }
        bl.consume(state.scalaHashSet);
    }

    private void addNewScala(BlackHole bl, HashSetBenchmarkState state, int size) {
        for (Integer value : state.valuesMap.get(size)) {
            state.newHashSet.add(value);
        }
        bl.consume(state.newHashSet);
    }

}
