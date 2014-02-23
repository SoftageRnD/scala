package benchamrks.fromscalatest.states;


import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.*;

@State(Scope.Thread)
public class AddHashSetBenchmarkState extends HashSetBenchmarkState {

    public scala.collection.mutable.HashSet<Integer> scalaHashSet;

    public scala.collection.mutable.experimental.HashSet<Integer> newHashSet;

    @Setup(Level.Trial)
    public void setUp() {
        scalaHashSet = new scala.collection.mutable.HashSet<Integer>();
        newHashSet = new scala.collection.mutable.experimental.HashSet<Integer>();
        generateValues();
    }

    private void generateValues() {
        for (int size = START_SIZE; size <= END_SIZE; size += STEP) {
            List<Integer> values = new ArrayList<Integer>(size);
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                values.add(rand.nextInt());
            }
            valuesMap.put(size, values);
        }
    }

}
