package solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class FirstWrongLSP {
    private static class Animal {
        public void makeSound(String sound) {
            System.out.println(sound);
        }
    }

    private static class Fish extends Animal {
        @Override
        public void makeSound(String sound) {
            throw new UnsupportedOperationException("fish is silent");
        }
    }

    private static class Cat extends Animal {
        @Override
        public void makeSound(String sound) {
            super.makeSound(sound);
        }
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        Cat cat = new Cat();
        Fish fish = new Fish();
        animals.add(cat);
        animals.add(fish);
        animals.forEach(animal -> animal.makeSound("Myau"));
    }
}
