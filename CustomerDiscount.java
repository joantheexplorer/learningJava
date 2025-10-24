import java.util.Scanner;

public class CustomerDiscount {
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args)
    {
        String tryAgain; // Variable for user's choice when repeating the program

        // Loops the main program when the user wants to.
        do
        {
            // displays the title and description of the program
            System.out.println();
            System.out.println("CALCULATOR for Discounts based on the type of customer");
            System.out.println();

            // gets the validated user input.
            String custmrName = checkInputName();
            float billAmount = checkInputBill();
            String custmrType = checkInputCustmr();

            // computes for final bill and the discount
            float finalBill = calculateBill(billAmount, custmrType);
            int percentDiscnt = getDscnt(custmrType);

            // display computed results
            System.out.println();
            System.out.println("===== Receipt =====");
            System.out.println("Customer's Name: " + custmrName);
            System.out.println("Customer Type: " + custmrType);
            System.out.printf("Original Bill: %.2f\n",billAmount);
            System.out.println("Discount Rate: " + percentDiscnt + "%");
            System.out.printf("Final Bill After Discount: %.2f\n", finalBill);
            System.out.println("===================");

            // asks the user if they want to repeat the process
            tryAgain = checkInputTry();
            System.out.println();
        }
        while (tryAgain.equalsIgnoreCase("Yes") || tryAgain.equalsIgnoreCase("Y") ||
               tryAgain.equals("1"));

        // exit message
        System.out.println("\nThank you for using this Java program.");
        userInput.close();
    }

    // validation for the name input
    static String checkInputName()
    {
        String inputName;

        while (true)
        {
            System.out.print("Customer's name: ");
            inputName = userInput.nextLine().trim(); // remove any extra space

            if (!inputName.isEmpty()) // name must not be empty
            {
                return inputName;
            }
            else
            {
                System.out.println("Please enter a valid string input. Try again");
            }
        }
    }

    // validation for Total bill
    static float checkInputBill()
    {
        float inputBill;

        while (true)
        {
            System.out.print("Enter the Total Bill Amount (e.g., 100.50): ");

            if (userInput.hasNextFloat()) // check if input is a float value
            {
                inputBill = userInput.nextFloat();

                if (inputBill > 0) // bill must be positive
                {
                    userInput.nextLine(); // clear the buffer
                    return inputBill;
                }
                else
                {
                    System.out.println("Please enter a valid bill value. Try again.");
                }
            }
            else
            {
                System.out.println("Please enter a valid float value. Try again.");
                userInput.next(); // clear invalid input
            }
        }
    }

    // validation for customer type
    static String checkInputCustmr()
    {
        String inputType;

        while (true)
        {
            System.out.print("Enter Customer Type (Regular, Premium, VIP): ");

            if (userInput.hasNextLine())
            {
                inputType = userInput.nextLine().trim(); // remove any extra space
                return inputType;
            }
            else
            {
                System.out.println("Please enter one of the following: regular, premium, vip, or other.");
            }
        }
    }

    // validation for try again inputs
    static String checkInputTry()
    {
        String inputRepeat;

        while (true)
        {
            System.out.print("Do you want to try again? (Yes or No): ");

            if (userInput.hasNextLine())
            {
                inputRepeat = userInput.nextLine().trim(); // removes extra spaces

                // accepts Yes, 1, Y for Yes and No, 0, N for No
                if (inputRepeat.equalsIgnoreCase("Yes") || inputRepeat.equalsIgnoreCase("No") ||
                    inputRepeat.equalsIgnoreCase("Y") || inputRepeat.equalsIgnoreCase("N") ||
                    inputRepeat.equals("1") || inputRepeat.equals("0"))
                {
                    return inputRepeat;
                }
                else
                {
                    System.out.println(
                        "Please enter either Yes or No. You can also use Y or N. Try again.");
                }
            }
            else
            {
                System.out.println("Please enter a valid string input. Try again.");
                userInput.next(); // clear invalid input
            }
        }
    }

    // Method for calculating the discounts
    static float calculateBill(float billAmount, String custmrType)
    {
        float dscntInBill;

        // Customers who are a regular
        if (custmrType.equalsIgnoreCase("regular"))
        {
            dscntInBill = billAmount * (0.05f);
            return (billAmount - dscntInBill);
        }

        // Customers who are premium
        else if (custmrType.equalsIgnoreCase("premium"))
        {
            dscntInBill = billAmount * (0.10f);
            return (billAmount - dscntInBill);
        }
        
        // Customers who are vip
        else if (custmrType.equalsIgnoreCase("vip"))
        {
            dscntInBill = billAmount * (0.15f);
            return (billAmount - dscntInBill);
        }
        
        // Other customer types
        else {
            return billAmount;
        }
    }

    // Compute to display the percent equivalent for the years of service
    static int getDscnt(String custmrType)
    {
        // Customers who are a regular
        if (custmrType.equalsIgnoreCase("regular"))
        {
            return 5;
        }

        // Customers who are premium
        else if (custmrType.equalsIgnoreCase("premium"))
        {
            return 10;
        }
        
        // Customers who are vip
        else if (custmrType.equalsIgnoreCase("vip"))
        {
            return 15;
        }
        
        // Other customer types
        else {
            return 0;
        }
    }
}