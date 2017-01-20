package salestax;

import static salestax.InputOutput.products;


public class CurrentApp {

    static InputOutput inout = new InputOutput();

    public static void main(String[] args) {

        Receipt receipt = new Receipt();

        inout.input();
        receipt.printReceipt(products);
    }
}
