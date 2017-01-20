package salestax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import salestax.Product;
import salestax.Receipt;

public class InputOutput {

    Receipt receipt;

    int quantity = 1;
    double cost = 0.00;
    String name = "";
    Boolean isImported = false;
    Boolean isExempt = false;
    Boolean exists = true;
    static List<Product> products = new ArrayList<>();

    void input() {

        while (exists) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter the quantity of the item: ");
            quantityInput(scanner);

            System.out.println("Please enter the cost of the item: ");
            costInput(scanner);

            System.out.println("Please enter the item: ");
            nameInput(scanner);

            System.out.println("Is the product a book, medical product, or food? Enter Yes or No.");
            input1(scanner);

            System.out.println("Is the product imported? Enter Yes or No.");
            input2(scanner);

            Product item = createNewProduct();
            products.add(item);

            System.out.println("Is there another product? Enter Yes or No.");
            input3(scanner);
            if (exists == false) {
                break;
            }
            continue;
            
        }
    }

    void clearInfo() {
        quantity = 1;
        cost = 0.00;
        name = "";
        isImported = false;
        isExempt = false;
    }

    void quantityInput(Scanner scanner) {
        while (true) {
            try {
                String quantityInput = scanner.nextLine();
                quantity = (int) Integer.parseInt(quantityInput);
            } catch (Exception e) {
                System.out.println("Please enter a number. ");
                continue;
            }
            break;
        }
    }

    void costInput(Scanner scanner) {
        while (true) {
            try {
                String costInput = scanner.nextLine();
                cost = Double.parseDouble(costInput);
            } catch(Exception e1) {
                System.out.println("Please enter a number. ");
                continue;               
            }
            break;
        }
    }

    void nameInput(Scanner scanner) {
        String nameInput = scanner.nextLine();
        name = nameInput.toLowerCase();

        while (name.isEmpty()) {
            System.out.println("Please enter an item. ");
            name = scanner.nextLine().toLowerCase();
        }
    }

    void input1(Scanner scanner) {
        String input1 = scanner.nextLine().toLowerCase();

        while (input1.isEmpty()) {
            System.out.println("Please enter yes or no. ");
            input1 = scanner.nextLine().toLowerCase();
        }
        
        while (!((input1.equals("yes") || (input1.equals("no"))))) {
            System.out.println("Please enter yes or no. ");
            input1 = scanner.nextLine().toLowerCase();
        }
        
        if (input1.equals("yes")) {
            isExempt = true;
        }
    }
    

    void input2(Scanner scanner) {
        String input2 = scanner.nextLine().toLowerCase();

        while (input2.isEmpty()) {
            System.out.println("Please enter yes or no. ");
            input2 = scanner.nextLine().toLowerCase();
        }

         while (!((input2.equals("yes") || (input2.equals("no"))))) {
            System.out.println("Please enter yes or no. ");
            input2 = scanner.nextLine().toLowerCase();
        }
         
        if (input2.equals("yes")) {
            isImported = true;

        }
    }
    
    void input3(Scanner scanner) {
        String input3 = scanner.nextLine().toLowerCase();

        while (input3.isEmpty()) {
            System.out.println("Please enter yes or no. ");
            input3 = scanner.nextLine().toLowerCase();
        }
        
        while (!((input3.equals("yes") || (input3.equals("no"))))) {
            System.out.println("Please enter yes or no. ");
            input3 = scanner.nextLine().toLowerCase();
        }
                
        if (input3.equals("no")) {
            exists = false; 
        }
    }

Product createNewProduct() {
        Product product = new Product(this);
        clearInfo();
        return product;
    }
}
