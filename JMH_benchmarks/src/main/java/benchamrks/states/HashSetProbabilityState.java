package benchamrks.states;

import benchamrks.HashObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 12/1/13
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashSetProbabilityState {
    private static final Logger log = LoggerFactory.getLogger(HashSetProbabilityState.class);

    /**
     * the set under test
     */
    public Set<Object> javaHashSet;

    public scala.collection.mutable.Set scalaHashSet;

    public scala.collection.mutable.experimental.HashSet newHashSet;

    public final List<HashObject> control = new ArrayList<HashObject>();

    public final List<Object> controlList = new ArrayList();


    public void setUp(int containsPerRep, int collisionPercents, int deep) {
        //TODO Validate params

        scalaHashSet = new scala.collection.mutable.HashSet();
        newHashSet = new scala.collection.mutable.experimental.HashSet();
        javaHashSet = new HashSet<Object>();

        List<HashObject> tempList = new ArrayList<HashObject>();


        Random random = new Random();

        for (int num = 0; num < containsPerRep / (deep + 1); num++) {
            int randInt = random.nextInt(100);
            if (randInt > collisionPercents) {
                //Unique hash code
                HashObject hashObject = new HashObject(num);
                control.add(hashObject);

                tempList.add(hashObject);
            } else {
                //Collision hash code
                HashObject hashObject = new HashObject(num);
                control.add(hashObject);

                tempList.add(hashObject);

                //deep times add collisionObjects
                for (int n = 1; n < deep; n++) {
                    hashObject = new HashObject(num);

                    tempList.add(hashObject);
                }

            }

        }


        Collections.shuffle(tempList, new Random());//containsPerRep
        Collections.shuffle(control, new Random());//containsPerRep

        for (HashObject obj : tempList) {
            javaHashSet.add(obj);
            scalaHashSet.add(obj);
            newHashSet.add(obj);
        }

        log.debug(String.format("Control set size %d", control.size()));
        log.debug(String.format("Test set size %d", javaHashSet.size()));


    }
}
