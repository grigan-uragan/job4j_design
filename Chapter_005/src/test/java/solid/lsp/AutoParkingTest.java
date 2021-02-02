package solid.lsp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AutoParkingTest {

    @Test
    public void shouldStandByOneCar() {
        Auto car = new Car("Toyota");
        Auto truck = new Truck("Volvo", 2);
        AutoParking parking = new AutoParking(1, 1);
        assertThat(true, is(parking.parkIn(car)));
    }

    @Test
    public void shouldStandByOneTruck() {
        Auto truck = new Truck("Volvo", 2);
        Parking parking = new AutoParking(1, 1);
        assertThat(true, is(parking.parkIn(truck)));
    }

    @Test
    public void shouldStandByTruckOnCarPark() {
        Auto truck = new Truck("Volvo", 2);
        Parking parking = new AutoParking(2, 0);
        assertThat(true, is(parking.parkIn(truck)));
    }

    @Test
    public void whenParkingThenParkInReturnFalse() {
        Auto truck = new Truck("Volvo", 2);
        Auto car = new Car("Toyota");
        Parking parking = new AutoParking(2, 0);
        parking.parkIn(car);
        assertThat(false, is(parking.parkIn(truck)));
    }

    @Test
    public void shouldCarGoAwayFromParking() {
        Auto car = new Car("Toyota");
        Parking parking = new AutoParking(1, 0);
        parking.parkIn(car);
        assertThat(true, is(parking.parkOut(car)));
    }

    @Test
    public void shouldTruckGoAwayFromParking() {
        Auto truck = new Truck("Volvo", 2);
        Parking parking = new AutoParking(2, 0);
        parking.parkIn(truck);
        assertThat(true, is(parking.parkOut(truck)));
    }

}