package homework1;

import java.util.Random;

public class SecondClass {

    public static void main(String[] args) {
        System.out.println("Hello!");
        System.err.println("Hello ERROR");

        boolean a = true;
        boolean b = false;
        System.out.println(a^b);



        final int[][] num = new int[][]{{1,2,3},{4,5,6}};
        //Двухмерный массив
        int n = 2;
        int m = 3;
        int[][] nums = new int[n][m];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //nums[i][j] = random.nextInt(10);
                System.out.print(num[i][j] + " ");
                if ((j==m-1)) {
                    System.out.println();
                }
            }
        }

        System.out.println();
        System.out.println("Длина массива = " + num.length);

    }
}
