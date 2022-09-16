import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class SubscriberTests {

    private val capture = ByteArrayOutputStream()

    @BeforeEach
    fun setup() {
        System.setOut(PrintStream(capture))
    }

    @Test
    fun test1() {
        val observer1 = TextViewSubscriber(1)
        val observer2 = TextViewSubscriber(2)
        val observer3 = TextViewSubscriber(3)

        val textView = TextView().apply {
            subscribers.add(observer1)
            subscribers.add(observer2)
            subscribers.add(observer3)
        }

        with(textView) {
            text = "Hello world!"
            Assertions.assertEquals(
                "Subscriber(1):\tText is changed <empty> -> Hello world!\n" +
                        "Subscriber(2):\tText is changed <empty> -> Hello world!\n" +
                        "Subscriber(3):\tText is changed <empty> -> Hello world!\n",
                capture.toString()
            )

            subscribers.remove(observer1)
            text = "Doing good?"
            Assertions.assertEquals(
                "Subscriber(1):\tText is changed <empty> -> Hello world!\n" +
                        "Subscriber(2):\tText is changed <empty> -> Hello world!\n" +
                        "Subscriber(3):\tText is changed <empty> -> Hello world!\n" +
                        "Subscriber(2):\tText is changed Hello world! -> Doing good?\n" +
                        "Subscriber(3):\tText is changed Hello world! -> Doing good?\n",
                capture.toString()
            )

            subscribers.remove(observer2)
            text = "Goodbye friends!"
            Assertions.assertEquals(
                "Subscriber(1):\tText is changed <empty> -> Hello world!\n" +
                        "Subscriber(2):\tText is changed <empty> -> Hello world!\n" +
                        "Subscriber(3):\tText is changed <empty> -> Hello world!\n" +
                        "Subscriber(2):\tText is changed Hello world! -> Doing good?\n" +
                        "Subscriber(3):\tText is changed Hello world! -> Doing good?\n" +
                        "Subscriber(3):\tText is changed Doing good? -> Goodbye friends!\n",
                capture.toString()
            )
        }

    }
}