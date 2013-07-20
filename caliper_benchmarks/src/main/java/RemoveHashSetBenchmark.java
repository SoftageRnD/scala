import com.google.caliper.Param;

/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 6/22/13
 * Time: 7:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveHashSetBenchmark extends HashSetBenchmark {
    @Param({"10", "100", "500", "1000", "5000", "10000"})// ,"50000", "100000" , "500000" , "1000000"})//
    public int containsPerRep;

    @Param({"10", "10", "10", "10", "10", "10"})
    public int collisionPercents;

    @Param({"1"})
    public int deep;

    public void setUp() {
        super.setUp(containsPerRep, collisionPercents, deep);
    }


    //УДАЛЕНИЕ
    public void timeRemove(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                javaSet.remove(queries.get(j));
            }
        }
    }

    public void timeRemoveScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                scalaSet.remove(queries.get(j));
            }
        }
    }

    public void timeRemoveNewHashSetScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                newHashSet.remove(queries.get(j));
            }
        }
    }
}
