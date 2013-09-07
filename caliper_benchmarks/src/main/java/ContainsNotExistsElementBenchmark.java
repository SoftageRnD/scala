import com.google.caliper.Param;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 7/20/13
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContainsNotExistsElementBenchmark extends HashSetBenchmark {
    @Param({"100000"})//, "100", "500", "1000", "5000", "10000","50000", "100000" , "500000" , "1000000" })//
    public int containsPerRep;

    @Param({"20"})
    public int collisionPercents;

    @Param({"0", "2", "20"})
    public int deep;

    private java.util.List<HashObject> controlSet = new ArrayList<HashObject>();
    public void setUp() {
        super.setUp(containsPerRep, collisionPercents, deep);

        for(HashObject obj : control){
            controlSet.add(new HashObject(obj.getInteger()));
        }
    }

    //НАЛИЧИЕ
    public void timeContainsJava(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < controlSet.size(); j++) {
                javaSet.contains(controlSet.get(j));
            }
        }
    }

    public void timeContainsScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < controlSet.size(); j++) {
                scalaSet.contains(controlSet.get(j));
            }
        }
    }

    public void timeContainsNewHashSetScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < controlSet.size(); j++) {
                newHashSet.contains(controlSet.get(j));
            }
        }
    }
}
