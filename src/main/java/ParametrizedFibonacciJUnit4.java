import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParametrizedFibonacciJUnit4 {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}
        });
    }

    private int fInput;

    private int fExpected;

    public ParametrizedFibonacciJUnit4(int input, int expected) {
        fInput = input;
        fExpected = expected;
    }

    @Test
    public void test() {
        FibonacciWithJUnit4 f = new FibonacciWithJUnit4();
        assertEquals(fExpected, f.fibonacci(fInput));
    }
}
