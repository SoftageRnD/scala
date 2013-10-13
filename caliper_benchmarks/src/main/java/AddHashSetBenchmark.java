import com.google.caliper.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 6/22/13
 * Time: 6:59 PM
 * To change this template use File | Settings | File Templates.
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

    public void addJava(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < controlList.size(); j++) {
                javaSet.add(controlList.get(j));
            }
        }
    }

    public void addScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < controlList.size(); j++) {
                scalaSet.add(controlList.get(j));
            }
        }
    }

    public void addNewScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < controlList.size(); j++) {
                newHashSet.add(controlList.get(j));
            }
        }
    }
}
