import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberPrinter {
    private AtomicInteger counter = new AtomicInteger();
    private ArrayList<Integer> sequence = new ArrayList<>();

    private class CounterExecutor implements Callable {

        @Override
        public Object call() throws Exception {
            sequence.add(counter.incrementAndGet());
            return null;
        }
    }

    public void printNumberUsingThread(final int maxNumber) throws InterruptedException {
        assert maxNumber >= 1;

        var poolExecutor = Executors.newSingleThreadExecutor();

        var threads = new CounterExecutor[maxNumber];
        Arrays.fill(threads, new CounterExecutor());

        List<Callable<Object>> list = Arrays.asList(threads);

        poolExecutor.invokeAll(list);
        poolExecutor.shutdown();
        poolExecutor.awaitTermination(120, TimeUnit.SECONDS);

        System.out.println(sequence);
    }

    /**
     * Recursive function to print number without loop, if or switch-case comparison, usage of stream API also prohibited
     * NOTE: WILL FAIL on big numbers ~ a few thousands
     *
     * @param maxNumber - Maximum number to print
     * @return
     */
    public static int printNumbersRecursive(final int maxNumber) {
        var number = (maxNumber <= 0) ? -1 : printNumbersRecursive(maxNumber - 1);
        System.out.println(maxNumber);
        return maxNumber;
    }
}
