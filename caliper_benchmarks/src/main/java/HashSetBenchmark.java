import com.google.caliper.Benchmark;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 6/22/13
 * Time: 6:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashSetBenchmark extends Benchmark {

    /**
     * the set under test
     */
    public Set<Object> javaSet;// = new HashSet<Object>();

    public scala.collection.mutable.Set scalaSet;

    public scala.collection.mutable.experimental.HashSet newHashSet;

    public final List<Object> queries = new ArrayList<Object>();

    public void setUp(int containsPerRep) {
        javaSet = new LinkedHashSet<Object>();//containsPerRep
        for (Integer i = 0; i < containsPerRep; i++) {
            queries.add(i);
            javaSet.add(i);
        }

        Collections.shuffle(queries, new Random(0));

        setUpScala(containsPerRep);
    }

    public void setUpScala(int containsPerRep) {
        scalaSet = new scala.collection.mutable.HashSet();
        newHashSet = new scala.collection.mutable.experimental.HashSet();

        for (int i = 0; i < containsPerRep; i++) {
            Integer I = new Integer(i);
            String obj = I.toString();

            scalaSet.add(obj);
            newHashSet.add(obj);
        }

    }
}
