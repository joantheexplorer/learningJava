import java.util.Scanner;

public class NumberGame {
    static Scanner userInput = new Scanner(System.in); //global scanner

    public static void main(String[] args) throws InterruptedException
    {
        String tryAgain;

        do
        {
            System.out.println("Welcome to the Number Guessing Game!");

            //ask for player's name
            System.out.println("I'm JoAI :) What's your name?");
            String playerName = checkInputName();
            System.out.println("\nHello, " + playerName + "! Let's play.");

            //generating a random number from 1-100
            int randomNum = (int)(Math.random() * 100) + 1;

            //simple animation while generating a number
            dotAnimation();
            System.out.print("Number generated successfully! Press enter to play.");
            // clear buffer before each guess to avoid leftover newline issues (just in case the user enters something.)
            userInput.nextLine();

            //main game logic
            mainGame(playerName, randomNum);

            // asks the user if they want to play again
            tryAgain = checkInputTry();
            System.out.println();


        }while (tryAgain.equalsIgnoreCase("Yes") || tryAgain.equalsIgnoreCase("Y") ||
               tryAgain.equals("1"));

        // exit message
        System.out.println("Thank you for playing with JoAI.");
        userInput.close();
    }

    //method for checking the name input (not empty)
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

    //animated loading effect
    static void dotAnimation() throws InterruptedException
    {
        String messageLoad = "JoAI is generating a number (Please don't type anything).";

        for(int i = 0; i < 3; i++) {
            System.out.print("\r" + messageLoad + ".");
            Thread.sleep(500);
            System.out.print("\r" + messageLoad + "..");
            Thread.sleep(500);
            System.out.print("\r" + messageLoad + "...");
            Thread.sleep(500);
        }
        System.out.println("\r" + messageLoad + " Complete!");
    }

    //validated integer input for guessing
    static int checkInputNumber()
    {
        int inputGuess;

        while (true)
        {
            System.out.print("\nYour Guess (Type -1 if you want to end your guessing): ");

            if (userInput.hasNextInt()) // check if input is integer
            {
                inputGuess = userInput.nextInt();

                //accepts number within -1 to 100 range
                if (inputGuess > -2 && inputGuess < 101)
                {
                    userInput.nextLine(); // clear buffer
                    return inputGuess;
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

    //method for checking the inputed guess
    //0 - correct guess, 1 - too high, 2 - too low
    static int checkNumberGuess(int randomNum, int guessedNum) {
        if (randomNum == guessedNum) {
            return 0;
        }
        else if (randomNum < guessedNum) {
            return 1;
        }
        else {
            return 2;
        }
    }

    //method for asking if they want another round
    static String checkInputTry()
    {
        String inputRepeat;

        while (true)
        {
            System.out.print("\nDo you want to try another round? (Yes or No): ");

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

    //method for the main game
    static void mainGame(String playerName, int randomNum)
    {
        int guessedNum, countGuess = 1, resultGuess;

        do {
            guessedNum = checkInputNumber();

            if (guessedNum == -1) {
                System.out.println("The number is " + randomNum + "! Try again next time, " + playerName + " :)");
                return;
            }

            //compare guessed number and random number generated
            resultGuess = checkNumberGuess(randomNum, guessedNum);

            //display hints based on comparison
            if (resultGuess == 0) {
                break; //correct guess, exits the loop
            }
            else if (resultGuess == 1) {
                System.out.println("Too high! Try again.");
                countGuess++;
            }
            else if (resultGuess == 2) {
                System.out.println("Too low! Try again.");
                countGuess++;
            }
        } while(resultGuess != 0 );

        //victory message
        System.out.println("Correct! You guessed the number " + randomNum + " in " + countGuess + " attempts!");
        System.out.println("JoAI is proud of you, " + playerName + "!");
    }
}