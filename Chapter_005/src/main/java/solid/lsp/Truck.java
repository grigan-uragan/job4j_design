package solid.lsp;

import java.util.Objects;

public class Truck implements Auto {

    private String carModel;

    public Truck(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public int size() {
        return 2;
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
        Truck truck = (Truck) o;
        return Objects.equals(carModel, truck.carModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carModel);
    }
}
