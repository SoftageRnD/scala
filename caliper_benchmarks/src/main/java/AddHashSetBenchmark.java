import com.google.caliper.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 6/22/13
 * Time: 6:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddHashSetBenchmark extends HashSetBenchmark {
    private static final Logger log = LoggerFactory.getLogger(AddHashSetBenchmark.class);
    @Param({ "10", "100", "500", "1000", "5000", "10000"})//,"50000", "100000" , "500000" , "1000000" })//
    public int containsPerRep;

    @Param({ "10", "10", "10", "10", "10", "10"})
    public int collisionPercents;

    @Param({"1"})
    public int deep;

    public void setUp() {
        super.setUp(containsPerRep,collisionPercents,deep);
    }

    //ДОБАВЛЕНИЕ

    /**
     * без коллизий
     */
    public void timeAdd(int reps) {
        for (int i = 0; i < reps; i++) {
            Float I = new Float(i * 1.43);
            String obj = I.toString();
            javaSet.add(obj);
        }
    }

    /**
     * без коллизий
     */
    public void timeAddScala(int reps) {
        for (int i = 0; i < reps; i++) {
            Float I = new Float(i * 1.43);
            String obj = I.toString();
            scalaSet.add(obj);
        }
    }

    public void timeAddNewHashSetScala(int reps) {
        for (int i = 0; i < reps; i++) {
            Float I = new Float(i * 1.43);
            String obj = I.toString();
            newHashSet.add(obj);
        }
    }
}
