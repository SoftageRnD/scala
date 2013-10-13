import com.google.caliper.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


/**
 * User: alex42rus
 * Date: 6/22/13
 */
public class AddHashSetBenchmark extends HashSetBenchmark {
    private static final Logger log = LoggerFactory.getLogger(AddHashSetBenchmark.class);
    @Param({"1000000"})//,"50000", "100000" , "500000" , "1000000" })//
    public int containsPerRep;

    @Param({"20"})
    public int collisionPercents;

    @Param({"0", "2", "20"})
    public int deep;

    private List<Object> controlList = new ArrayList();

    public void setUp() {
        super.setUp(containsPerRep, collisionPercents, deep);

        controlList.clear();
        controlList.addAll(Arrays.asList(javaSet.toArray()));
        Collections.shuffle(controlList, new Random(containsPerRep));

        scalaSet = new scala.collection.mutable.HashSet();
        newHashSet = new scala.collection.mutable.experimental.HashSet();
        javaSet = new HashSet<Object>();
    }

    public void timeAddJava(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < controlList.size(); j++) {
                javaSet.add(controlList.get(j));
            }
        }
    }

    public void timeAddScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < controlList.size(); j++) {
                scalaSet.add(controlList.get(j));
            }
        }
    }

    public void timeAddNewScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < controlList.size(); j++) {
                newHashSet.add(controlList.get(j));
            }
        }
    }
}
