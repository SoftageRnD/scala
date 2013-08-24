public class ManyOldMutableSets {
    public static void main(String[] args) {
        scala.collection.mutable.Set<Integer>[] set = SetHelper.createManyOldMutableSets();
        System.out.println(set[0].size());
    }
}
