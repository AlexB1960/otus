package homework1.mistakes;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BinaryPrinter printer = createPrinter(12);

        System.out.println("Size: " + printer.getSize());

        int value = -1;
        doPrint(printer, value);
        System.out.println("Size: " + printer.getSize());


    }

    private static BinaryPrinter createPrinter(int size){
        return new BinaryPrinter(size);
    }

    private static void doPrint (BinaryPrinter printer, int value) {
        printer.print(value);
        try{
            printer.setSize(value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}