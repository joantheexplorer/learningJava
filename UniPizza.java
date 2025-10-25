import java.util.Scanner;

public class UniPizza {
    public static void main(String[] args) {
        final float pricePizza = 450; //Constant price per pizza (current)

        //variable for discount rate and quantity of pizza ordered
        float dscntPizza;
        int qtyPizza;

        //Scanner object to handle user input
        Scanner inputOrder = new Scanner(System.in);

        //Display welcome message and current pizza price
        System.out.println("*** University Pizzeria Order System ***");
        System.out.printf("Current price per pizza: %.0f\n", pricePizza);

        //Input validation for pizza quantity
        while (true) {
            System.out.print("Enter the number of pizzas you are ordering: ");

            //checks if input is an integer
            if (inputOrder.hasNextInt()) {
                qtyPizza = inputOrder.nextInt();

                //quantity must be positive and not zero
                if (qtyPizza > 0) {
                    break; //exits while the loop if valid
                }
                else {
                    System.out.println("Please enter a valid quantity. Try again.");
                }
            }
            else {
                //Handles invalid inputs (non-integers)
                System.out.println("Please enter an integer input. Try again.");
                inputOrder.next(); //Clears the invalid input from the scanner.
            }
        }

        while (true) { //input validation for discounts
            System.out.print("Enter the discount percentage (e.g., 15 for 15%): ");

            //checks if input is a float
            if (inputOrder.hasNextFloat()) {
                dscntPizza = inputOrder.nextFloat();

                //discount must be 0% to 100% only
                if (dscntPizza >= 0 && dscntPizza <= 100) {
                    break; //exits while the loop if valid
                }
                else
                {
                    System.out.println("Please enter a valid percentage (0-100). Try again.");
                }
            }
            else {
                //handles invalid inputs (non-float)
                System.out.println("Please enter a float input. Try again.");
                inputOrder.next(); //clears invalid input
            }
        }

        //Bill calculations
        float subTotal = pricePizza * qtyPizza; //pizza subtotal
        float applyDscnt = subTotal * (dscntPizza / 100); //discount amount
        float totalDue = subTotal - applyDscnt; //final total due

        //display the itemized bill
        System.out.println("\n--- Your Itemized Bill ---");
        System.out.printf("Pizza Subtotal: %.1f\n", subTotal);
        System.out.printf("Discount Applied (%.1f%%): %.1f\n", dscntPizza, applyDscnt);
        System.out.println("---------------------------");
        System.out.printf("Final Total Due: %.1f\n\n", totalDue);

        //message before the program ends
        System.out.println("Thank you for your order!");

        //Close the scanner to avoid memory leak
        inputOrder.close();
    }
}