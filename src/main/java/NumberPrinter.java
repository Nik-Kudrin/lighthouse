public class NumberPrinter {
    /**
     * Recursive function to print number without loop, if or switch-case comparison
     * Usage of stream API also prohibited
     *
     * @param maxNumber - Maximum number to print
     * @return
     */
    public static int printNumbers(final int maxNumber) {

        var number = (maxNumber <= 0) ? -1 : printNumbers(maxNumber - 1);
        System.out.println(maxNumber);
        return maxNumber;
    }
}
