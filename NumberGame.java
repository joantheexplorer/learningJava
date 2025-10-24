import java.util.Scanner;

public class NumberGame {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        String tryAgain;

        do 
        {
            System.out.println("Welcome to the Number Guessing Game!");
            dotAnimation();
        }
    }

    static void dotAnimation()
    {
        String messageLoad = "Generating a number";
        String dotsDots = { ".", "..", "..."};
        
        for(int i = 0; i < 10; i++) {
            for (String dot : dots) {
                Systerm.out.print("\r" + messageLoad + dotsDots + "   ");
                Thread.sleep(300);
            }
        }
        System.out.println("\r" + messageLoad + "Complete!");
    }
}
