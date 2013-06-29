import com.google.caliper.runner.CaliperMain;


/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
    //    CaliperMain.main(RemoveHashSetBenchmark.class, args);
        CaliperMain.main(AddHashSetBenchmark.class, args);
		System.out.println("Hello World!");
	}
}
