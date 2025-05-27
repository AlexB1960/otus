package homework1.pack1;

public class POSIXTimeSupplier extends TimeSupplier {

    public long getTime() {
        return (super.getTime() / 1000);
    }
}
