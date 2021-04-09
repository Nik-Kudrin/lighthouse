import org.junit.jupiter.api.Test;

public class NumberPrinterTest {
    @Test
    void maxIntValueTest() {
        NumberPrinter.printNumbers(Integer.MAX_VALUE);
    }

    @Test
    void negativeValueTest() {
        NumberPrinter.printNumbers(-2);
    }
}
