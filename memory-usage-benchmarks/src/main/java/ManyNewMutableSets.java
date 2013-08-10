public class ManyNewMutableSets {
    public static void main(String[] args) {
        scala.collection.mutable.Set<Integer>[] set = SetHelper.createManyNewMutableSets();
        System.out.println(set[0].size());
    }
}
