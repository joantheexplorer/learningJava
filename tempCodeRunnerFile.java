import java.util.Scanner;

public class AnnualBonus {
    public static void main (String[] args) {
        Scanner userRepeat = new Scanner (System.in);
        Scanner userInput = new Scanner (System.in);

        do {
            System.out.println("CALCULATOR for Annual Empolyee Bonus");
            System.out.println("This is based on their years of service and annual performance rating");

            String employeeName = checkInputName();
            float annualSalary = checkInputSalary();
            int yearService = checkInputYear();
            int performanceRate = checkInputRate();

            String tryAgain = checkInputTry();

        } while (tryAgain.equalsIgnoreCase("Yes") || tryAgain.equalsIgnoreCase("Y"));

        System.out.println("Thank you for using this java program.");
        tryAgain.close();
    }

    static String checkInputName () {
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
    
    static float checkInputSalary () {
        float inputSalary;

        while (true) {
            System.out.print("Annual Salary: ");

            if (userInput.hasNextFloat()) {
                inputSalary = userInput.nextFloat();
                
                if (inputSalary > 0) {
                    break;
                }
                else {
                    System.out.println("Please enter a valid salary value. Try again.");

                }
            }
            else {
                System.out.println("Please enter a valid float value. Try again.");
                userInput.next();
            }
        }

        return inputSalary;
    }
    
    static int checkInputYear () {
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

    static int checkInputRate () {
        int inputRate;

        while (true) {
            System.out.print("Performance Rating: ");

            if (userInput.hasNextInt()) {
                inputRate = userInput.nextInt();
                if (inputRate >= 0 && userRate => 100) {
                    break;
                }
                else {
                    System.out.println("Please enter a valid performance rating. Try again.");
                }
            }
            else {
                System.out.println("Please enter a valid int input. Try again.");
                userInput.next();
            }
        }
        return inputRate;
    }

    static String checkInputTry () {
        String inputRepeat;

        while (true) {
            System.out.print("Do you want to try again? (Yes or No): ");

            if (userRepeat.hasNextLine()) {
                inputRepeat = userRepeat.nextLine();

                if (inputRepeat.equalsIgnoreCase("Yes") || inputRepeat.equalsIgnoreCase("No") || inputRepeat.equalsIgnoreCase("Y") || inputRepeat.equalsIgnoreCase("N")) {
                    break;
                }
                else {
                    System.out.println("Please enter either Yes or No. You can also use Y or N. Try again.");
                }
            }
            else {
                System.out.println("Please enter a valid string input. Try again.");
                userRepeat.next();
            }
        }

        return inputRepeat;
    }
}