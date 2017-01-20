package salestax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static salestax.InputOutput.products;


public class Product {

    int quantity;
    double cost;
    double tax;
    String name;
    Boolean isImported;
    Boolean isExempt;
    Boolean exists = true;

    public Product(InputOutput inputoutput) {

        this.quantity = inputoutput.quantity;
        this.cost = inputoutput.cost;
        this.name = inputoutput.name;
        this.isImported = inputoutput.isImported;
        this.isExempt = inputoutput.isExempt;
        getTaxAmount();
    }

    private void getTaxAmount() {

        if (isImported) {
            if (isExempt) {
                this.tax = ((cost * quantity * 5)/100);
            } else {
                this.tax = ((cost * quantity * 15)/100); 
            }
        } else {
            this.tax = cost * quantity;
            if (isExempt) {
                this.tax = 0.00;
            } else {
                this.tax = ((cost * quantity * 10)/100);
            }
        }
    }
}
