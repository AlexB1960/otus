package homework1.animals;

public class Hello {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Puppy pup = new Puppy();

        dog.name = "Пес";
        pup.name = "Щенок";

        String r = "гав гав гав";
        dog.speak(r);
        r = "гав";
        pup.speak(r);
        dog.speak();
        pup.speak();
        //dog.color;

        //System.out.println(dog.name);
        //System.out.println(pup.name);
        //pup.names();

    }
}
