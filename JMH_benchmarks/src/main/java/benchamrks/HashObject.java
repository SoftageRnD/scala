package benchamrks;

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

    public HashObject(Integer integer, String uuid) {
        this.integer = integer;
    }

    public HashObject(Integer integer) {
        this.integer = integer;
    }

    @Override
    public int hashCode() {
        return integer.hashCode();
    }


    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

}
