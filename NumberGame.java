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
            int randomNum = = (int)(Math.random() * 101);
            dotAnimation();
            System.out.println("\n Number generated successfully!");

            int wrongGuess = 0;
            int guessedNum, countGuess;
            
            do {
                guessedNum = checkInputNumber();
                int wrongGuess = checkNumberGuess(randomNum, guessedNum);

                if (wrongGuess = 0) {
                    break;
                }
                else if (wrongGuess = 1) {
                    System.out.println("Too high! Try again.");
                    countGuess++;
                } 
                else if (wrongGuess = 2) {
                    System.out.println("Too low! Try again.")
                    countGuess++;
                }
            } while(wrongGuess = 1 || wrongGuess = 2);

            System.out.println("Correct! You guessed the number " + randomNum " in " + countGuess + " attempts!");
            
            // asks the user if they want to repeat the process
            tryAgain = checkInputTry();
            System.out.println();


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

    static int checkInputNumber()
    {
        int inputGuess;

        while (true)
        {
            System.out.print("Your Guess: ");

            if (userInput.hasNextInt()) // check if input is integer
            {
                inputYear = userInput.nextInt();

                if (inputYear > -1 && inputYear < 101)
                {
                    userInput.nextLine(); // clear buffer
                    return inputYear;
                }
                else
                {
                    System.out.println("Please enter a valid int number within 1-100. Try again.");
                }
            }
            else
            {
                System.out.println("Please enter a valid int input. Try again.");
                userInput.next(); // clear invalid input
            }
        }
    }

    static int checkNumberGuess(int randomNum, int guessedNum) {
        if (randomNum == guessedNum) {
            return 0;
        }
        else if (randomNum < guessedNum) {
            return 1;
        }
        else if (randomNum > guessedNum) {
            return 2;
        }
    }

    static String checkInputTry()
    {
        String inputRepeat;

        while (true)
        {
            System.out.print("Do you want to try another round? (Yes or No): ");

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
}
