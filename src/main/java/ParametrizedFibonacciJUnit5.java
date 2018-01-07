import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParametrizedFibonacciJUnit5 {

    final int[] results = {1, 3};

    // This should be improved, see Test2.
    private static int i = 0;

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(ints = { 1, 4 })
    public void test(int n) {
        FibonacciWithJUnit5 f = new FibonacciWithJUnit5();
        Assertions.assertEquals(f.fibonacci(n), results[i]);
        i++;
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @CsvSource({"1, 1", "4, 3"})
    public void test2(int input , int expected) {
        FibonacciWithJUnit5 f = new FibonacciWithJUnit5();
        Assertions.assertEquals(f.fibonacci(input), expected);
    }
}
