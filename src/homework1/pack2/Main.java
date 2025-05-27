package homework1.pack2;

import homework1.pack1.POSIXTimeSupplier;
import homework1.pack1.TimeSupplierInterface;

public class Main {
    public void printTime(TimeSupplierInterface timeSupplier) {
        System.out.println("POSIX Time = " + timeSupplier.getTime());
    }

    public static void main(String[] args) {
        TimeSupplierInterface timeSupplier = new POSIXTimeSupplier();
        new Main().printTime(timeSupplier);
    }
}
