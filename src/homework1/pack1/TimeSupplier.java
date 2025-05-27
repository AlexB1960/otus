package homework1.pack1;

public class TimeSupplier implements TimeSupplierInterface {

    public long getTime() {
        return System.currentTimeMillis();
    }
}
