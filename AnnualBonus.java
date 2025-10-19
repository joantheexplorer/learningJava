import java.util.Scanner;

public class AnnualBonus {
    public static void main (String[] args) {
        Scanner tryAgain = new Scanner (System.in);
        Scanner userInput = new Scanner (System.in);

        do {
            System.out.println("CALCULATOR for Annual Empolyee Bonus");
            System.out.println("This is based on their years of service and annual performance rating");

            String employeeName = checkInputString();
            float yearService = checkinputInt();

        } while (userRepeat.equalsIgnoreCase("Yes") || userRepeat.equalsIgnoreCase("Y"));

        System.out.println("Thank you for using this java program.");
        tryAgain.close();
    }

    static String checkInputString () {
        String inputName;

        while (true) {
            System.out.print("Employee's name: ");

            if (userInput.hasNextLine()) {
                inputName = userInput.nextLine();
                break;
            }
            else {
                System.out.println("Please enter a valid string input. Try again");
                userInput.next();
            }
        }
        
        return inputName;
    }
    static int checkinputInt () {
        int inputYear;

        while (true) {
            System.out.print("Years of Service: ");

                if (userInput.hasNextInt()) {
                    inputYear = userInput.nextInt();

                    if (inputYear > 0 || inputYear < 100) {
                        break;
                    }
                    else {
                        System.out.println("Please enter a valid year of service. Try again.");
                    }
                }
                else {
                    System.out.println("Please enter a valid int input. Try again.");
                    userInput.next();
                }
        }

        return inputYear;
    }
}