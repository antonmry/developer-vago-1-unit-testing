import spock.lang.*

class Publisher {
    List<Subscriber> subscribers = []
    int messageCount = 0
    void send(String message){
        subscribers*.receive(message)
        messageCount++
    }
}

interface Subscriber {
    String receive(String message)
}

class MockStubGroovyExampleSpec extends Specification {

    Publisher publisher = new Publisher()
    Subscriber subscriber = Mock()
    Subscriber subscriber2 = Mock()

    def setup() {
        publisher.subscribers << subscriber // << is a Groovy shorthand for List.add()
        publisher.subscribers << subscriber2
    }

    def "mock example"() {
        when:
        publisher.send("hello")

        then:
        1 * subscriber.receive("hello")
        1 * subscriber2.receive("hello")
    }

    def "stub example"() {
        setup:
        subscriber.receive(_) >> "ok"

        when:
        publisher.send("message1")

        then:
        subscriber.receive("message1") == 'ok'
    }
}

