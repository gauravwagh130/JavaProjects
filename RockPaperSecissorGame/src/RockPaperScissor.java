import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("Enter your choice (0 for rock, 1 for paper, 2 for scissors): ");
            int playerChoice = scanner.nextInt();

            if (!isValidChoice(playerChoice)) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            int computerChoice = random.nextInt(3);

            System.out.println("Computer chose: " + getChoiceName(computerChoice));

            String result = getGameResult(playerChoice, computerChoice);
            System.out.println(result);

            System.out.print("Play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static boolean isValidChoice(int choice) {
        return choice >= 0 && choice <= 2;
    }

    public static String getChoiceName(int choice) {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[choice];
    }

    public static String getGameResult(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return "It's a tie!";
        } else if (
                (playerChoice == 0 && computerChoice == 2) ||
                        (playerChoice == 1 && computerChoice == 0) ||
                        (playerChoice == 2 && computerChoice == 1)
        ) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}

