package homework2.factory;

import homework2.animals.AbsAnimal;
import homework2.animals.birds.Duck;
import homework2.animals.pets.Cat;
import homework2.animals.pets.Dog;
import homework2.data.AnimalTypeData;

public class AnimalFactory {

    public AbsAnimal createAnimal(AnimalTypeData animalTypeData) {

        switch (animalTypeData) {
            case CAT: {
                return new Cat();
            }
            case DOG: {
                return new Dog();
            }
            case DUCK: {
                return new Duck();
            }
            case null, default: {
                throw new RuntimeException(String.format("Animaal %s is not supported", animalTypeData.name().toLowerCase()));
            }
        }

    }

}
