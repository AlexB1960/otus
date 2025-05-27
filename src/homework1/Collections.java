package homework1;

import java.util.*;
import java.util.Collection;

public class Collections {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("Zero");
        c.add("Second");
        c.add("Third");
        System.out.println(c.size());
        System.out.println(c);
        System.out.println();

        Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()) {
            //c.iterator().next() = "";
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println();
        //c.i


        System.out.println(c.contains("Third"));
        List<String> list = (List<String>) c;
        list.set(0, "First");
        list.set(1, "Second");
        list.add(3, "Fourth");
        System.out.println(list.indexOf("Third"));
        try {
            System.out.println(list.get(12));
            System.out.println("Before zero division");
            int i = 12 / 0;
            System.out.println("After zero division");
        }
        catch(IndexOutOfBoundsException e) {
            //e.printStackTrace();
            System.out.println("Hire was an IndexException");

        }
        catch(ArithmeticException e) {
            System.out.println("Hire was a division by zero");
        }
        finally {
            System.out.println("It is finally hire everywhere");
        }
        System.out.println();
        System.out.println(list.get(list.indexOf("Third")));


        List<String> c2 = Arrays.asList(new String[] {
                "First", "Fourth"
        });
        c.retainAll(c2);
        print(c);
        c.addAll(c2);
        print(c);

    }


    private static void print(Collection<String> c) {
        System.out.println();
        for (String s : c) {
            System.out.println(s);
        }
    }
}
