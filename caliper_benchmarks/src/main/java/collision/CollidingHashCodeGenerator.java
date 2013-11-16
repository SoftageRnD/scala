package collision;

public interface CollidingHashCodeGenerator {
    void init(int initialHashCode, int size);

    int nextHashCode();
}
