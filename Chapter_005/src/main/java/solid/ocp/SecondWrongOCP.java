package solid.ocp;

public class SecondWrongOCP {
    public static class Uber {
        private Toyota toyota;
        private Kia kia;

        public Uber(Toyota toyota) {
            this.toyota = toyota;
        }

        public Uber(Kia kia) {
            this.kia = kia;
        }

        public void deliveryPassengersByToyota(String address) {
            toyota.driveTo(address);
        }

        public void deliveryPassengersByKia(String address) {
            kia.driveTo(address);
        }
    }

    public static class Toyota {

        public void driveTo(String address) {
            System.out.println("Toyota go to " + address);
        }
    }

    public static class Kia {
        public void driveTo(String address) {
            System.out.println("Kia go to " + address);
        }
    }

    public static void main(String[] args) {
        Toyota toyota = new Toyota();
        Kia kia = new Kia();
        Uber uberToyota = new Uber(toyota);
        Uber uberKia = new Uber(kia);
        uberToyota.deliveryPassengersByToyota("Tverskaya street");
        uberKia.deliveryPassengersByKia("Kremlin");
    }
}
