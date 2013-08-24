package benchamrks.states;

import benchamrks.HashObject;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;

/**
 * User: alex42rus
 */
@State
public class ContainsNotExistsElementBenchmarkState {
    /**
     * 100000, 0, 0
     */
    public HashSetBenchmark sample1;

    /**
     * 100000, 20, 2
     */
    public HashSetBenchmark sample2;

    /**
     * 100000, 20, 16
     */
    public HashSetBenchmark sample3;

    /**
     * 100000, 100, 16
     */
    public HashSetBenchmark sample4;

    /**
     * 100000, 100, 2
     */
    public HashSetBenchmark sample5;

    @Setup(Level.Trial)
    public void setUp() {
        sample1 = new HashSetBenchmark();
        sample1.setUp(100000, 0, 0);
        List<HashObject> tempList = new ArrayList<HashObject>();
        for (HashObject obj : sample1.control) {
            tempList.add(new HashObject(obj.getInteger()));
        }
        sample1.control.clear();
        sample1.control.addAll(tempList);

        sample2 = new HashSetBenchmark();
        sample2.setUp(100000, 20, 2);
        tempList = new ArrayList<HashObject>();
        for (HashObject obj : sample2.control) {
            tempList.add(new HashObject(obj.getInteger()));
        }
        sample2.control.clear();
        sample2.control.addAll(tempList);

        sample3 = new HashSetBenchmark();
        sample3.setUp(100000, 20, 16);
        tempList = new ArrayList<HashObject>();
        for (HashObject obj : sample3.control) {
            tempList.add(new HashObject(obj.getInteger()));
        }
        sample3.control.clear();
        sample3.control.addAll(tempList);

        sample4 = new HashSetBenchmark();
        sample4.setUp(100000, 100, 16);
        tempList = new ArrayList<HashObject>();
        for (HashObject obj : sample4.control) {
            tempList.add(new HashObject(obj.getInteger()));
        }
        sample4.control.clear();
        sample4.control.addAll(tempList);

        sample5 = new HashSetBenchmark();
        sample5.setUp(100000, 100, 2);
        tempList = new ArrayList<HashObject>();
        for (HashObject obj : sample5.control) {
            tempList.add(new HashObject(obj.getInteger()));
        }
        sample5.control.clear();
        sample5.control.addAll(tempList);
    }
}
