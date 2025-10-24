import java.util.Scanner;

public class RpsGame {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Welcome to the Two-Player Rock-Paper-Scissors Duel!");
        System.out.println("(Enter r=Rock, p=Paper, s=Scissors, q=Quit)");
        System.out.println("---------------------------------------------");
        String tryAgain;
        
        do
        {
            //variables for scorekeeping
            int p1Score = 0;
            int p2Score = 0;
            int tieScore = 0;

            //ask for player's name
            System.out.println("Player 1: ");
            String player1Name = checkInputName();
            System.out.println("Player 2: ");
            String player2Name = checkInputName();

            System.out.println("\nHello, " + player1Name + " and " + player2Name + "! Let's play.");

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
            inpuMove = userInput.nextLine().trim().toLowerCase(); // remove any extra space
            
            if (inputMove.equalsIgnoreCase("r") || inputMove.equalsIgnoreCase("p") || inputMove.equalsIgnoreCase("s") || inputMove.equalsIgnoreCase("q")) 
            {
                    return inputMove;
            }
            else 
            {
                    System.out.println("Please enter one of the following: r for rock, p for paper, and s for scissors.");
            }
                
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
        else if (p1.equalsIgnoreCase("r") && p2.equalsIgnoreCase("s"))
        {
            return "Player 1 WINS! Rock crushes Scissors.";
        }
        else if (p1.equalsIgnoreCase("s") && p2.equalsIgnoreCase("r"))
        {
            return "Player 2 WINS! Rock crushes Scissors.";
        }
        //scissors vs paper
        else if (p1.equalsIgnoreCase("s") && p2.equalsIgnoreCase("p"))
        {
            return "Player 1 WINS! Scissors cuts Paper.";
        }
        else if (p1.equalsIgnoreCase("p") && p2.equalsIgnoreCase("s"))
        {
            return "Player 2 WINS! Scissors cuts Paper.";
        }
        //paper vs rock
        else if (p1.equalsIgnoreCase("p") && p2.equalsIgnoreCase("r"))
        {
            return "Player 1 WINS! Paper covers Rock.";
        }
        else 
        {
            return "Player 2 WINS! Paper covers Rock.";
        }
    }

    static void mainGame(String player1Name, String playerName)
    {
        while(true)
            {
                String p1 = checkInputMove(player1Name);
                if (p1.equalsIgnoreCase("q"))
                {
                    break; 
                }
                String p2 = checkInputMove(player2Name);
                if (p2.equalsIgnoreCase("q"))
                {
                    break;
                }

                String resultGame = compareP1P2(p1, p2);

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

