import org.junit.jupiter.api.Test;

public class NumberPrinterTest {
    @Test
    void smallValueTest() throws InterruptedException {
        new NumberPrinter().printNumberUsingThread(100_000);
    }

    @Test
    void hugeIntValueTest() throws InterruptedException {
        new NumberPrinter().printNumberUsingThread(1_000_000);
    }

    @Test
    void maxIntValueTest() throws InterruptedException {
        new NumberPrinter().printNumberUsingThread(Integer.MAX_VALUE);
    }

    @Test
    void negativeValueTest() throws InterruptedException {
        new NumberPrinter().printNumberUsingThread(-3);
    }

    // Recursive solution: WILL NOT WORK on big numbers (over ~ 15_000)
    @Test
    void recursive_smallIntNumberTest() {
        NumberPrinter.printNumbersRecursive(8);
    }

    @Test
    void recursive_hugeIntValueTest() {
        NumberPrinter.printNumbersRecursive(20_000);
    }
}
