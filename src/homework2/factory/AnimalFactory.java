package homework2.factory;

import homework2.animals.AbsAnimal;
import homework2.animals.birds.Duck;
import homework2.animals.pets.Cat;
import homework2.animals.pets.Dog;
import homework2.data.AnimalTypeData;
import homework2.data.ColorData;

public class AnimalFactory {
    private long id = -1;
    private String name = "";
    private String type = "";
    private int age = -1;
    private int weight = -1;
    private ColorData color = null;

    public AnimalFactory(long id, String name, String type, int age, int weight, ColorData color) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public AbsAnimal createAnimal(AnimalTypeData animalTypeData) {
        type = animalTypeData.name().toLowerCase();
        switch (animalTypeData) {
            case CAT: {
                return new Cat(id, name, type, age, weight, color);
            }
            case DOG: {
                return new Dog(id, name, type, age, weight, color);
            }
            case DUCK: {
                return new Duck(id, name, type, age, weight, color);
            }
            case null, default: {
                throw new RuntimeException(String.format("Animaal %s is not supported",
                                           animalTypeData.name().toLowerCase()));
            }
        }
    }

}
