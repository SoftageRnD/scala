package benchamrks.states;

import benchamrks.HashObject;
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
public class HashSetBenchmark {
    private static final Logger log = LoggerFactory.getLogger(HashSetBenchmark.class);

    /**
     * the set under test
     */
    public Set<Object> javaHashSet;

    public scala.collection.mutable.Set scalaHashSet;

    public scala.collection.mutable.experimental.HashSet newHashSet;

    public final List<HashObject> control = new ArrayList<HashObject>();

    public final List<Object> controlList = new ArrayList();

    public void setUp(int containsPerRep, int collisionPercents, int deep) {
        if (collisionPercents > 100 || collisionPercents < 0) {
            log.error("Collision must be between 0 and 100");
            throw new RuntimeException("Collision must be between 0 and 100");
        }

        setUpSets(containsPerRep, collisionPercents, deep);

        for (HashObject obj : control) {
            if (!javaHashSet.contains(obj)) {
                log.error("Java set can't find object.");
                throw new RuntimeException("Java set can't find object");
            }
            if (!scalaHashSet.contains(obj)) {
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
            collisionPercents = 0;
            deep = 0;
        }
        scalaHashSet = new scala.collection.mutable.HashSet();
        newHashSet = new scala.collection.mutable.experimental.HashSet();
        javaHashSet = new HashSet<Object>();

        float unique = 100.0f - collisionPercents;
        float unUnique = collisionPercents + collisionPercents * deep;


        float uniquePath = unique / (unique + unUnique);
        float unUniquePath = unUnique / (unique + unUnique);

        int uniqueCount = Math.round(uniquePath * containsPerRep);
        int unUniqueCount = Math.round(unUniquePath * containsPerRep);

        List<HashObject> tempList = new ArrayList<HashObject>();
        //unique hashcode objects were added.
        for (Integer i = 0; i < uniqueCount; i++) {
            HashObject obj = new HashObject(i);
            tempList.add(obj);

            control.add(obj);
        }

        //Not unique hashcode objects were added.
        for (int times = 0; times < unUniqueCount; times++) {
            HashObject obj = new HashObject(times % (unUniqueCount / (deep + 1)) + uniqueCount);
            tempList.add(obj);

            if (times < unUniqueCount / (deep + 1)) {
                control.add(obj);
            }
        }

        Collections.shuffle(tempList, new Random(containsPerRep));

        for (HashObject obj : tempList) {
            javaHashSet.add(obj);
            scalaHashSet.add(obj);
            newHashSet.add(obj);
        }

        Collections.shuffle(control, new Random(containsPerRep));

        log.debug(String.format("Unique hashcode objects: %d\n Not unique hashcode objects: %d", uniqueCount, unUniqueCount));
        log.debug(String.format("Control set size %d", control.size()));
    }
}
