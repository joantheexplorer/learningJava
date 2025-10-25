import java.util.Scanner;

public class AirconService {
    public static void main(String[] args)
    {
        final float vatRate = 12; //Fixed VAT rate :c
        //Variables for labor hours worked, hourly labor rate, fixed cost parts
        float hoursWork, laborRate, costParts;

        //Scanner object to handle user input
        Scanner inputService = new Scanner(System.in);

        //Display welcome message, billing structure, and vat rate
        System.out.println("*** HVAC Service Quote Generator (PhP) ***");
        System.out.println(
            "Billing Structure: (Labor Hours * Hourly Rate) + VAT on Labor + Fixed Parts Cost");
        System.out.printf("Fixed VAT Rate: %.1f%% (%.2f)\n", vatRate, (vatRate / 100));

        //input validation for labor hours
        while (true)
        {
            System.out.print("Enter total labor hours worked: ");

            //checks if input is a float
            if (inputService.hasNextFloat())
            {
                hoursWork = inputService.nextFloat();

                //hours worked must be positive and not zero
                if (hoursWork > 0)
                {
                    break; //exits while loop if valid
                }
                else
                {
                    System.out.println("Please enter valid hours worked. Try again.");
                }
            }
            else
            {
                System.out.println("Please enter valid float input. Try Again");
                inputService.next(); //Clears invalid input from the scanner.
            }
        }

        //input validation for labor rate
        while (true)
        {
            System.out.print("Enter the hourly labor rate (PhP): ");

            //checks if input is a float
            if (inputService.hasNextFloat())
            {
                laborRate = inputService.nextFloat();

                //labor rate can't be zero or negative.
                if (laborRate > 0)
                {
                    break; //exits while loop if valid
                }
                else
                {
                    System.out.println("Please enter valid labor rate. Try again.");
                }
            }
            else
            {
                System.out.println("Please enter valid float input. Try again.");
                inputService.next(); //clears the invalid input
            }
        }

        //Input validation for cost of parts
        while (true)
        {
            System.out.print("Enter the fixed cost of parts (PhP): ");

            //checks if input is a float
            if (inputService.hasNextFloat())
            {
                costParts = inputService.nextFloat();

                //cost parts must be positive (can be zero if parts weren't needed during the service)
                if (costParts >= 0)
                {
                    break; //exits while loop if valid
                }
                else
                {
                    System.out.println("Please enter valid cost parts. Try again.");
                }
            }
            else
            {
                System.out.println("Please enter valid float input. Try again.");
                inputService.next(); //clears invalid input
            }
        }

        //Service calculations
        float laborSubTtl = hoursWork * laborRate; //labor subtotal
        float vatApplied = laborSubTtl * (vatRate / 100); //VAT applied
        float totalDue = (hoursWork * laborRate) + vatApplied + costParts; //grand total due

        //display the service quote
        System.out.println("\n--- Preliminary Service Quote ---");
        System.out.printf("Labor Subtotal (%.1f hours @ %.2f/hr): PhP %.2f\n", hoursWork, laborRate,
                          laborSubTtl);
        System.out.printf("Fixed Parts Cost: PhP %.2f\n", costParts);
        System.out.printf("VAT Applied (%.1f%% of Labor): PhP %.2f\n", vatRate, vatApplied);
        System.out.println("-----------------------------------");
        System.out.printf("Grand Total Due: PhP %.2f\n", totalDue);
        System.out.println("-----------------------------------");

        //close the scanner to avoid memory leak
        inputService.close();
    }
}