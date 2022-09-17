import java.time.LocalDateTime;
import java.util.List;

class Order {
    private State state;
    private final Customer customer;
    private final Restaurant restaurant;
    private final List<OrderItem> orderItems;
    private final LocalDateTime acceptTime;
    private final LocalDateTime readyTime;
    private final Long preparingTime;
    private final LocalDateTime pickedUpTime;
    private final LocalDateTime deliveryCompletedTime;

    static class OrderBuilder {
        //  필수 필드
        private final Customer customer;
        private final Restaurant restaurant;
        private final List<OrderItem> orderItems;
        private final LocalDateTime acceptTime;
        //  optional fields
        //  초기값 설정 필요
        private LocalDateTime readyTime = null;
        private Long preparingTime = null;
        private LocalDateTime pickedUpTime = null;
        private LocalDateTime deliveryCompletedTime = null;

        public OrderBuilder(
                Customer customer,
                Restaurant restaurant,
                List<OrderItem> orderItems,
                LocalDateTime acceptTime
        ) {
            this.customer = customer;
            this.restaurant = restaurant;
            this.orderItems = orderItems;
            this.acceptTime = acceptTime;
        }

        public OrderBuilder readyTime(LocalDateTime readyTime) {
            this.readyTime = readyTime;
            return this;
        }

        public OrderBuilder preparingTime(Long preparingTime) {
            this.preparingTime = preparingTime;
            return this;
        }

        public OrderBuilder pickedUpTime(LocalDateTime pickedUpTime) {
            this.pickedUpTime = pickedUpTime;
            return this;
        }

        public OrderBuilder deliveryCompletedTime(LocalDateTime deliveryCompletedTime) {
            this.deliveryCompletedTime = deliveryCompletedTime;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    private Order(OrderBuilder builder) {
        this.customer = builder.customer;
        this.restaurant = builder.restaurant;
        this.orderItems = builder.orderItems;
        this.acceptTime = builder.acceptTime;
        this.readyTime = builder.readyTime;
        this.preparingTime = builder.preparingTime;
        this.pickedUpTime = builder.pickedUpTime;
        this.deliveryCompletedTime = builder.deliveryCompletedTime;

        if (builder.deliveryCompletedTime != null) {
            this.state = State.DELIVERED;
        } else if (builder.pickedUpTime != null) {
            this.state = State.PICKEDUP;
        } else if (builder.readyTime != null && builder.preparingTime != null) {
            this.state = State.PREPARED;
        } else {
            this.state = State.ACCEPTED;
        }
    }

    public State getState() {
        return state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public LocalDateTime getAcceptTime() {
        return acceptTime;
    }

    public LocalDateTime getReadyTime() {
        return readyTime;
    }

    public Long getPreparingTime() {
        return preparingTime;
    }

    public LocalDateTime getPickedUpTime() {
        return pickedUpTime;
    }

    public LocalDateTime getDeliveryCompletedTime() {
        return deliveryCompletedTime;
    }
}

class Customer {
    private final int customerId;
    private final String username;
    private final String address;

    public Customer(int customerId, String username, String address) {
        this.customerId = customerId;
        this.username = username;
        this.address = address;
    }
}

class Restaurant {
    private final int restaurantId;
    private final String name;
    private final String address;

    public Restaurant(int restaurantId, String name, String address) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
    }
}

class Cuisine {
    private final int cuisineId;
    private String name;
    private float cost;

    public Cuisine(int cuisineId, String name, float cost) {
        this.cuisineId = cuisineId;
        this.name = name;
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}

class OrderItem {
    private final int orderItemId;
    private final Cuisine cuisine;
    private int quantity;

    public OrderItem(int orderItemId, Cuisine cuisine, int quantity) {
        this.orderItemId = orderItemId;
        this.cuisine = cuisine;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

enum State {
    ACCEPTED,
    PREPARED,
    PICKEDUP,
    DELIVERED;
}