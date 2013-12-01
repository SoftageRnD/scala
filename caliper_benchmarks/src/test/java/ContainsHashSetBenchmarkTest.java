import collision.CollisionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ContainsHashSetBenchmarkTest {

    private static final int setSize = 1000;
    private static final List<Integer> collisionPercentsValues = Arrays.asList(0, 20, 40, 60, 80, 100);
    private static final List<Integer> deepValues = Arrays.asList(0, 2, 16);
    private static final List<CollisionType> collisionTypeValues = Arrays.asList(CollisionType.values());
    private int collisionPercents;
    private int deep;
    private CollisionType collisionType;

    public ContainsHashSetBenchmarkTest(int collisionPercents, int deep, CollisionType collisionType) {
        this.collisionPercents = collisionPercents;
        this.deep = deep;
        this.collisionType = collisionType;
    }

    @Parameterized.Parameters(name = "{0}%, {1} deep, {2}")
    public static List<Object[]> getTests() {
        List<Object[]> tests = new ArrayList<Object[]>();
        for (int collisionPercents : collisionPercentsValues) {
            for (int deep : deepValues) {
                for (CollisionType collisionType : collisionTypeValues) {
                    tests.add(new Object[]{collisionPercents, deep, collisionType});
                }
            }
        }
        return tests;
    }

    @Test
    public void setUp() {
        ContainsHashSetBenchmark benchmark = new ContainsHashSetBenchmark();
        benchmark.setSize = setSize;
        benchmark.collisionPercents = collisionPercents;
        benchmark.deep = deep;
        benchmark.collisionType = collisionType;
        benchmark.setUp();

        assertThat(benchmark.javaSet, hasSize(setSize));
        assertThat(benchmark.scalaSet.size(), is(setSize));
        assertThat(benchmark.newHashSet.size(), is(setSize));

        double actualControlToSetSizeRatio = (0d + benchmark.control.size()) / setSize;
        double expectedControlToSetSizeRatio = 1d / (1d + (0d + collisionPercents) / 100 * deep);
        assertThat(actualControlToSetSizeRatio, closeTo(expectedControlToSetSizeRatio, 0.01d));
    }
}
