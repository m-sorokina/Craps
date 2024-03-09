import java.util.Scanner;

public class Game {
    public static Scanner in = new Scanner(System.in);
    private int sum;

    public Game(int sum) {
        this.sum = sum;
        System.out.printf("You have %d%n", this.sum);
    }

    public void play() {

        String repeat = "y";
        while (repeat.equals("y")) {
            int bet = getBet("Make your bet: ");
            while (bet > sum) {
                bet = getBet("Too much, repeat your bet: ");
            }

            Set set = new Set();

            Result result = set.play();

            if (result == Result.WIN) {
                sum += bet;
                System.out.println("You win");
            } else {
                sum -= bet;
                System.out.println("You lost");
            }
            System.out.printf("You have %d%n", sum);
            if (sum > 0) {
                System.out.print("Do you want to continue (y/n)?: ");
                repeat = in.nextLine();
            } else {
                System.out.println("See you later. Get luck next time!");
                repeat = "n";
            }
        }

    }

    public static int getBet(String prompt) {
        int bet = 0;
        System.out.print(prompt);
        while (bet <= 0) {
            String temp = in.nextLine();
            try {
                bet = Integer.parseInt(temp);
                if (bet <= 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("You haven't made your bet, please repeat: ");
            }
        }
        return bet;
    }

}
