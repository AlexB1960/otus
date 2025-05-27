package homework1.animals;

public class Puppy extends Dog {
    String name ="Собачонок";
    String color;
    Dog d = new Dog();
    String s = d.name;
    String s2 = this.name;


    public void names() {
        String name = super.name;
        System.out.println(name + this.name);

    }

    public void speak() {
        System.out.println("May");
    };

}
