import java.util.Scanner;

public class AnnualBonus {
    static Scanner userInput = new Scanner (System.in);
    public static void main (String[] args) {
        String tryAgain;

        do {
            System.out.println("CALCULATOR for Annual Empolyee Bonus");
            System.out.println("This is based on their years of service and annual performance rating");
            System.out.println();

            String employeeName = checkInputName();
            float annualSalary = checkInputSalary();
            int yearService = checkInputYear();
            int performanceRate = checkInputRate();

            float employeeBonus = calculateBonus(annualSalary, yearService, performanceRate);
            float totalSalary = annualSalary + employeeBonus;
            System.out.println("===== Calculation =====")
            System.out.println("Bonus: " + employeeBonus);
            System.out.println("Total Salary: " + totalSalary);

            tryAgain = checkInputTry();
            System.out.println();

        } while (tryAgain.equalsIgnoreCase("Yes") || tryAgain.equalsIgnoreCase("Y"));

        System.out.println("Thank you for using this Java program.");
        userInput.close();
    }

    static String checkInputName () {
        String inputName;

        while (true) {
            System.out.print("Employee's name: ");
            inputName = userInput.nextLine().trim();

            if (!inputName.isEmpty()) {
                return inputName;
            }
            else {
                System.out.println("Please enter a valid string input. Try again");
            }
        }
    }
    
    static float checkInputSalary () {
        float inputSalary;

        while (true) {
            System.out.print("Annual Salary: ");

            if (userInput.hasNextFloat()) {
                inputSalary = userInput.nextFloat();
                
                if (inputSalary > 0) {
                    userInput.nextLine();
                    return inputSalary;
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
    }
    
    static int checkInputYear () {
        int inputYear;

        while (true) {
            System.out.print("Years of Service: ");

                if (userInput.hasNextInt()) {
                    inputYear = userInput.nextInt();

                    if (inputYear > 0 && inputYear < 100) {
                        userInput.nextLine();
                        return inputYear;
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
    }

    static int checkInputRate () {
        int inputRate;

        while (true) {
            System.out.print("Performance Rating (0-100): ");

            if (userInput.hasNextInt()) {
                inputRate = userInput.nextInt();
                if (inputRate >= 0 && inputRate >= 100) {
                    userInput.nextLine();
                    return inputRate;
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
    }

    static String checkInputTry () {
        String inputRepeat;

        while (true) {
            System.out.print("Do you want to try again? (Yes or No): ");

            if (userInput.hasNextLine()) {
                inputRepeat = userInput.nextLine().trim();

                if (inputRepeat.equalsIgnoreCase("Yes") || inputRepeat.equalsIgnoreCase("No") || inputRepeat.equalsIgnoreCase("Y") || inputRepeat.equalsIgnoreCase("N")) {
                    return inputRepeat;
                }
                else {
                    System.out.println("Please enter either Yes or No. You can also use Y or N. Try again.");
                }
            }
            else {
                System.out.println("Please enter a valid string input. Try again.");
                userInput.next();
            }
        }
    }
    static float calculateBonus(float annualSalary, int yearService, int performanceRate) {
        float salaryBonus
        if (yearService >= 5) {
            if (performaceRate >= 90) {
                salaryBonus = annualSalary * 0.20;
                return salaryBonus;
            }
            else if (performanceRate >= 80 && performaceRate <= 89) {
                salaryBonus = annualSalary * 0.15;
                return salaryBonus;
            }
            else if (performaceRate < 80) {
                salaryBonus = annualSalary * 0.10;
                return salaryBonus;
            }
        }
        else if (yearService < 5) {
            if (performaceRate >= 90) {
                salaryBonus = annualSalary * 0.10;
                return salaryBonus;
            }
            else if (performanceRate >= 80 && performaceRate <= 89) {
                salaryBonus = annualSalary * 0.5;
                return salaryBonus;
            }
            else if (performaceRate < 80) {
                return salaryBonus;
            }

        }
    }
}