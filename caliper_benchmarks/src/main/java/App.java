import com.google.caliper.Benchmark;
import com.google.caliper.runner.CaliperMain;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.out.println("you must supply at least one argument - benchmark class full qualified name");
            System.exit(-1);
        }
        String benchmarkClassName = args[0];
        String[] caliperArgs = Arrays.copyOfRange(args, 1, args.length);
        try {
            Class<? extends Benchmark> benchmarkClass = Class.forName(benchmarkClassName).asSubclass(Benchmark.class);
            System.out.println("Benchmark starting: " + benchmarkClassName);
            CaliperMain.main(benchmarkClass, caliperArgs);
        } catch (ClassNotFoundException e) {
            System.out.println("unknown benchmark class: " + benchmarkClassName);
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
