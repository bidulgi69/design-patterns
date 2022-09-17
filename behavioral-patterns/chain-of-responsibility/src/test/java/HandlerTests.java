import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HandlerTests {

    private final ByteArrayOutputStream capture = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(capture));
    }

    @Test
    public void test1() {
        Handler storeApiHandler = new StoreApiHandler();
        Handler kitchenApiHandler = new KitchenApiHandler();
        Handler deliveryApiHandler = new DeliveryApiHandler();

        //  storeApiHandler -> kitchenApiHandler -> deliveryApiHandler
        storeApiHandler
                .setNext(kitchenApiHandler)
                .setNext(deliveryApiHandler);
        //  route to store service
        storeApiHandler.handleRequest(
                "/api/store/1",
                null
        );
        Assertions.assertEquals(
                "[StoreApiHandler::\tHandle request...]",
                capture.toString().trim()
        );
        //  route to kitchen service
        storeApiHandler.handleRequest(
                "/api/kitchen/1",
                null
        );
        Assertions.assertEquals(
                "[StoreApiHandler::\tHandle request...]\n" +
                "[KitchenApiHandler::\tHandle request...]",
                capture.toString().trim()
        );
        //  route to delivery service
        storeApiHandler.handleRequest(
                "/api/delivery/1",
                null
        );
        Assertions.assertEquals(
                "[StoreApiHandler::\tHandle request...]\n" +
                        "[KitchenApiHandler::\tHandle request...]\n" +
                        "[DeliveryApiHandler::\tHandle request...]",
                capture.toString().trim()
        );
    }

    @Test
    public void test2_next_assigned_properly() {
        Handler handler1 = new StoreApiHandler();
        Handler handler2 = new KitchenApiHandler();

        handler1.setNext(handler2);

        Assertions.assertEquals(
                handler2,
                handler1.getNext()
        );
    }
}
