import collision.CollidingHashCodeGenerator;
import collision.CollisionType;
import com.google.caliper.Benchmark;
import com.google.caliper.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static collision.HashTableUtils.getHashCodeGenerator;


public class ContainsHashSetBenchmark extends Benchmark {
    private static final int CONTAINS_PER_REP = 1000;

    private final Logger logger = LoggerFactory.getLogger(ContainsHashSetBenchmark.class);

    @Param({"10000"})
    public int setSize;
    @Param({"20"})
    public int collisionPercents;
    @Param({"0", "2", "20"})
    public int deep;
    @Param({"SAME_HASH_CODE", "DIFFERENT_HASH_CODE_SAME_HASH_TABLE_INDEX"})
    public CollisionType collisionType;

    public List<HashObject> control;
    public HashSet<Object> javaSet;
    public scala.collection.mutable.HashSet<Object> scalaSet;
    public scala.collection.mutable.experimental.HashSet<Object> newHashSet;

    @Override
    @SuppressWarnings("unchecked")
    public void setUp() {
        if (collisionPercents == 0 || deep == 0) {
            if (collisionPercents == 0 && deep != 0) {
                logger.warn("Collision percents == 0, but deep!=0. set deep = 0 automatically.");
            }
            if (collisionPercents != 0) {
                logger.warn("Collision deep == 0, but collisions!=0. set collisions = 0 automatically.");
            }
            collisionPercents = 0;
            deep = 0;
        }
        scalaSet = new scala.collection.mutable.HashSet();
        newHashSet = new scala.collection.mutable.experimental.HashSet();
        javaSet = new HashSet<Object>();

        control = createControlList();

        List<HashObject> scalaSetContent = createSetContent(scalaSet.getClass());
        List<HashObject> newHashSetContent = createSetContent(newHashSet.getClass());
        List<HashObject> javaSetContent = createSetContent(javaSet.getClass());

        Collections.shuffle(scalaSetContent, new Random(setSize));
        Collections.shuffle(newHashSetContent, new Random(setSize));
        Collections.shuffle(javaSetContent, new Random(setSize));

        addAll(scalaSet, scalaSetContent);
        addAll(newHashSet, newHashSetContent);
        javaSet.addAll(javaSetContent);

        Collections.shuffle(control, new Random(setSize));
    }

    @SuppressWarnings("unchecked")
    private void addAll(scala.collection.mutable.Set scalaSet, List<HashObject> content) {
        for (HashObject element : content) {
            scalaSet.add(element);
        }
    }

    private List<HashObject> createControlList() {
        double expectedRatio = 1d / (1d + (0d + collisionPercents) / 100 * deep);
        int controlSize = (int) Math.round(expectedRatio * setSize);
        List<HashObject> controlList = new ArrayList<HashObject>(controlSize);
        for (int i = 0; i < controlSize; i++) {
            controlList.add(new HashObject(i));
        }
        return controlList;
    }

    private List<HashObject> createSetContent(Class<?> setClass) {
        int collidingHashCodesGroupsNum = control.size() * collisionPercents / 100;
        List<HashObject> elements = new ArrayList<HashObject>(setSize);
        elements.addAll(control);
        CollidingHashCodeGenerator hashCodeGenerator = getHashCodeGenerator(collisionType, setClass);
        for (int i = 0; i < collidingHashCodesGroupsNum; i++) {
            int elementsToAdd = setSize - elements.size();
            int remainingGroupsNum = collidingHashCodesGroupsNum - i;
            int groupSize = (int) Math.round((0. + elementsToAdd) / remainingGroupsNum);
            HashObject controlElement = control.get(i);
            hashCodeGenerator.init(controlElement.hashCode(), setSize);
            for (int j = 0; j < groupSize; j++) {
                elements.add(new HashObject(hashCodeGenerator.nextHashCode()));
            }
        }
        return elements;
    }

    public void timeContainsJava(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < CONTAINS_PER_REP; j++) {
                javaSet.contains(control.get(j));
            }
        }
    }

    public void timeContainsScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < CONTAINS_PER_REP; j++) {
                scalaSet.contains(control.get(j));
            }
        }
    }

    public void timeContainsNewHashSetScala(int reps) {
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < CONTAINS_PER_REP; j++) {
                newHashSet.contains(control.get(j));
            }
        }
    }
}
