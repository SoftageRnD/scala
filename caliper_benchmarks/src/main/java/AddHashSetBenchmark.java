import collision.CollidingHashCodeGenerator;
import collision.CollisionType;
import com.google.caliper.Benchmark;
import com.google.caliper.Param;

import java.util.*;

import static collision.HashTableUtils.getHashCodeGenerator;

public class AddHashSetBenchmark extends Benchmark {
    @Param({"10000"})
    public int setSize;

    @Param({"20"})
    public int collisionPercents;

    @Param({"0", "2", "20"})
    public int deep;

    @Param({"SAME_HASH_CODE", "DIFFERENT_HASH_CODE_SAME_HASH_TABLE_INDEX"})
    public CollisionType collisionType;

    private List<HashObject> javaSetContent;
    private List<HashObject> scalaSetContent;
    private List<HashObject> newScalaSetContent;

    /**
     * Creates set content with these properties:
     * <ul>
     * <li>whole content size - (setSize)</li>
     * <li>all elements are mutually non-equal</li>
     * <li>for (100 - collisionPercents)% of elements
     * there is no other element which hash code collides with one's hash code</li>
     * <li>(collisionPercents)% of elements collide by hash codes with approx (deep) other elements</li>
     * </ul>
     */
    private List<HashObject> createSetContent(Class<?> setClass) {
        int currentHash = 0;
        List<HashObject> content = new ArrayList<HashObject>(setSize);

        // add elements with unique hash codes
        int uniqueHashElemsNum = setSize * (100 - collisionPercents) / 100;
        for (int i = 0; i < uniqueHashElemsNum; i++) {
            content.add(new HashObject(currentHash));
            currentHash++;
        }

        // add elements with colliding hash codes
        CollidingHashCodeGenerator hashCodeGenerator = getHashCodeGenerator(collisionType, setClass);
        while (content.size() < setSize) {
            hashCodeGenerator.init(currentHash, setSize);
            int elemsToAdd = setSize - content.size();
            for (int i = 0; i < Math.min(deep + 1, elemsToAdd); i++) {
                content.add(new HashObject(hashCodeGenerator.nextHashCode()));
            }
            currentHash++;
        }

        return content;
    }

    @Override
    public void setUp() {
        javaSetContent = createSetContent(HashSet.class);
        scalaSetContent = createSetContent(scala.collection.mutable.HashSet.class);
        newScalaSetContent = createSetContent(scala.collection.mutable.experimental.HashSet.class);

        Collections.shuffle(javaSetContent, new Random(setSize));
        Collections.shuffle(scalaSetContent, new Random(setSize));
        Collections.shuffle(newScalaSetContent, new Random(setSize));
    }

    public void timeAddJava(int reps) {
        for (int i = 0; i < reps; i++) {
            HashSet<HashObject> javaSet = new HashSet<HashObject>();
            for (HashObject obj : javaSetContent) {
                javaSet.add(obj);
            }
        }
    }

    public void timeAddScala(int reps) {
        for (int i = 0; i < reps; i++) {
            scala.collection.mutable.HashSet<HashObject> scalaSet = new scala.collection.mutable.HashSet<HashObject>();
            for (HashObject obj : scalaSetContent) {
                scalaSet.add(obj);
            }
        }
    }

    public void timeAddNewHashSetScala(int reps) {
        for (int i = 0; i < reps; i++) {
            scala.collection.mutable.experimental.HashSet<HashObject> newScalaSet =
                    new scala.collection.mutable.experimental.HashSet<HashObject>();
            for (HashObject obj : newScalaSetContent) {
                newScalaSet.add(obj);
            }
        }
    }
}
