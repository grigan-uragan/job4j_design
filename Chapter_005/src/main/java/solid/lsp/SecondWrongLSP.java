package solid.lsp;

import java.util.List;

public class SecondWrongLSP {
    private static class Animal {
        private int speed;

        public Animal(int speed) {
            this.speed = speed;
        }

        public void move() {
            System.out.println("move " + speed);
        }

        public int getSpeed() {
            return speed;
        }
    }

    private static class Dog extends Animal {
        public Dog(int speed) {
            super(speed);
        }

        public void run() {
            System.out.println("run " + this.getSpeed());
        }

        @Override
        public void move() {
            run();
        }
    }

    private static class Cat extends Animal {
        public Cat(int speed) {
            super(speed);
        }

        public void jump() {
            if (this.getSpeed() < 5) {
                throw new IllegalArgumentException("cats more faster");
            }
            System.out.println("jump " + this.getSpeed());
        }

        @Override
        public void move() {
            jump();
        }
    }

    public static void main(String[] args) {
        Cat cat = new Cat(13);
        Dog dog = new Dog(4);
        List<Animal> animals = List.of(cat, dog);
        animals.forEach(Animal::move);
    }
}
