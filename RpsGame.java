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

            System.out.println("\nHello, " + player1Name + " and " + player2Name + "! Let's play.\n");

            mainGame(player1Name, player2Name);

            // asks the user if they want to play again
            tryAgain = checkInputTry();
            System.out.println();

        }while (tryAgain.equalsIgnoreCase("Yes") || tryAgain.equalsIgnoreCase("Y") ||
               tryAgain.equals("1"));

        // exit message
        System.out.println("Thank you for playing!");
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

    static String checkInputMove(String playerMssg)
    {
        String inputMove;

        while (true)
        {
            System.out.print(playerMssg + ", enter your move: ");
            inputMove = userInput.nextLine().trim().toLowerCase(); // remove any extra space

            if (inputMove.equalsIgnoreCase("r") || inputMove.equalsIgnoreCase("p") || inputMove.equalsIgnoreCase("s") || inputMove.equalsIgnoreCase("q"))
            {
                    return inputMove;
            }
            else
            {
                    System.out.println("Please enter one of the following: r for rock, p for paper, and s for scissors.");
            }
        }
    }

    static String compareP1P2(String p1, String p2)
    {

        if (p1.equals(p2))
        {
            return "It's a TIE!";
        }
        //rock vs scissors
        else if (p1.equals("r") && p2.equals("s"))
        {
            return "Player 1 WINS! Rock crushes Scissors.";
        }
        else if (p1.equals("s") && p2.equals("r"))
        {
            return "Player 2 WINS! Rock crushes Scissors.";
        }
        //scissors vs paper
        else if (p1.equals("s") && p2.equals("p"))
        {
            return "Player 1 WINS! Scissors cuts Paper.";
        }
        else if (p1.equals("p") && p2.equals("s"))
        {
            return "Player 2 WINS! Scissors cuts Paper.";
        }
        //paper vs rock
        else if (p1.equals("p") && p2.equals("r"))
        {
            return "Player 1 WINS! Paper covers Rock.";
        }
        else
        {
            return "Player 2 WINS! Paper covers Rock.";
        }
    }

    static void mainGame(String player1Name, String player2Name)
    {
        //variables for scorekeeping
        int p1Score = 0;
        int p2Score = 0;
        int tieScore = 0;

        while(true)
        {
            String p1 = checkInputMove(player1Name);
            if (p1.equals("q"))
            {
                System.out.println("\nPlayer 1 quit the game.");
                break;
            }
            String p2 = checkInputMove(player2Name);
            if (p2.equals("q"))
            {
                System.out.println("\nPlayer 2 quit the game.");
                break;
            }

            String resultGame = compareP1P2(p1, p2);

            if (resultGame.contains("Player 1 WINS!")) {
                p1Score++;
            }
            else if(resultGame.contains("Player 2 WINS!"))
            {
                p2Score++;
            }
            else
            {
                tieScore++;
            }

            System.out.println("Score: " + player1Name + ": " + p1Score + " | " + player2Name + ": " + p2Score + " | Ties: " + tieScore +"\n");
        }

        System.out.println("\n--- Match Ended ---");
        System.out.println("Final Score: Player 1: " + p1Score + " wins | Player 2: " + p2Score + " wins | Ties: " + tieScore + " ties.");
        if (p1Score > p2Score)
        {
            System.out.println("Player 1 is the overall winner!");
        }
        else if (p1Score < p2Score)
        {
            System.out.println("Player 2 is the overall winner!");
        }
        else
        {
            System.out.println("No winners today.");
        }
        System.out.println("Thanks for playing!");
    }
    static String checkInputTry()
    {
        String inputRepeat;

        while (true)
        {
            System.out.print("\nDo you want to play another around? (Yes or No): ");

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