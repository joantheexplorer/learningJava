import java.util.Scanner;

public class NumberGame {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        String tryAgain;

        do 
        {
            System.out.println("Welcome to the Number Guessing Game!");
            
            System.out.println("I'm JoAI :) What's your name?");
            String playerName = checkInputName();
            System.out.println("Hello, " + playerName "! Let's play.");
            dotAnimation();
            System.out.println("\n Number generated successfully!");

            int retry = 0;
            int guessedNumber;
            
            do {
                guessedNumber = validNumber();

            } while(retry = 1);
        }while (tryAgain.equalsIgnoreCase("Yes") || tryAgain.equalsIgnoreCase("Y") ||
               tryAgain.equals("1"));

        // exit message
        System.out.println("Thank you for using this Java program.");
        userInput.close();
    }
    
    static String checkInputName()
    {
        String inputName;

        while (true)
        {
            System.out.print("Player's name: ");
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

    static void dotAnimation() throws InterruptedException
    {
        String messageLoad = "Generating a number";

        for(int i = 0; i < 3; i++) {
            System.out.print("\r" + messageLoad + ".");
            Thread.sleep(500);
            System.out.print("\r" + messageLoad + "..");
            Thread.sleep(500);
            System.out.print("\r" + messaheLoad + "...");
            Thread.sleep(500);
        }
        System.out.println("\r" + messageLoad + "Complete!");
    }

    static int checkInputYear()
    {
        int inputYear;

        while (true)
        {
            System.out.print("Years of Service: ");

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
}
