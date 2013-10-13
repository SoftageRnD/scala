import com.google.caliper.Param;

/**
 * User: alex42rus
 * Date: 6/22/13
 */
public class RemoveHashSetBenchmark extends HashSetBenchmark {
    @Param({"1000000"})// ,"50000", "100000" , "500000" , "1000000"})//
    public int containsPerRep;

    @Param({"20"})
    public int collisionPercents;

    @Param({"0", "2", "20"})
    public int deep;

    public void setUp() {
        super.setUp(containsPerRep, collisionPercents, deep);
    }


    public void timeRemoveJava(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 10000; j++) {
                javaSet.remove(control.get(j));
            }
        }
    }

    public void timeRemoveScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 10000; j++) {
                scalaSet.remove(control.get(j));
            }
        }
    }

    public void timeRemoveNewHashSetScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 10000; j++) {
                newHashSet.remove(control.get(j));
            }
        }
    }
}
