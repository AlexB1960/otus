package homework2.animals.birds;

import homework2.animals.AbsAnimal;

public class Duck extends AbsAnimal implements Flying {

    @Override
    public void say() {
        System.out.println("Кря");
    }

    public void fly() {
        System.out.println("Я лечу");
    }

}
