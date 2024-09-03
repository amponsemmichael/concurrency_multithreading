import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PerformanceComparison {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        // Benchmark for ArrayList
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add("Element " + i);
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList add: " + (endTime - startTime) + " ns");

        // Benchmark for CopyOnWriteArrayList
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            copyOnWriteArrayList.add("Element " + i);
        }
        endTime = System.nanoTime();
        System.out.println("CopyOnWriteArrayList add: " + (endTime - startTime) + " ns");
    }
}

