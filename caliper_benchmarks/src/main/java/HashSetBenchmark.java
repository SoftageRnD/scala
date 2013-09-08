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
    public Set<Object> javaSet;

    public scala.collection.mutable.Set scalaSet;

    public scala.collection.mutable.experimental.HashSet newHashSet;

    public final List<HashObject> control = new ArrayList<HashObject>();

    public void setUp(int containsPerRep, int collisionPercents, int deep) {
        if (collisionPercents > 100 || collisionPercents < 0) {
            log.error("Collision must be between 0 and 100");
            throw new RuntimeException("Collision must be between 0 and 100");
        }

        log.debug("setUp: " + containsPerRep);


        setUpSets(containsPerRep, collisionPercents, deep);

        for (HashObject obj : control) {
            if (!javaSet.contains(obj)) {
                log.error("Java set can't find object.");
                throw new RuntimeException("Java set can't find object");
            }
            if (!scalaSet.contains(obj)) {
                log.error("ScalaSet can't find object.");
                throw new RuntimeException("ScalaSet can't find object.");
            }
            if (!newHashSet.contains(obj)) {
                log.error("NewHashSet can't find object.");
                throw new RuntimeException("NewHashSet can't find object.");
            }
        }
    }


    public void setUpSets(int containsPerRep, int collisionPercents, int deep) {
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
        javaSet = new HashSet<Object>();

        float unique = 100.0f - collisionPercents;
        float unUnique = collisionPercents + collisionPercents * deep;


        float uniquePath = unique / (unique + unUnique);
        float unUniquePath = unUnique / (unique + unUnique);

        int uniqueCount = Math.round(uniquePath * containsPerRep);
        int unUniqueCount = Math.round(unUniquePath * containsPerRep);

        List<HashObject> tempList = new ArrayList<HashObject>();
        //заполняем одинаковыми уникальными объектами
        for (Integer i = 0; i < uniqueCount; i++) {
            HashObject obj = new HashObject(i);
            tempList.add(obj);

            control.add(obj);
        }

        //дозаполняем объектами с  повторяющимися хэшкодами
        for (int times = 0; times < unUniqueCount; times++) {
            HashObject obj = new HashObject(times % (unUniqueCount / (deep + 1)) + uniqueCount);
            tempList.add(obj);

            if (times < unUniqueCount / (deep + 1)) {
                control.add(obj);
            }
        }
        
        Collections.shuffle(tempList, new Random(containsPerRep));
        
        for (HashObject obj : tempList){
            javaSet.add(obj);
            scalaSet.add(obj);
            newHashSet.add(obj);    
        }

        Collections.shuffle(control, new Random(containsPerRep));

    }
}
