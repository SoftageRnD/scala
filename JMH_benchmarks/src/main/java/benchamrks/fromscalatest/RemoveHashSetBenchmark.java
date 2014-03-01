package benchamrks.fromscalatest;

import benchamrks.fromscalatest.states.RemoveHashSetBenchmarkState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;
import scala.collection.mutable.HashSet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class RemoveHashSetBenchmark {

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeScala1H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeScala(bl, state, 100000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeScala2H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeScala(bl, state, 200000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeScala3H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeScala(bl, state, 300000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeScala4H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeScala(bl, state, 400000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeScala5H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeScala(bl, state, 500000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeScala6H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeScala(bl, state, 600000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeScala7H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeScala(bl, state, 700000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeScala8H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeScala(bl, state, 800000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeScala9H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeScala(bl, state, 900000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeScala10H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeScala(bl, state, 1000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeNewScala1H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeNewScala(bl, state, 100000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeNewScala2H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeNewScala(bl, state, 200000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeNewScala3H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeNewScala(bl, state, 300000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeNewScala4H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeNewScala(bl, state, 400000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeNewScala5H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeNewScala(bl, state, 500000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeNewScala6H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeNewScala(bl, state, 600000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeNewScala7H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeNewScala(bl, state, 700000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeNewScala8H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeNewScala(bl, state, 800000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeNewScala9H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeNewScala(bl, state, 900000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void removeNewScala10H(BlackHole bl, RemoveHashSetBenchmarkState state) {
        removeNewScala(bl, state, 1000000);
    }

    private void removeScala(BlackHole bl, RemoveHashSetBenchmarkState state, int size) {
        List<Integer> values = state.valuesMap.get(size);
        HashSet<Integer> scalaHashSet = state.scalaHashSetMap.get(size);
        List<Boolean> results = new ArrayList<Boolean>(values.size());
        for (Integer value : values) {
            results.add(scalaHashSet.remove(value));
        }
        bl.consume(results);
    }

    private void removeNewScala(BlackHole bl, RemoveHashSetBenchmarkState state, int size) {
        List<Integer> values = state.valuesMap.get(size);
        scala.collection.mutable.experimental.HashSet<Integer> newHashSet = state.newHashSetMap.get(size);
        List<Boolean> results = new ArrayList<Boolean>(values.size());
        for (Integer value : values) {
            results.add(newHashSet.remove(value));
        }
        bl.consume(results);
    }
}
