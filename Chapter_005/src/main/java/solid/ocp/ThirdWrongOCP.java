package solid.ocp;

public class ThirdWrongOCP {
    private static class PetShop {
        public String sale() {
            return "KittyCat";
        }
    }

    private static class CarShop {
        public String sale() {
            return "oil filter";
        }
    }

    private static class Consumer {
        public void buy(PetShop petShop) {
            System.out.println(petShop.sale());
        }

        public void buy(CarShop carShop) {
            System.out.println(carShop.sale());
        }
    }

    public static void main(String[] args) {
            PetShop petShop = new PetShop();
            CarShop carShop = new CarShop();
            Consumer consumer = new Consumer();
            consumer.buy(petShop);
            consumer.buy(carShop);
    }
}
