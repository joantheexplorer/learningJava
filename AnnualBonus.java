import java.util.Scanner;

public class AnnualBonus {
    public static void main() {
        Scanner tryAgain = new Scanner (System.in);
        Scanner userInput = new Scanner (System.in);

        do {
            System.out.println("CALCULATOR for Annual Empolyee Bonus");
            System.out.println("This is based on their years of service and annual performance rating");

            String employeeName = checkInputString();
            float yearService = checkinputInt();

        } while (userRepeat.equalsIgnoreCase("Yes") || userRepeat.equalsIgnoreCase("Y"));
        tryAgain.close();
    }

    static String checkInputString () {
        String inputName;
        while (true) {
            System.out.print("Employee's name: ");

            if (userInput.hasNextString()) {
                employeeName = userInput.nextString();
                break;
            }
            else {
                System.out.println("Please enter a valid string input. Try again");
                userInput.next();
            }
        }
        
        return inputName;
    }

}