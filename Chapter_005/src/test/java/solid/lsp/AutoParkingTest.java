package solid.lsp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AutoParkingTest {

    @Test
    public void shouldStandByOneCar() {
        Auto car = new Car("Toyota");
        Auto truck = new Truck("Volvo");
        AutoParking parking = new AutoParking(1, 1);
        assertThat(true, is(parking.parkIn(car)));
    }

    @Test
    public void shouldStandByOneTruck() {
        Auto truck = new Truck("Volvo");
        Parking parking = new AutoParking(1, 1);
        assertThat(true, is(parking.parkIn(truck)));
    }

    @Test
    public void shouldStandByTruckOnCarPark() {
        Auto truck = new Truck("Volvo");
        Parking parking = new AutoParking(2, 0);
        assertThat(true, is(parking.parkIn(truck)));
    }

    @Test(expected = IllegalStateException.class)
    public void whenParkingFullThrowException() {
        Auto truck = new Truck("Volvo");
        Auto car = new Car("Toyota");
        Parking parking = new AutoParking(2, 0);
        parking.parkIn(car);
        assertThat(true, is(parking.parkIn(truck)));
    }

}