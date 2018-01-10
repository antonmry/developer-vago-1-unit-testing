import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FibonacciWithJUnit4 {

    public int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 2) + fibonacci(n - 1);
    }

    @Test
    public void fibonacciTestSimple() {
        FibonacciWithJUnit4 f = new FibonacciWithJUnit4();
        assertTrue(fibonacci(4) == 3);
    }

    @Test
    public void fibonacciTestZero() {
        FibonacciWithJUnit4 f = new FibonacciWithJUnit4();
        assertFalse(f.fibonacci(1) == 0);
    }

    @Test
    public void improvedFibonacciTestSimple() {
        FibonacciWithJUnit4 f = new FibonacciWithJUnit4();
        assertEquals(f.fibonacci(4), 3);
    }

    @Ignore("Demo, non o facer na casa ;-)")
    @Test
    public void ignoredFibonacciTestSimple() {
        FibonacciWithJUnit4 f = new FibonacciWithJUnit4();
        assertEquals(f.fibonacci(4), 0);
    }

    @Test
    public void testAssertThatBothContainsString() {
        FibonacciWithJUnit4 f = new FibonacciWithJUnit4();
        String temp = fibonacci(1) + " " + fibonacci(4);
        assertThat(temp, both(containsString("0")).and(containsString("3")));
    }

    @Test(expected = NullPointerException.class)
    public void testException() {
        FibonacciWithJUnit4 f = new FibonacciWithJUnit4();
        Integer i = 0;
        i = null;
        f.fibonacci(i.intValue());
    }

    @Test(timeout = 1000)
    public void testTimeout() {
        try {
            fibonacci(100);
        } catch (Exception e) {
            // Don't do this at home
        }
    }

    private static FibonacciWithJUnit4 f2;

    @BeforeClass
    public static void setupTest() {
        f2 = new FibonacciWithJUnit4();
    }

    @AfterClass
    public static void clear() {
        f2 = null;
    }

    @Test
    public void fibonacciTestSimpleWithBefore() {
        assert (f2.fibonacci(4) == 3);
    }

    @After
    public void done() {
        System.out.println("Done!");
    }
}
