package homework1;

public class SecondJClass {

    static Cat[] kitty = new Cat[5];



        public static void main(String[] args) {
            countDown(5);

            kitty[0].name="Catty";
            System.out.println(kitty[0].name);
        }

        public static void countDown(int n){
            if (n == 0) {
                System.out.println("Готово!");
            } else {
                System.out.println(n);
                countDown(n - 1);
            }
        }


        //System.out.println("Денег нет");





        /*
        //массивы
        int[] numbers;
        numbers = new int[6];
        numbers[0] = 42;
        numbers[1] = 14;
        numbers[2] = 15;

        int[] numbers2 = new int[6];
        int[] numbers3 = new int[]{42,14,15,56,3};
        int[] numbers4 = {42,14,15};

        int size=numbers.length;
        //System.out.println(size);
        //System.out.println(numbers[2]);



        //if
        int num = 10;
        if(num > 0) System.out.println("Больше 0");
            System.out.println("Всегда напечатаю");


        //if-else
        int num2 = 10;
        if (num > 0) {  System.out.println("Больше 0");
        } else {
            System.out.println("Меньше 0");
        }
        System.out.println("Всегда напечатаю");


        //тернарный оператор
        int num3 = 10;
        boolean x = num3 > 0;
        String message = x ? "Больше 0" : "Меньше 0";
        System.out.println(message);
        System.out.println("Всегда напечатаю");



        //циклы for
        for (int i = 0; i <numbers.length; i++){  System.out.println(numbers[i]);
        }



        //for each
        for (int d: numbers){  System.out.println(d);
        }


        //while
        int cash = 100;

        while (cash > 0) {
            System.out.println("Купил что то очень нужное");  cash = cash - 20;
        }

        //do- while
        int cash2 = 100;
        do {
            System.out.println("Купил что-то очень нужное 2");
            cash2 = cash2 - 20;
        } while (cash2 > 0);




        //примеры с подвохом
        int count = 0;
        while (count > 0) {
            System.out.println("Привет!");
            count--;
        }


        int count2 = 0;
        do {
            System.out.println("Привет!");
            count2--;
        } while (count2 > 0);



                int day = 3;
String dayName;

switch (day) {
    case 1:
        dayName = "Понедельник";
        break;
    case 2:
        dayName = "Вторник";
        break;
    case 3:
        dayName = "Среда";
        break;
    case 4:
        dayName = "Четверг";
        break;
    case 5:
        dayName = "Пятница";
        break;
    case 6:
        dayName = "Суббота";
        break;
    case 7:
        dayName = "Воскресенье";
        break;
    default:
        dayName = "Неизвестный день";
        break;
}

System.out.println(dayName);


         */

}
