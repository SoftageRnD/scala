public class HashObject {
    private final int hashCode;

    public HashObject(int hashCode) {
        this.hashCode = hashCode;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }
}
