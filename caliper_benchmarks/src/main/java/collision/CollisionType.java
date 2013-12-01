package collision;

public enum CollisionType {
    /**
     * Collision made by objects with exactly the same hash code
     */
    SAME_HASH_CODE,
    /**
     * Collision made by objects with different hash codes but corresponding hash table indexes are the same
     */
    DIFFERENT_HASH_CODE_SAME_HASH_TABLE_INDEX
}
