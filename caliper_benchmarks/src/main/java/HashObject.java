import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 7/13/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashObject {
    private Integer integer;
    private String uuid = UUID.randomUUID().toString();

    public HashObject(Integer integer) {
        this.integer = integer;
    }

    @Override
    public int hashCode() {
        return integer.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashObject that = (HashObject) o;

        if (integer != null ? !integer.equals(that.integer) : that.integer != null) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;

        return true;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
