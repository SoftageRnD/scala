package collision;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HashTableUtilsTest {
    @Test
    public void closestGreaterOrEqualPow2() {
        assertThat(HashTableUtils.closestGreaterOrEqualPow2(3), is(4));
        assertThat(HashTableUtils.closestGreaterOrEqualPow2(16), is(16));
        assertThat(HashTableUtils.closestGreaterOrEqualPow2(1000), is(1024));
    }
}
