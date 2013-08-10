import scala.collection.mutable.Set;

import java.util.Random;

public final class SetHelper {
    private static final int BIG_SET_SIZE = 10000000;
    private static final int MANY_SETS_NUM = 10000000;

    private SetHelper() {
        // not needed
    }

    public static void populateBigMutableSet(Set<Integer> set) {
        Random random = new Random();
        for (int i = 0; i < BIG_SET_SIZE; i++) {
            set.add(random.nextInt());
        }
    }

    @SuppressWarnings("unchecked")
    public static Set<Integer>[] createManyNewMutableSets() {
        Set<Integer>[] sets = new Set[MANY_SETS_NUM];
        for (int i = 0; i < MANY_SETS_NUM; i++) {
            scala.collection.mutable.experimental.HashSet<Integer> set
                    = new scala.collection.mutable.experimental.HashSet<Integer>();
            set.add(i);
            sets[i] = set;
        }
        return sets;
    }

    @SuppressWarnings("unchecked")
    public static Set<Integer>[] createManyOldMutableSets() {
        Set<Integer>[] sets = new Set[MANY_SETS_NUM];
        for (int i = 0; i < MANY_SETS_NUM; i++) {
            scala.collection.mutable.HashSet<Integer> set = new scala.collection.mutable.HashSet<Integer>();
            set.add(i);
            sets[i] = set;
        }
        return sets;
    }
}
