package benchamrks.fromscalatest.states;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import scala.collection.mutable.HashSet;

import java.util.*;

@State(Scope.Thread)
public class RemoveHashSetBenchmarkState extends HashSetBenchmarkState {
    public Map<Integer, HashSet<Integer>> scalaHashSetMap;

    public Map<Integer, scala.collection.mutable.experimental.HashSet<Integer>> newHashSetMap;

    @Setup(Level.Trial)
    public void setUp() {
        scalaHashSetMap = new HashMap<Integer, HashSet<Integer>>();
        newHashSetMap = new HashMap<Integer, scala.collection.mutable.experimental.HashSet<Integer>>();
        generateValues();
    }

    private void generateValues() {
        for (int size = START_SIZE; size <= END_SIZE; size += STEP) {
            List<Integer> values = new ArrayList<Integer>(size);
            scala.collection.mutable.HashSet<Integer> scalaHashSet = new scala.collection.mutable.HashSet<Integer>();
            scala.collection.mutable.experimental.HashSet<Integer> newHashSet =
                    new scala.collection.mutable.experimental.HashSet<Integer>();
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                int value = rand.nextInt();
                values.add(value);
                scalaHashSet.add(value);
                newHashSet.add(value);
            }
            scalaHashSetMap.put(size, scalaHashSet);
            newHashSetMap.put(size, newHashSet);
            valuesMap.put(size, values);
        }
    }
}
