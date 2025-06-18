package homework2.animals.birds;

import homework2.animals.AbsAnimal;
import homework2.data.ColorData;

public class Duck extends AbsAnimal implements Flying {
    public Duck(long id, String name, String type, int age, int weight, ColorData colorData) {
        super(id, name, type, age, weight, colorData);
    }

    @Override
    public void say() {
        System.out.println("Кря");
    }

    public void fly() {
        System.out.println("Я лечу");
    }

}
