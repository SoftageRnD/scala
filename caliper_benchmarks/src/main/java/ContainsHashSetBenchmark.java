import com.google.caliper.Param;


public class ContainsHashSetBenchmark extends HashSetBenchmark {
    @Param({"100000"})//, "100", "500", "1000", "5000", "10000","50000", "100000" , "500000" , "1000000" })//
    public int containsPerRep;

    @Param({"20"})
    public int collisionPercents;

    @Param({"0", "2", "20"})
    public int deep;

    public void setUp() {
        super.setUp(containsPerRep, collisionPercents, deep);
    }

    //НАЛИЧИЕ
    public void timeContainsJava(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                javaSet.contains(control.get(j));
            }
        }
    }

    public void timeContainsScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                scalaSet.contains(control.get(j));
            }
        }
    }

    public void timeContainsNewHashSetScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                newHashSet.contains(control.get(j));
            }
        }
    }


}
