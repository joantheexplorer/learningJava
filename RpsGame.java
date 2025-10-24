import java.util.Scanner;

public class RpsGame {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException
    {
        String tryAgain; // variable for choice of try again

        // game session with replaying the game
        do
        {
            // welcome message
            System.out.println("Welcome to the Two-Player Rock-Paper-Scissors Duel!");
            System.out.println("(Enter r=Rock, p=Paper, s=Scissors, q=Quit)");
            System.out.println("---------------------------------------------");

            // ask for players' name (should not be the same)
            String player1Name, player2Name;
            while (true)
            {
                System.out.println("Player 1: ");
                player1Name = checkInputName();
                System.out.println("Player 2: ");
                player2Name = checkInputName();
                if (!((player1Name.toLowerCase()).equals((player2Name).toLowerCase())))
                {
                    break;
                }
                else
                {
                    System.out.println("Both names cannot be the same. Try again.\n");
                }
            }

            System.out.println("\nHello, " + player1Name + " and " + player2Name +
                               "! Let's play.\n");

            // main gameplay loop
            mainGame(player1Name, player2Name);

            // asks the user if they want to play again
            tryAgain = checkInputTry();
            System.out.println();
        }
        while (tryAgain.equalsIgnoreCase("Yes") || tryAgain.equalsIgnoreCase("Y") ||
               tryAgain.equals("1"));

        // exit message
        System.out.println("Thank you for playing!");
        userInput.close();
    }

    // method for validating name input
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

    // method to validate and return the player's move
    static String checkInputMove(String playerMssg)
    {
        String inputMove;

        while (true)
        {
            System.out.print(playerMssg + ", enter your move: ");
            inputMove =
                userInput.nextLine()
                    .trim()
                    .toLowerCase(); // remove any extra space and lowercase for easy checking

            // accepts only valid moves and 'q' for quit
            if (inputMove.equalsIgnoreCase("r") || inputMove.equalsIgnoreCase("p") ||
                inputMove.equalsIgnoreCase("s") || inputMove.equalsIgnoreCase("q"))
            {
                return inputMove;
            }
            else
            {
                System.out.println("Please enter one of the following: r for rock, p for paper, "
                                   + "and s for scissors.");
            }
        }
    }

    // method for comparing the player's move and return the message result
    static String compareP1P2(String p1, String p2, String player1Name, String player2Name)
    {
        // check for tie
        if (p1.equals(p2))
        {
            return "It's a TIE!";
        }
        // rock vs scissors
        else if (p1.equals("r") && p2.equals("s"))
        {
            return player1Name + " WINS! Rock crushes Scissors.";
        }
        else if (p1.equals("s") && p2.equals("r"))
        {
            return player2Name + " WINS! Rock crushes Scissors.";
        }
        // scissors vs paper
        else if (p1.equals("s") && p2.equals("p"))
        {
            return player1Name + " WINS! Scissors cuts Paper.";
        }
        else if (p1.equals("p") && p2.equals("s"))
        {
            return player2Name + " WINS! Scissors cuts Paper.";
        }
        // paper vs rock
        else if (p1.equals("p") && p2.equals("r"))
        {
            return player1Name + " WINS! Paper covers Rock.";
        }
        else
        {
            return player2Name + " WINS! Paper covers Rock.";
        }
    }

    // method for main game with score tally
    static void mainGame(String player1Name, String player2Name)
    {
        // variables for scorekeeping
        int p1Score = 0;
        int p2Score = 0;
        int tieScore = 0;

        // infinite loop until someone enters 'q'
        while (true)
        {
            // end match if 'q' is typed
            String p1 = checkInputMove(player1Name);
            if (p1.equals("q"))
            {
                System.out.println("\n" + player1Name + " quit the game.");
                break;
            }
            String p2 = checkInputMove(player2Name);
            if (p2.equals("q"))
            {
                System.out.println("\n" + player2Name + " quit the game.");
                break;
            }

            // display the current result for that round
            String resultGame = compareP1P2(p1, p2, player1Name, player2Name);
            System.out.println("Result: " + resultGame);

            // tallying the scores
            if (resultGame.contains(player1Name))
            {
                p1Score++;
            }
            else if (resultGame.contains(player2Name))
            {
                p2Score++;
            }
            else
            {
                tieScore++;
            }

            // result after each round
            System.out.println("Score: " + player1Name + ": " + p1Score + " | " + player2Name +
                               ": " + p2Score + " | Ties: " + tieScore + "\n");
        }

        // display final results of the game after someone quits
        System.out.println("\n--- Match Ended ---");
        System.out.println("Final Score: " + player1Name + ": " + p1Score + " wins | " +
                           player2Name + ": " + p2Score + " wins | Ties: " + tieScore + " ties.");
        if (p1Score > p2Score)
        {
            System.out.println(player1Name + " is the overall winner!");
        }
        else if (p1Score < p2Score)
        {
            System.out.println(player2Name + " is the overall winner!");
        }
        else
        {
            System.out.println("No winners today.");
        }
        System.out.println("---------------------------------------------");
        System.out.println("Thanks for playing!");
    }

    // method for asking the users if they want another game.
    static String checkInputTry()
    {
        String inputRepeat;

        while (true)
        {
            System.out.print("\nDo you want to play another game? (Yes or No): ");

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