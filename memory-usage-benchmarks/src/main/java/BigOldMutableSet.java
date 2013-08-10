import scala.collection.mutable.HashSet;

public class BigOldMutableSet {
    public static void main(String[] args) {
        scala.collection.mutable.HashSet<Integer> set = new HashSet<Integer>();
        SetHelper.populateBigMutableSet(set);
        System.out.println(set.size());
    }
}
