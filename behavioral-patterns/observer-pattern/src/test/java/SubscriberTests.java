import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SubscriberTests {

    private final ByteArrayOutputStream capture = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(capture));
    }

    @Test
    public void test1() {
        Publisher publisher = new Publisher(2);
        Observer observer1 = new Subscriber(1);
        Observer observer2 = new Subscriber(2);

        publisher.registerObserver(observer1);
        publisher.registerObserver(observer2);

        publisher.setState("Hello World!");
        Assertions.assertEquals(
                "Subscriber(1):\tSubscribe a message from publisher: Hello World!\n" +
                        "Subscriber(2):\tSubscribe a message from publisher: Hello World!",
                capture.toString().trim()
        );
        publisher.unregisterObserver(observer2);
        publisher.setState("Doing good?");
        Assertions.assertEquals(
                "Subscriber(1):\tSubscribe a message from publisher: Hello World!\n" +
                        "Subscriber(2):\tSubscribe a message from publisher: Hello World!\n" +
                        "Subscriber(1):\tSubscribe a message from publisher: Doing good?",  //  new message added...
                capture.toString().trim()
        );
    }
}
