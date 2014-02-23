package benchamrks.fromscalatest.states;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashSetBenchmarkState {
    protected static final int START_SIZE = 100000;
    protected static final int END_SIZE = 1000000;
    protected static final int STEP = 100000;

    public Map<Integer, List<Integer>> valuesMap =
            new HashMap<Integer, List<Integer>>((END_SIZE - START_SIZE) / STEP + 1);


}
