package homework1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FunctionUtilsHexToBin {
    public static String hexToBin(String hexBase) {
        //TODO
        return "010";
    }
    private FunctionUtilsHexToBin() {

    }

    public static void main(String[] args) {
        System.out.println(
                "При вводе числа 17, метод должен вернуть 10111 - '"
                        + FunctionUtilsHexToBin.hexToBin("17")
                        + "'"
        );
    }
}