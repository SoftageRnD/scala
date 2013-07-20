import com.google.caliper.Benchmark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 6/22/13
 * Time: 6:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashSetBenchmark extends Benchmark {
    private static final Logger log = LoggerFactory.getLogger(HashSetBenchmark.class);

    /**
     * the set under test
     */
    public Set<Object> javaSet;// = new HashSet<Object>();

    public scala.collection.mutable.Set scalaSet;

    public scala.collection.mutable.experimental.HashSet newHashSet;

    public final List<Object> queries = new ArrayList<Object>();

    public void setUp(int containsPerRep, int collisionPercents, int deep) {
        if (collisionPercents > 100 || collisionPercents < 0) {
            log.error("Collision must be between 0 and 100");
            throw new RuntimeException("Collision must be between 0 and 100");
        }

        log.debug("setUp: " + containsPerRep);


        setUpScala3(containsPerRep, collisionPercents, deep);
    }


    public void setUpScala3(int containsPerRep, int collisionPercents, int deep) {
        if (collisionPercents == 0 || deep == 0) {
            if (collisionPercents == 0 && deep != 0) {
                log.warn("Collision percents == 0, but deep!=0. set deep = 0 automatically.");
            }
            if (collisionPercents != 0 && deep == 0) {
                log.warn("Collision deep == 0, but collisions!=0. set collisions = 0 automatically.");
            }
            collisionPercents = 0;
            deep = 0;
        }
        scalaSet = new scala.collection.mutable.HashSet();
        newHashSet = new scala.collection.mutable.experimental.HashSet();
        javaSet = new LinkedHashSet<Object>();//containsPerRep

        float unique = 100.0f - collisionPercents;
        float unUnique = collisionPercents + collisionPercents * deep;


        float uniquePath = unique / (unique + unUnique);
        float unUniquePath = unUnique / (unique + unUnique);

        int uniqueCount = Math.round(uniquePath * containsPerRep);
        int unUniqueCount = Math.round(unUniquePath * containsPerRep);
        int repeatCount = Math.round((100 / (unique + unUnique)) * containsPerRep);


        //заполняем одинаковыми уникальными объектами
        for (Integer i = 0; i < uniqueCount; i++) {
            Object obj = new HashObject(i);
            javaSet.add(obj);
            scalaSet.add(obj);
            newHashSet.add(obj);

            queries.add(obj);
        }

        //дозаполняем объектами с  повторяющимися хэшкодами
        for (int times = 0; times < unUniqueCount; times++) {
            Object obj = new HashObject(times % (unUniqueCount / (deep + 1)) + uniqueCount);
            javaSet.add(obj);
            scalaSet.add(obj);
            newHashSet.add(obj);

            if (times < unUniqueCount / (deep + 1)) {
                queries.add(obj);
            }
        }

        Collections.shuffle(queries, new Random());

    }
}
