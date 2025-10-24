import java.util.Scanner;

public class RpsGame {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException
    {
        String tryAgain;

        do
        {
            System.out.println("Welcome to the Two-Player Rock-Paper-Scissors Duel!");
            System.out.println("(Enter r=Rock, p=Paper, s=Scissors, q=Quit)");
            System.out.println("---------------------------------------------");

            //ask for player's name
            System.out.println("Player 1: ");
            String player1Name = checkInputName();
            System.out.println("Player 2: ");
            String player2Name = checkInputName();

            System.out.println("\nHello, " + player1Name + " and " + player2Name + "! Let's play.");

            //generating a random number from 1-100
            String player1Ans = checkInputName(player1Name);
            String player2Ans = checkInputName(player2Name);

            mainGame(String player1Ans, String player2Ans);
            
            // asks the user if they want to play again
            tryAgain = checkInputTry();
            System.out.println();


        }while (tryAgain.equalsIgnoreCase("Yes") || tryAgain.equalsIgnoreCase("Y") ||
               tryAgain.equals("1"));

        // exit message
        System.out.println("Thank you for playing with JoAI.");
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

    static String checkInputCustmr(String playerMssg)
    {
        String inputType;

        while (true)
        {
            System.out.print(playerMssg + ", enter your move: ");

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
}

