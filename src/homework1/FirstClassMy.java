package homework1;

public class FirstClassMy {
    public static void main(String[] args) {
        System.out.println("Hello, World!");


        int per = -101230;
        Integer per2 = -101230;
        boolean r = (per == per2);
        System.out.println("Check== " + r);
        r = per2.equals(per);
        System.out.println("CheckEquals " + r);
        System.out.println(Integer.valueOf(per) == per2);
        System.out.println(Integer.valueOf(per));



        int a = 5;
        int poPo =128;
        boolean poo=true;
        //System.out.println(poPo + "\n" + a);
        //System.out.println(poo);

        Integer gh=456;
        Cat catty= new Cat();//homework1.Cat(34,"gh");
        //catty.name1="fg";
        //catty.age=34;


        int a4 = 10;
        char b = 10;
        int result = Integer.compare(a4, b);
        //System.out.println(result);


        Integer i=0;
        Integer integer=i.decode("56");
        //System.out.println(p);
        int max = Integer.MAX_VALUE;
        //System.out.println(max);






        // byte
        byte byteValue = 100; // Значение в диапазоне от -128 до 127
        //System.out.println("byteValue: " + byteValue);

        // short
        short shortValue = 10000; // Значение в диапазоне от -32,768 до 32,767
        //System.out.println("shortValue: " + shortValue);

        // int
        int intValue = 100000; // Значение в диапазоне от -2^31 до 2^31 - 1
        //System.out.println("intValue: " + intValue);

        // long
        long longValue = 10000000000L; // Значение в диапазоне от -2^63 до 2^63 - 1
        //System.out.println("longValue: " + longValue);

        // float
        float floatValue = 3.14f; // Значение с плавающей запятой, обязательно добавляйте суффикс 'f'
        //System.out.println("floatValue: " + floatValue);

        // double
        double doubleValue = 3.141592653589793; // Значение с плавающей запятой
        //System.out.println("doubleValue: " + doubleValue);

        // char
        char charValue = 'A'; // Один символ
        //System.out.println("charValue: " + charValue);

        // boolean - логическое значение
        boolean booleanValueTrue = true; // Логическое значение true
        boolean booleanValueFalse = false; // Логическое значение false
        //System.out.println("booleanValueTrue: " + booleanValueTrue);
        //System.out.println("booleanValueFalse: " + booleanValueFalse);


        //логическое и
        boolean a1 = true;
        boolean b1 = false;
        boolean c1 = true;

        //System.out.println("a & b: " + (a & b)); // false
        //System.out.println("a & c: " + (a & c)); // true
        //System.out.println("b & c: " + (b & c)); // false

        //System.out.println("a && b: " + (a && b)); // false
        //System.out.println("a && c: " + (a && c)); // true
        //System.out.println("b && c: " + (b && c)); // false







        // автоматическое преобразование
        int i2 = 24888888;
        long l = i2; // автоматическое преобразование int в long
        float f = l; // автоматическое преобразование long в float

        //System.out.println("Int value: " + i);
        //System.out.println("Long value: " + l);
        //System.out.println("Float value: " + f);

        // явное приведение
        double d = 400000;
        long l2 = (long) d; // явное приведение double к long
        int i3 = (int) l; // явное приведение long к int

        //System.out.println("Double value: " + d);
        //System.out.println("Long value: " + l2);
        //System.out.println("Int value: " + i2);


        //String
        // Конкатенация строк
        char bnb='g';
        String str0 = "Hello";
        String str1 = "World";
        String result1 = str0 + " " + str1; // конкатенация строк
        //System.out.println(result1); // вывод: "Hello World"

        String str2 = "Hello, world! world world world";
        int length = str2.length(); // length = 13
        int index = str2.indexOf("world"); // index = 7
        boolean contains = str2.contains("Hello"); // contains = true
        System.out.println(contains);

        String sub = str2.substring(7); // sub = "world! world world world world"
        String sub2 = str2.substring(0, 5); // sub2 = "Hello"

        String upperCase = str2.toUpperCase(); // upperCase = "HELLO, WORLD!"
        String lowerCase = str2.toLowerCase(); // lowerCase = "hello, world!"

        String str3 = "   Hello, world!   ";
        String trimmed = str3.trim(); // trimmed = "Hello, world!"

        String str4 = "Hello, world!";
        String replaced = str4.replace("world", "Java"); // replaced = "Hello, Java!"
        System.out.println(replaced);



        int aa = 5;
        aa= aa-1;
        aa--;
        int bb = 5;
        boolean ааа =(aa == bb);
        //System.out.println(ааа);

        String str11 = new String("hello");
        String str22 = new String("hello");

        boolean ааа22 =str11.equals(str22);
        //System.out.println("str1 и str2 имеют одинаковое содержимое " + ааа22 );


    }
}
