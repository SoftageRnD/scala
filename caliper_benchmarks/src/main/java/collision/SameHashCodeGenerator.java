package collision;

/* package */ class SameHashCodeGenerator implements CollidingHashCodeGenerator {
    private int hashCode;

    @Override
    public void init(int initialHashCode, int size) {
        hashCode = initialHashCode;
    }

    @Override
    public int nextHashCode() {
        return hashCode;
    }
}
