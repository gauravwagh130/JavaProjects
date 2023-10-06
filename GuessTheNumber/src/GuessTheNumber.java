import java.util.Random;
import java.util.*;
public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        int min = 1;
        int max = 100;
        int trails = 0;
        int random = rn.nextInt(100);
        boolean hasguessed = true;

        System.out.println("Welcome to the Game ");
        System.out.println("Try to guess the number between  1 and 100");

        while (true){
            System.out.print("Enter your Guess:");

            int guess= sc.nextInt();
            trails++;

            if (guess < min || guess > max) {
                System.out.print("Enter the number between" + min + "&" + max);
            }
            else if (guess <random) {
                System.out.println("Try entering a higher number");
            } else if (guess>random) {
                System.out.println("Try Entering a lower number");
            }
            else{
                System.out.println("Congratulations!!! you have guessed the right number.");
                System.out.print("Guessed the right number in " +trails+" attempts");
                break;
            }
        }
        sc.close();

    }
}
