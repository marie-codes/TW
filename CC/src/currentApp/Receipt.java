package salestax;

import java.text.DecimalFormat;
import java.util.List;


public class Receipt {

    double totalTaxAmount = 0.00;
    double totalAmount = 0.00;
    double finalTotalAmount = 0.00;
    
    String printReceipt(List<Product> items) {
        DecimalFormat df = new DecimalFormat("#.##");

        items.forEach((item) -> {
            String tempName = "";
            double newItemCost = 0.00;
            
            if (item.isImported == true) {
                tempName = ("imported " + item.name);
            } else {
                tempName = item.name;
            }

            totalTaxAmount += item.tax;
            totalAmount += (item.cost * item.quantity);
            newItemCost = (item.cost * item.quantity) + item.tax;
            finalTotalAmount = totalAmount + totalTaxAmount;
            System.out.println(item.quantity + " " + tempName + ": " + df.format(newItemCost));
        });

        System.out.println("Sales Taxes: " + df.format(totalTaxAmount) + "\nTotal: " + df.format(finalTotalAmount));
        return "";
    }
}
