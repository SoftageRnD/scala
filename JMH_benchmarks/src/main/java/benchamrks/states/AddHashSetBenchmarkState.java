package benchamrks.states;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * User: alex42rus
 * Date: 6/22/13
 * Time: 6:59 PM
 * To change this template use File | Settings | File Templates.
 */

@State
public class AddHashSetBenchmarkState {
    private static final Logger log = LoggerFactory.getLogger(AddHashSetBenchmarkState.class);

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

        sample2 = new HashSetBenchmark();
        sample2.setUp(100000, 20, 2);

        sample3 = new HashSetBenchmark();
        sample3.setUp(100000, 20, 16);

        sample4= new HashSetBenchmark();
        sample4.setUp(100000, 100, 16);

        sample5 = new HashSetBenchmark();
        sample5.setUp(100000, 100, 2);


        sample1.controlList.addAll(Arrays.asList(sample1.javaHashSet.toArray()));
        Collections.shuffle(sample1.controlList, new Random());

        sample1.scalaHashSet = new scala.collection.mutable.HashSet();
        sample1.newHashSet = new scala.collection.mutable.experimental.HashSet();
        sample1.javaHashSet = new HashSet<Object>();

        sample2.controlList.addAll(Arrays.asList(sample2.javaHashSet.toArray()));
        Collections.shuffle(sample2.controlList, new Random());

        sample2.scalaHashSet = new scala.collection.mutable.HashSet();
        sample2.newHashSet = new scala.collection.mutable.experimental.HashSet();
        sample2.javaHashSet = new HashSet<Object>();


        sample3.controlList.addAll(Arrays.asList(sample3.javaHashSet.toArray()));
        Collections.shuffle(sample3.controlList, new Random());

        sample3.scalaHashSet = new scala.collection.mutable.HashSet();
        sample3.newHashSet = new scala.collection.mutable.experimental.HashSet();
        sample3.javaHashSet = new HashSet<Object>();


        sample4.controlList.addAll(Arrays.asList(sample4.javaHashSet.toArray()));
        Collections.shuffle(sample4.controlList, new Random());

        sample4.scalaHashSet = new scala.collection.mutable.HashSet();
        sample4.newHashSet = new scala.collection.mutable.experimental.HashSet();
        sample4.javaHashSet = new HashSet<Object>();


        sample5.controlList.addAll(Arrays.asList(sample5.javaHashSet.toArray()));
        Collections.shuffle(sample5.controlList, new Random());

        sample5.scalaHashSet = new scala.collection.mutable.HashSet();
        sample5.newHashSet = new scala.collection.mutable.experimental.HashSet();
        sample5.javaHashSet = new HashSet<Object>();
    }

}
