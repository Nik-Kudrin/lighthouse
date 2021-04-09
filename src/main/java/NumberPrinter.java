import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class NumberPrinter {
    private final StringBuilder stringBuilder = new StringBuilder();
    private int counter = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final ExecutorService poolExecutor = Executors.newCachedThreadPool();

    private class CounterExecutor implements Callable, Runnable {

        @Override
        public Object call() {
            synchronized (stringBuilder) {
                stringBuilder
                        .append(counter++)
                        .append(System.lineSeparator());
            }
            return null;
        }

        @Override
        public void run() {
            call();
        }
    }

    /**
     * Print positive integers from 1 till [maxNumber]
     *
     * @param maxNumber
     * @throws InterruptedException
     */
    public void printNumberUsingThread(final int maxNumber) throws InterruptedException {
        assert maxNumber >= 1;

        var threads = new CounterExecutor[maxNumber];
        Arrays.fill(threads, new CounterExecutor());

        List<Callable<Object>> list = Arrays.asList(threads);

        poolExecutor.invokeAll(list);
        poolExecutor.shutdown();
        poolExecutor.awaitTermination(120, TimeUnit.SECONDS);

        System.out.println(stringBuilder);
    }

    /**
     * Recursive function to print number without loop or stream API
     * NOTE: WILL FAIL on big numbers ~ a few thousands
     *
     * @param maxNumber - Maximum number to print
     * @return
     */
    public static int printNumbersRecursive(final int maxNumber) {
        var number = (maxNumber <= 1) ? -1 : printNumbersRecursive(maxNumber - 1);
        System.out.println(maxNumber);
        return maxNumber;
    }
}
