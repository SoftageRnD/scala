import com.google.caliper.Benchmark;
import com.google.caliper.Param;
import com.google.monitoring.runtime.instrumentation.AllocationRecorder;

import java.util.*;

import static scala.collection.JavaConversions.*;


public class ContainsHashSetBenchmark extends HashSetBenchmark {
    @Param({"100000"})//, "100", "500", "1000", "5000", "10000","50000", "100000" , "500000" , "1000000" })//
    public int containsPerRep;

    @Param({"20"})
    public int collisionPercents;

    @Param({"0", "2", "16"})
    public int deep;

    public void setUp() {
        super.setUp(containsPerRep, collisionPercents, deep);
    }

    //НАЛИЧИЕ
    public void timeContains(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                javaSet.contains(queries.get(j));
            }
        }
    }

    public void timeContainsScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                scalaSet.contains(queries.get(j));
            }
        }
    }

    public void timeContainsNewHashSetScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                newHashSet.contains(queries.get(j));
            }
        }
    }


}