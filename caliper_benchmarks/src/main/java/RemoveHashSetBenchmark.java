import com.google.caliper.Param;

/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 6/22/13
 * Time: 7:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveHashSetBenchmark extends HashSetBenchmark {
    @Param({ "100000"})// ,"50000", "100000" , "500000" , "1000000"})//
    public int containsPerRep;

    @Param({"20"})
    public int collisionPercents;

    @Param({"0","2","20"})
    public int deep;

    public void setUp() {
        super.setUp(containsPerRep, collisionPercents, deep);
    }


    //УДАЛЕНИЕ
    public void timeRemoveJava(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                javaSet.remove(control.get(j));
            }
        }
    }

    public void timeRemoveScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                scalaSet.remove(control.get(j));
            }
        }
    }

    public void timeRemoveNewHashSetScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < 100; j++) {
                newHashSet.remove(control.get(j));
            }
        }
    }
}
