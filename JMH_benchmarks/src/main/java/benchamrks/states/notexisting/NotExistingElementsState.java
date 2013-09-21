package benchamrks.states.notexisting;

import benchamrks.HashObject;
import benchamrks.states.HashSetBenchmark;

import java.util.ArrayList;
import java.util.List;

public class NotExistingElementsState extends HashSetBenchmark {

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
