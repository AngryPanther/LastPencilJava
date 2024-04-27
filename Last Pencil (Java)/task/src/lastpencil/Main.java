package lastpencil;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int totalPencils = 0;
        int playerChoice;
        String currentPlayer;
        Bot bot = new Bot();


        System.out.println("How many pencils would you like to use:");
        totalPencils = getPencils(scanner, totalPencils);

        System.out.println("Who will be the first (John, Jack):");
        currentPlayer = getPlayerName(scanner);
        bot.name = "Jack";

        System.out.println(pencilGenerator(totalPencils));

        while (totalPencils > 0) {
            System.out.printf("%s's turn!%n", currentPlayer);
            if (currentPlayer.equals("Jack")) {
                playerChoice = getBotChoice(totalPencils);
                System.out.println(playerChoice);
            } else {
                playerChoice = getChoice(scanner,totalPencils);
            }

            for (int i = 0; i < totalPencils - playerChoice; i++) {
                pencilGenerator(totalPencils - playerChoice);
            }
                totalPencils -= playerChoice;

                if (totalPencils == 0 && !currentPlayer.equals(bot.name)) {
                    System.out.printf("%s won!",bot.name);
                    break;
                } else if (totalPencils == 0 && currentPlayer.equals(bot.name)) {
                    System.out.printf("%s won!","John");
                    break;
                }
                System.out.println(pencilGenerator(totalPencils));
                currentPlayer = "John".equals(currentPlayer) ? "Jack" : "John";
            }
        }

        // Get initial pencils
    private static int getPencils(Scanner scanner, int totalPencils) {
    while (totalPencils <= 0) {
        try {
            totalPencils = Integer.parseInt(scanner.nextLine());
            if (totalPencils < 1) {
                System.out.println("The number of pencils should be positive");
            }
        } catch (NumberFormatException e) {
            System.out.println("The number of pencils should be numeric");
        }
    }
    return totalPencils;
}

    //Check for valid names and get first player
    private static String getPlayerName(Scanner scanner) {
        String currentPlayer;
        while (true) {
            currentPlayer = scanner.nextLine();
            if ("John".equals(currentPlayer) || "Jack".equals(currentPlayer)) {
                break;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }
        return currentPlayer;
    }
    // Gets Player Choice
    private static int getChoice(Scanner scanner, int totalPencils){
        int playerChoice;
        while (true) {
        try {
            playerChoice = Integer.parseInt(scanner.nextLine());
            if (playerChoice > 3 || playerChoice < 1) {
                System.out.println("Possible values: '1', '2', '3'");
            } else if (playerChoice > totalPencils) {
                System.out.println("Too many pencils were taken.");
            } else {
                break;
            }
        }catch (NumberFormatException e) {
            System.out.println("Possible values: '1', '2', '3'");
        }
    } return playerChoice;

        }
    // Create initial and updates pencil string
    private static StringBuilder pencilGenerator(int totalPencils) {
        StringBuilder pencils = new StringBuilder();
        for (int i = 1; i <= totalPencils; i++) {
            pencils.append("|");
            if (i == totalPencils) {
                break;
            }
        }
        return pencils;
    }
    // Bot winning strategy logic
    private static int getBotChoice (int totalPencils) {
        int botChoice;
        if (totalPencils >= 4 && totalPencils % 4 == 0) {
            botChoice = 3;
        } else if (totalPencils >= 3 && (totalPencils-3) % 4 == 0) {
            botChoice = 2;
        } else if ((totalPencils >= 2 && (totalPencils-2) % 4 == 0) || totalPencils == 1) {
            botChoice = 1;
        }  else {
            botChoice = random.nextInt(3 - 1 + 1) + 1;
        }
        return botChoice;
    }
}
class Bot {
    String name;
}