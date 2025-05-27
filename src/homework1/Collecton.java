package homework1;

import java.util.*;

public class Collecton {
    private int size;

    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();
        fruits.add("banana");
        fruits.add("banana2");
        fruits.add("banana3");
        fruits.add(1,"banana1");

        System.out.println(fruits);
        System.out.println("first = " + fruits.get(1));
        System.out.println(fruits.size());
        System.out.println();

        fruits.set(0, "apple");
        try {
            System.out.println(fruits.get(20));
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Ошибка - " + e.getMessage());
        }
        System.out.println(fruits);

        fruits.remove(0);
        System.out.println(fruits);
        System.out.println(fruits.size());
        System.out.println();

        System.out.println(fruits.hashCode());
        System.out.println("----------------------------------------------------");



        List<String> numbers = new LinkedList<>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");
        numbers.add(1,"zero");
        numbers.remove(1);
        System.out.println(numbers);
        System.out.println("----------------------------------------------------");




        Set <String> cities = new HashSet<>();
        cities.add("1Moscow");
        cities.add("2Orel");
        cities.add("3Orel");
        cities.add("4Orel");
        System.out.println(cities);
        Set <String> cities2 = new HashSet<>();
        cities2.add("1Moscow");
        cities2.add("4Orel");
        cities2.add("4Orel");
        cities2.add("4Orel");
        System.out.println(cities2);
        System.out.println("----------------------------------------------------");
        cities.retainAll(cities2);
        System.out.println(cities);


        int numerator = 10;
        int denumerator = 0;

        try {
            int result = numerator / denumerator;
        }
        catch (ArithmeticException e) {
            System.out.println("Division by zero");
        }
        finally {
            System.out.println("This block is always executed");
        }


        Map<String, String> color = new HashMap<>();
        color.put("Alexey", "red");
        color.put("Jana", "green");
        color.put("Jan", "green");
        color.put("Tatiana", "blue");
        color.putIfAbsent("Jana", "blue");
        System.out.println(color);
        System.out.println("----------------------------------------------------");


        for (Map.Entry<String, String> d: color.entrySet()) {
            if (d.getValue().equals("green")) {
                System.out.println(d);
            }
        }
        System.out.println("----------------------------------------------------");
        //color.forEach();
        //String message = x ? "Больше 0" : "Меньше 0";




    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void print() {
        List<String> frut = new ArrayList<>();
        frut.add("bound1");
        frut.add("bound2");
        frut.add("bound3");

        setSize(1);
        int n = getSize();
        System.out.println("first = " + frut.get(n));
        System.out.println(frut);
    }



}
