import spock.lang.FailsWith
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Timeout

import static java.util.concurrent.TimeUnit.MILLISECONDS

class ParametrizedFibonacciGroovySpec extends Specification {

    def "parametrized test"() {
        setup:
        BadFibonacci f = new BadFibonacci()

        expect:
        f.fibonacci(index) == fibonacciNumber

        where:
        index | fibonacciNumber
        1     | 1
        2     | 1
        3     | 2
    }

}
