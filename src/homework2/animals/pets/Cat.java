package homework2.animals.pets;

import homework2.animals.AbsAnimal;
import homework2.data.ColorData;

public class Cat extends AbsAnimal {
    public Cat(String name, int age, int weight, ColorData colorData) {
        super(name, age, weight, colorData);
    }

    @Override
    public void say() {
        System.out.println("Мяу");
    }

}
