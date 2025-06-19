package homework2.factory;

import homework2.animals.AbsAnimal;
import homework2.animals.birds.Duck;
import homework2.animals.pets.Cat;
import homework2.animals.pets.Dog;
import homework2.data.AnimalTypeData;
import homework2.data.ColorData;

public class AnimalFactory {
    private String name = "";
    private int age = -1;
    private int weight = -1;
    private ColorData color = null;

    public AnimalFactory(String name, int age, int weight, ColorData color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public AbsAnimal createAnimal(AnimalTypeData animalTypeData) {
        switch (animalTypeData) {
            case CAT: {
                return new Cat(name, age, weight, color);
            }
            case DOG: {
                return new Dog(name, age, weight, color);
            }
            case DUCK: {
                return new Duck(name, age, weight, color);
            }
            case null, default: {
                throw new RuntimeException(String.format("Animaal %s is not supported",
                                           animalTypeData.name().toLowerCase()));
            }
        }
    }

}
