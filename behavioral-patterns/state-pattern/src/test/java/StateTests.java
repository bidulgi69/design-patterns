import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateTests {

    @Test
    public void test1() {
        Context trafficLight = new TrafficLight();
        Color[] transition1 = trafficLight.transition();
        Assertions.assertEquals(
                Color.RED,
                transition1[0]
        );
        Assertions.assertEquals(
                Color.YELLOW,
                transition1[1]
        );
        Assertions.assertInstanceOf(
                YellowLight.class,
                trafficLight.getState()
        );
        Traffic.cars.forEach(car -> Assertions.assertEquals(1, car.getMovingStep()));
        Traffic.pedestrians.forEach(pedestrian -> Assertions.assertEquals(1, pedestrian.getMovingStep()));

        Color[] transition2 = trafficLight.transition();
        Assertions.assertEquals(
                Color.YELLOW,
                transition2[0]
        );
        Assertions.assertEquals(
                Color.GREEN,
                transition2[1]
        );
        Assertions.assertInstanceOf(
                GreenLight.class,
                trafficLight.getState()
        );
        Traffic.cars.forEach(car -> Assertions.assertEquals(0, car.getMovingStep()));
        Traffic.pedestrians.forEach(pedestrian -> Assertions.assertEquals(2, pedestrian.getMovingStep()));

        Color[] transition3 = trafficLight.transition();
        Assertions.assertEquals(
                Color.GREEN,
                transition3[0]
        );
        Assertions.assertEquals(
                Color.RED,
                transition3[1]
        );
        Assertions.assertInstanceOf(
                RedLight.class,
                trafficLight.getState()
        );
        Traffic.cars.forEach(car -> Assertions.assertEquals(2, car.getMovingStep()));
        Traffic.pedestrians.forEach(pedestrian -> Assertions.assertEquals(0, pedestrian.getMovingStep()));
    }
}
