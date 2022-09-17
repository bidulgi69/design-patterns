import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BuilderTests {

    static final Customer customer = new Customer(
            1,
            "Joe",
            "(850) 722-4965\n" +
                    "8818 Stork Ave\n" +
                    "Youngstown, Florida(FL), 32466"
    );

    static final Restaurant restaurant = new Restaurant(
            1,
            "Hell's Kitchen",
            "(763) 427-2706\n" +
                    "519 Fred Scott Rd\n" +
                    "Pollock, Louisiana(LA), 71467"
    );

    static final List<OrderItem> orderItems = new ArrayList<>();

    @BeforeAll
    public static void setup() {
        orderItems.add(
                new OrderItem(
                        1,
                        new Cuisine(
                                1,
                                "Normal Bacon Burger",
                                3.8f
                        ),
                        2
                )
        );

        orderItems.add(
                new OrderItem(
                        2,
                        new Cuisine(
                                2,
                                "Bacon Shrimp Lettuce Burger",
                                4.6f
                        ),
                        1
                )
        );

        orderItems.add(
                new OrderItem(
                        3,
                        new Cuisine(
                                3,
                                "Mega Steak Grilled Burger",
                                6.4f
                        ),
                        1
                )
        );
    }

    @Test
    public void test0_with_no_optional_fields() {
        LocalDateTime start = LocalDateTime.now();
        Order order = new Order
                .OrderBuilder(customer, restaurant, orderItems, start)
                .build();

        Assertions.assertNotNull(order);
        Assertions.assertEquals(
                order.getCustomer(),
                customer
        );
        Assertions.assertEquals(
                order.getRestaurant(),
                restaurant
        );
        order.getOrderItems().forEach(item ->
                Assertions.assertTrue(orderItems.contains(item))
        );
        Assertions.assertEquals(
                order.getAcceptTime(),
                start
        );
        Assertions.assertEquals(
                order.getState(),
                State.ACCEPTED
        );
        //  check optional fields
        Assertions.assertNull(order.getReadyTime());
        Assertions.assertNull(order.getPreparingTime());
        Assertions.assertNull(order.getPickedUpTime());
        Assertions.assertNull(order.getDeliveryCompletedTime());
    }

    @Test
    public void test1_order_prepared() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime prepared = start.plusMinutes(40);
        Order order = new Order
                .OrderBuilder(customer, restaurant, orderItems, start)
                .readyTime(prepared)
                .preparingTime(40 * 60L)
                .build();

        Assertions.assertEquals(
                order.getAcceptTime(),
                start
        );
        Assertions.assertEquals(
                order.getReadyTime(),
                prepared
        );
        Assertions.assertNull(
                order.getPickedUpTime()
        );
        Assertions.assertNull(
                order.getDeliveryCompletedTime()
        );
        Assertions.assertEquals(
                order.getState(),
                State.PREPARED
        );
    }

    @Test
    public void test2_order_delivered() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime prepared = start.plusMinutes(40);
        LocalDateTime pickedUp = prepared.plusMinutes(5);
        LocalDateTime deliveryCompleted = pickedUp.plusMinutes(30);

        Order order = new Order
                .OrderBuilder(customer, restaurant, orderItems, start)
                .readyTime(prepared)
                .preparingTime(Duration.between(start, prepared).getSeconds())
                .pickedUpTime(pickedUp)
                .deliveryCompletedTime(deliveryCompleted)
                .build();

        Assertions.assertEquals(
                order.getAcceptTime(),
                start
        );
        Assertions.assertEquals(
                order.getReadyTime(),
                prepared
        );
        Assertions.assertEquals(
                order.getPreparingTime(),
                Duration.between(start, prepared).getSeconds()
        );
        Assertions.assertEquals(
                order.getPickedUpTime(),
                pickedUp
        );
        Assertions.assertEquals(
                order.getDeliveryCompletedTime(),
                deliveryCompleted
        );
        Assertions.assertEquals(
                order.getState(),
                State.DELIVERED
        );
    }
}
