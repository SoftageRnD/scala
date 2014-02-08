package benchamrks.fromscalatest.states;


import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.*;

@State(Scope.Thread)
public class HashSetBenchmarkState {
    private static final int START_SIZE = 3000000;
    private static final int END_SIZE = 15000000;
    private static final int STEP = 1000000;

    public Map<Integer, List<Integer>> valuesMap = new HashMap<>((START_SIZE - END_SIZE) / STEP + 1);

    public scala.collection.mutable.HashSet<Integer> scalaHashSet = new scala.collection.mutable.HashSet<>();

    public scala.collection.mutable.experimental.HashSet<Integer> newHashSet = new scala.collection.mutable.experimental.HashSet<>();

    @Setup(Level.Trial)
    public void setUp() {
        for (int i = START_SIZE; i <= END_SIZE; i += STEP) {
            valuesMap.put(i, generateValues(i));
        }
    }

    private List<Integer> generateValues(int size) {
        List<Integer> values = new ArrayList<>(size);
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            values.add(rand.nextInt());
        }
        return values;
    }

}
