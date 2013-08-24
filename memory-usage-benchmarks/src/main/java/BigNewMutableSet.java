import scala.collection.mutable.experimental.HashSet;

public class BigNewMutableSet {
    public static void main(String[] args) {
        scala.collection.mutable.experimental.HashSet<Integer> set = new HashSet<Integer>();
        SetHelper.populateBigMutableSet(set);
        System.out.println(set.size());
    }
}
