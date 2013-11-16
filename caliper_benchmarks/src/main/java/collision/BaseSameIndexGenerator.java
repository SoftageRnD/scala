package collision;

/* package */abstract class BaseSameIndexGenerator implements CollidingHashCodeGenerator {
    private int index;
    private int currentHashCode;
    private int size;

    protected abstract int getIndex(int hashCode, int size);

    @Override
    public int nextHashCode() {
        int result = currentHashCode;
        int currentIndex;
        do {
            currentHashCode++;
            currentIndex = getIndex(currentHashCode, size);
        } while (currentIndex != index);
        return result;
    }

    @Override
    public void init(int initialHashCode, int size) {
        currentHashCode = initialHashCode;
        index = getIndex(initialHashCode, size);
        this.size = size;
    }
}
