import com.google.caliper.Benchmark;
import com.google.caliper.Param;
import com.google.monitoring.runtime.instrumentation.AllocationRecorder;

import java.util.*;

import static scala.collection.JavaConversions.*;



public class ContainsHashSetBenchmark extends HashSetBenchmark {
    @Param({ "10", "100", "500", "1000", "5000", "10000"})//,"50000", "100000" , "500000" , "1000000" })//
    public int containsPerRep;

    public void setUp() {
        super.setUp(containsPerRep);
    }

    //НАЛИЧИЕ
    public void timeContains(int reps) {
        for (int i = 0; i < reps; i++) {
            for (Object obj : queries) {
                javaSet.contains(obj);
            }
        }
    }

    public void timeContainsScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (Object obj : queries) {
                scalaSet.contains(obj);
            }
        }
    }
    public void timeContainsNewHashSetScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (Object obj : queries) {
                newHashSet.contains(obj);
            }
        }
    }





}