package benchamrks;

import benchamrks.states.AddHashSetBenchmarkState;
import benchamrks.states.ContainsHashSetBenchmarkState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

/**
 * User: alex42rus
 * mvn clean install
 * java -jar target/microbenchmarks.jar ".*AddHashSetBenchmark.*"
 */
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class AddHashSetBenchmark {

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddJava0_0(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample1.controlList.size(); j++) {
            addHashSetBenchmarkState.sample1.javaHashSet.add(addHashSetBenchmarkState.sample1.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample1.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddScala0_0(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample1.controlList.size(); j++) {
            addHashSetBenchmarkState.sample1.scalaHashSet.add(addHashSetBenchmarkState.sample1.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample1.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddNewHashSetScala0_0(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample1.controlList.size(); j++) {
            addHashSetBenchmarkState.sample1.newHashSet.add(addHashSetBenchmarkState.sample1.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample1.newHashSet);
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddJava20_2(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample2.controlList.size(); j++) {
            addHashSetBenchmarkState.sample2.javaHashSet.add(addHashSetBenchmarkState.sample2.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample2.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddScala20_2(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample2.controlList.size(); j++) {
            addHashSetBenchmarkState.sample2.scalaHashSet.add(addHashSetBenchmarkState.sample2.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample2.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddNewHashSetScala20_2(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample2.controlList.size(); j++) {
            addHashSetBenchmarkState.sample2.newHashSet.add(addHashSetBenchmarkState.sample2.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample2.newHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddJava20_16(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample3.controlList.size(); j++) {
            addHashSetBenchmarkState.sample3.javaHashSet.add(addHashSetBenchmarkState.sample3.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample3.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddScala20_16(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample3.controlList.size(); j++) {
            addHashSetBenchmarkState.sample3.scalaHashSet.add(addHashSetBenchmarkState.sample3.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample3.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddNewHashSetScala20_16(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample3.controlList.size(); j++) {
            addHashSetBenchmarkState.sample3.newHashSet.add(addHashSetBenchmarkState.sample3.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample3.newHashSet);
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddJava100_16(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample4.controlList.size(); j++) {
            addHashSetBenchmarkState.sample4.javaHashSet.add(addHashSetBenchmarkState.sample4.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample4.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddScala100_16(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample4.controlList.size(); j++) {
            addHashSetBenchmarkState.sample4.scalaHashSet.add(addHashSetBenchmarkState.sample4.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample4.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddNewHashSetScala100_16(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample4.controlList.size(); j++) {
            addHashSetBenchmarkState.sample4.newHashSet.add(addHashSetBenchmarkState.sample4.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample4.newHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddJava100_2(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample5.controlList.size(); j++) {
            addHashSetBenchmarkState.sample5.javaHashSet.add(addHashSetBenchmarkState.sample5.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample5.javaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddScala100_2(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample5.controlList.size(); j++) {
            addHashSetBenchmarkState.sample5.scalaHashSet.add(addHashSetBenchmarkState.sample5.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample5.scalaHashSet);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void timeAddNewHashSetScala100_2(BlackHole bl, AddHashSetBenchmarkState addHashSetBenchmarkState) {
        for (int j = 0; j < addHashSetBenchmarkState.sample5.controlList.size(); j++) {
            addHashSetBenchmarkState.sample5.newHashSet.add(addHashSetBenchmarkState.sample5.controlList.get(j));
        }
        bl.consume(addHashSetBenchmarkState.sample5.newHashSet);
    }
}
