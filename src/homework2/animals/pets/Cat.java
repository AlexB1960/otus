package homework2.animals.pets;

import homework2.animals.AbsAnimal;
import homework2.data.ColorData;

public class Cat extends AbsAnimal {
    public Cat(long id, String name, String type, int age, int weight, ColorData colorData) {
        super(id, name, type, age, weight, colorData);
    }

    @Override
    public void say() {
        System.out.println("Мяу");
    }

}
