import com.google.caliper.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;


/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 6/22/13
 * Time: 6:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddHashSetBenchmark extends HashSetBenchmark {
    private static final Logger log = LoggerFactory.getLogger(AddHashSetBenchmark.class);
    @Param({"100000"})//,"50000", "100000" , "500000" , "1000000" })//
    public int containsPerRep;

    @Param({"20"})
    public int collisionPercents;

    @Param({"0","2","16"})
    public int deep;

    public void setUp() {
        super.setUp(containsPerRep,collisionPercents,deep);
        scalaSet = new scala.collection.mutable.HashSet();
        newHashSet = new scala.collection.mutable.experimental.HashSet();
        javaSet = new HashSet<Object>();
    }

    //ДОБАВЛЕНИЕ
    public void timeAddJava(int reps) {
        for (int i = 0; i < reps; i++) {
            for(Object obj : control){
                javaSet.add(obj);
            }
        }
    }

    public void timeAddScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for(Object obj : control){
                scalaSet.add(obj);
            }
        }
    }

    public void timeAddNewHashSetScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for(Object obj : control){
                newHashSet.add(obj);
            }
        }
    }
}
