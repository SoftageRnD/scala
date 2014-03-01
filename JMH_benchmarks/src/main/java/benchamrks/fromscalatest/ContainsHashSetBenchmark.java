package benchamrks.fromscalatest;

import benchamrks.fromscalatest.states.ContainsHashSetBenchmarkState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;
import scala.collection.mutable.HashSet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ContainsHashSetBenchmark {

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsScala1H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsScala(bl, state, 100000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsScala2H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsScala(bl, state, 200000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsScala3H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsScala(bl, state, 300000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsScala4H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsScala(bl, state, 400000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsScala5H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsScala(bl, state, 500000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsScala6H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsScala(bl, state, 600000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsScala7H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsScala(bl, state, 700000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsScala8H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsScala(bl, state, 800000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsScala9H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsScala(bl, state, 900000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsScala10H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsScala(bl, state, 1000000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsNewScala1H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsNewScala(bl, state, 100000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsNewScala2H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsNewScala(bl, state, 200000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsNewScala3H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsNewScala(bl, state, 300000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsNewScala4H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsNewScala(bl, state, 400000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsNewScala5H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsNewScala(bl, state, 500000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsNewScala6H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsNewScala(bl, state, 600000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsNewScala7H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsNewScala(bl, state, 700000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsNewScala8H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsNewScala(bl, state, 800000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsNewScala9H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsNewScala(bl, state, 900000);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(10)
    public void containsNewScala10H(BlackHole bl, ContainsHashSetBenchmarkState state) {
        containsNewScala(bl, state, 1000000);
    }

    private void containsScala(BlackHole bl, ContainsHashSetBenchmarkState state, int size) {
        List<Integer> values = state.valuesMap.get(size);
        HashSet<Integer> scalaHashSet = state.scalaHashSetMap.get(size);
        List<Boolean> results = new ArrayList<Boolean>(values.size());
        for (Integer value : values) {
            results.add(scalaHashSet.contains(value));
        }
        bl.consume(results);
    }

    private void containsNewScala(BlackHole bl, ContainsHashSetBenchmarkState state, int size) {
        List<Integer> values = state.valuesMap.get(size);
        scala.collection.mutable.experimental.HashSet<Integer> newHashSet = state.newHashSetMap.get(size);
        List<Boolean> results = new ArrayList<Boolean>(values.size());
        for (Integer value : values) {
            results.add(newHashSet.contains(value));
        }
        bl.consume(results);
    }

}
