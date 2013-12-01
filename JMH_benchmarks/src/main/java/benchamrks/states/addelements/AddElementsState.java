package benchamrks.states.addelements;

import benchamrks.states.HashSetBenchmarkState;
import benchamrks.states.HashSetProbabilityState;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class AddElementsState extends HashSetProbabilityState {

    @Override
    public void setUp(int containsPerRep, int collisionPercents, int deep) {
        super.setUp(containsPerRep, collisionPercents, deep);

        controlList.addAll(Arrays.asList(javaHashSet.toArray()));
        Collections.shuffle(controlList, new Random());//new Long(containsPerRep)


        scalaHashSet = new scala.collection.mutable.HashSet();
        newHashSet = new scala.collection.mutable.experimental.HashSet();
        javaHashSet = new HashSet<Object>();

    }
}
