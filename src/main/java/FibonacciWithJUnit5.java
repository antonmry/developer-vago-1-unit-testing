import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class FibonacciWithJUnit5 {

    public int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 2) + fibonacci(n - 1);
    }

    @Test
    public void fibonacciTestSimple() {
        FibonacciWithJUnit5 f = new FibonacciWithJUnit5();
        Assertions.assertTrue(
                fibonacci(4) == 3,
                () -> "Fibonnaci number " + 4 + " is " + 3);
    }

    @Test
    public void fibonacciTestZero() {
        FibonacciWithJUnit5 f = new FibonacciWithJUnit5();
        assertFalse(f.fibonacci(1) == 0);
    }

    @Test
    public void bestFibonacciTestSimple() {
        FibonacciWithJUnit5 f = new FibonacciWithJUnit5();
        assertEquals(f.fibonacci(4), 3);
    }

    // JUnit 5
    @Disabled("Demo, non o facer na casa ;-)")
    @Test
    public void ignoredFibonacciTestSimple() {
        FibonacciWithJUnit5 f = new FibonacciWithJUnit5();
        assertEquals(f.fibonacci(4), 0);
    }

    @Test
    public void testAssertThatBothContainsString() {
        FibonacciWithJUnit5 f = new FibonacciWithJUnit5();
        String temp = f.fibonacci(1) + " " + f.fibonacci(4);
        Assertions.assertAll("Our composed test",
                () -> Assertions.assertTrue(temp.contains("1")),
                () -> Assertions.assertTrue(temp.contains("3"))
        );
    }

    @Test()
    public void testException() {
        FibonacciWithJUnit5 f = new FibonacciWithJUnit5();
        Integer i = null;
        Assertions.assertThrows(NullPointerException.class, () -> f.fibonacci(i.intValue()));
    }

    @Test()
    public void testTimeout() throws InterruptedException {
        Assertions.assertTimeout(Duration.ofMillis(1), () -> fibonacci(30));
        //Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> fibonacci(100));
    }

    private static FibonacciWithJUnit5 f2;

    @BeforeAll
    public static void setupTest() {
        f2 = new FibonacciWithJUnit5();
    }

    @AfterAll
    public static void clear() {
        f2 = null;
    }

    @Test
    public void fibonacciTestSimpleWithBefore() {
        assert (f2.fibonacci(4) == 3);
    }

    @AfterEach
    public void done() {
        System.out.println("Done!");
    }
}
