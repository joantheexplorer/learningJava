import java.util.Scanner;

public class AnnualBonus {
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args)
    {
        String tryAgain; // Variable for user's choice when repeating the program

        // Loops the main program when the user wants to.
        do
        {
            // displays the title and description of the program
            System.out.println("CALCULATOR for Employee Bonuses");
            System.out.println(
                "This is based on their years of service and performance rating");
            System.out.println();

            // gets the validated user input.
            checkInputName();
            int yearService = checkInputYear();
            String perfRating = checkInputRate();
            float annualSalary = checkInputSalary();

            // computes for bonus and total salary
            float employeeBonus = calculateBonus(annualSalary, yearService, perfRating);
            float percentBonus = convertPercent(yearService, perfRating)

            // display computed results
            System.out.println();
            System.out.println("===== Calculation =====");
            if (yearService < 5) {
                System.out.printf("The bonus is: ₱%,.2f (Fixed Bonus)%n", employeeBonus);
            } 
            else {
                System.out.printf("The bonus is: ₱%,.2f (%.0f%% of ₱%,.2f)%n", employeeBonus, percentBonus, annualSalary);
            }
            System.out.println();

            // asks the user if they want to repeat the process
            tryAgain = checkInputTry();
            System.out.println();
        }
        while (tryAgain.equalsIgnoreCase("Yes") || tryAgain.equalsIgnoreCase("Y") ||
               tryAgain.equals("1"));

        // exit message
        System.out.println("Thank you for using this Java program.");
        userInput.close();
    }

    // validation for the name input
    static String checkInputName()
    {
        String inputName;

        while (true)
        {
            System.out.print("Employee's name: ");
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

    // validation for year of service (1-99)
    static int checkInputYear()
    {
        int inputYear;

        while (true)
        {
            System.out.print("Enter years of service: ");

            if (userInput.hasNextInt()) // check if input is integer
            {
                inputYear = userInput.nextInt();

                if (inputYear > 0 && inputYear < 100)
                {
                    userInput.nextLine(); // clear buffer
                    return inputYear;
                }
                else
                {
                    System.out.println("Please enter a valid year of service. Try again.");
                }
            }
            else
            {
                System.out.println("Please enter a valid int input. Try again.");
                userInput.next(); // clear invalid input
            }
        }
    }

    // validation for performance rating (excellent/good/other)
    static String checkInputRate()
    {
        String inputRate;

        while (true)
        {
            System.out.print("Enter performance rating (excellent/good/other):  ");
            inputRate = userInput.nextLine().trim(); // remove any extra space

            if (!inputRate.isEmpty()) // rate must not be empty
            {
                if (inputRate.equalsIgnoreCase("excellent") || inputRate.equalsIgnoreCase("good") || inputRate.equalsIgnoreCase("other")) {
                    return inputRate;
                }

            }
            else
            {
                System.out.println("Please enter a valid string input. Try again");
            }
        }
    }

    // validation for salary
    static float checkInputSalary()
    {
        float inputSalary;

        while (true)
        {
            System.out.print("Enter salary: ₱");

            if (userInput.hasNextFloat()) // check if input is a float value
            {
                inputSalary = userInput.nextFloat();

                if (inputSalary > 0) // salary must be positive
                {
                    userInput.nextLine(); // clear the buffer
                    return inputSalary;
                }
                else
                {
                    System.out.println("Please enter a valid salary value. Try again.");
                }
            }
            else
            {
                System.out.println("Please enter a valid float value. Try again.");
                userInput.next(); // clear invalid input
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

    // Method for calculating the bonus based on year of service and performance rating
    static float calculateBonus(float annualSalary, int yearService, String perfRating)
    {
        final float fixedBonus = 5000;

        // Employees with 10 or more years of service
        if (yearService >= 10)
        {
            if (perfRating.equalsIgnoreCase("excellent")) {
                return annualSalary * (0.20f);
            }
            else if (perfRating.equalsIgnoreCase("good")) 
            {
                return annualSalary * (0.15f);
            }
            else {
                return annualSalary * (0.10f);
            }
        }

        // employees 5-9 years of service
        else if (yearService >= 5 && yearService <= 9)
        {
            if (perfRating.equalsIgnoreCase("excellent")) {
                return annualSalary * (0.15f);
            }
            else if (perfRating.equalsIgnoreCase("good")) 
            {
                return annualSalary * (0.10f);
            }
            else {
                return annualSalary * (0.05f);
            }
        }
        // employees with less than 5 years of experience
        else { 
            return fixedBonus;
        }

    }

    // Compute to display the percent equivalent for the years of service
    static float convertPercent(int yearService, String perfRating) {
        float percent;
        if (yearService >= 10) {
            if (perfRating.equalsIgnoreCase("excellent")) {
                percent = 20;
                return percent;
            }
            else if (perfRating.equalsIgnoreCase("good")) {
                percent = 15;
                return percent;
            }
            else {
                percent = 10;
            }
        } 
        else if (yearService >= 5) {
            if (perfRating.equalsIgnoreCase("excellent")) {
                percent = 15;
                return percent;
            }
            else if (perfRating.equalsIgnoreCase("good")) {
                percent = 10;
                return percent;
            }
            else {
                percent = 5;
                return percent;
            }
        }
    }
}