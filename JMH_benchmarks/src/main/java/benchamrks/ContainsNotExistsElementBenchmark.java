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
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ContainsNotExistsElementBenchmark {
    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void containsJava0_0(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample1.control) {
            bl.consume(hashSetBenchmark.sample1.javaHashSet.contains(hashObject));
        }

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void containsScala0_0(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample1.control) {
            bl.consume(hashSetBenchmark.sample1.scalaHashSet.contains(hashObject));
        }

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsNewScala0_0(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample1.control) {
            bl.consume(hashSetBenchmark.sample1.newHashSet.contains(hashObject));
        }

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    public void containsJava20_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample2.control) {
            bl.consume(hashSetBenchmark.sample2.javaHashSet.contains(hashObject));
        }

    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsScala20_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample2.control) {
            bl.consume(hashSetBenchmark.sample2.scalaHashSet.contains(hashObject));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsNewScala20_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample2.control) {
            bl.consume(hashSetBenchmark.sample2.newHashSet.contains(hashObject));
        }
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsJava20_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample3.control) {
            bl.consume(hashSetBenchmark.sample3.javaHashSet.contains(hashObject));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsScala20_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample3.control) {
            bl.consume(hashSetBenchmark.sample3.scalaHashSet.contains(hashObject));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsNewScala20_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample3.control) {
            bl.consume(hashSetBenchmark.sample3.newHashSet.contains(hashObject));
        }
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsNewScala100_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample4.control) {
            bl.consume(hashSetBenchmark.sample4.newHashSet.contains(hashObject));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsScala100_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample4.control) {
            bl.consume(hashSetBenchmark.sample4.scalaHashSet.contains(hashObject));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsJava100_16(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample4.control) {
            bl.consume(hashSetBenchmark.sample4.javaHashSet.contains(hashObject));
        }
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsNewScala100_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample5.control) {
            bl.consume(hashSetBenchmark.sample5.newHashSet.contains(hashObject));
        }
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsScala100_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample5.control) {
            bl.consume(hashSetBenchmark.sample5.scalaHashSet.contains(hashObject));
        }
    }


    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)

    public void containsJava100_2(BlackHole bl, ContainsNotExistsElementBenchmarkState hashSetBenchmark) {
        for (HashObject hashObject : hashSetBenchmark.sample5.control) {
            bl.consume(hashSetBenchmark.sample5.javaHashSet.contains(hashObject));
        }
    }

}
