package benchamrks.states.notexisting;

import benchamrks.HashObject;
import benchamrks.states.HashSetBenchmarkState;
import benchamrks.states.HashSetProbabilityState;

import java.util.ArrayList;
import java.util.List;

/**
 * Class relocate object in control set for not ==, but with equals hashCode.
 */
public class NotExistingElementsState extends HashSetProbabilityState {

    @Override
    public void setUp(int containsPerRep, int collisionPercents, int deep) {
        super.setUp(containsPerRep, collisionPercents, deep);

        List<HashObject> tempList = new ArrayList<HashObject>();
        for (HashObject obj : control) {
            tempList.add(new HashObject(obj.getInteger()));
        }
        control.clear();
        control.addAll(tempList);

    }
}
