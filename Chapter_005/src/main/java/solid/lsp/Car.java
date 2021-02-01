package solid.lsp;

import java.util.Objects;

public class Car implements Auto {

    private String carModel;

    public Car(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public int size() {
        return 1;
    }

    public String getCarModel() {
        return carModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(carModel, car.carModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carModel);
    }
}
