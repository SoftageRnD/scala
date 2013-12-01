package collision;

public final class HashTableUtils {
    private HashTableUtils() {
        //not needed
    }

    public static CollidingHashCodeGenerator getHashCodeGenerator(CollisionType collisionType, Class<?> setClass) {
        switch (collisionType) {
            case SAME_HASH_CODE:
                return new SameHashCodeGenerator();
            case DIFFERENT_HASH_CODE_SAME_HASH_TABLE_INDEX:
                if (java.util.HashSet.class.equals(setClass)) {
                    return new BaseSameIndexGenerator() {
                        @Override
                        protected int getIndex(int hashCode, int size) {
                            return javaHashMapIndex(hashCode, size);
                        }
                    };
                } else if (scala.collection.mutable.HashSet.class.equals(setClass)) {
                    return new BaseSameIndexGenerator() {
                        @Override
                        protected int getIndex(int hashCode, int size) {
                            return flatHashTableIndex(hashCode, size);
                        }
                    };
                } else if (scala.collection.mutable.experimental.HashSet.class.equals(setClass)) {
                    return new BaseSameIndexGenerator() {
                        @Override
                        protected int getIndex(int hashCode, int size) {
                            return newHashSetIndex(hashCode, size);
                        }
                    };
                } else {
                    throw new IllegalArgumentException("unknown set class: " + setClass);
                }
            default:
                throw new IllegalArgumentException("unknown collision type: " + collisionType);
        }
    }

    /**
     * Computes a hash table index as the experimental Scala HashSet implementation does
     */
    public static int newHashSetIndex(int hashCode, int setSize) {
        int initialCapacity = 16;
        double loadFactor = 0.75d;
        int tableSize = closestGreaterOrEqualPow2((int) Math.floor(setSize / loadFactor));
        if (tableSize < initialCapacity) {
            tableSize = initialCapacity;
        }
        return hashCode & tableSize - 1;
    }

    /**
     * Computes a hash table index as the current Java HashMap implementation does
     * <p/>
     * Based on: java.util.HashMap
     */
    public static int javaHashMapIndex(int hashCode, int setSize) {
        int initialCapacity = 16;
        double loadFactor = 0.75d;
        int tableSize = closestGreaterOrEqualPow2((int) Math.floor(setSize / loadFactor));
        if (tableSize < initialCapacity) {
            tableSize = initialCapacity;
        }
        return hashCode & tableSize - 1;
    }

    /* package */static int closestGreaterOrEqualPow2(int num) {
        int pow2 = 1;
        while (pow2 < num) {
            pow2 <<= 1;
        }
        return pow2;
    }

    /**
     * Computes a hash table index as the current Scala HashSet implementation does
     * <p/>
     * Based on: scala.collection.mutable.FlatHashTable
     */
    public static int flatHashTableIndex(int hashCode, int setSize) {
        int defaultLoadFactor = 450;
        int loadFactorDenum = 1000;
        int tableSize = closestGreaterOrEqualPow2(Math.max(32, (setSize * loadFactorDenum / defaultLoadFactor)));
        int tableSizeSeed = Integer.bitCount(tableSize - 1);

        int improved = improve(hashCode, tableSizeSeed);
        int ones = tableSize - 1;
        return (improved >>> (32 - java.lang.Integer.bitCount(ones))) & ones;
    }

    private static int improve(int hashCode, int seed) {
        int improved = byteswap32(hashCode);
        int rotation = seed % 32;
        return (improved >>> rotation) | (improved << (32 - rotation));
    }

    private static int byteswap32(int v) {
        int hc = v * 0x9e3775cd;
        hc = java.lang.Integer.reverseBytes(hc);
        return hc * 0x9e3775cd;
    }
}
