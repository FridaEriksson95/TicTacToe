import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("Would you like to play again?");
        System.out.println("1. Yes please! Start a new game!");
        System.out.println("2. No, we're fine. Please exit.");

        return getUserChoice();
    }

    private int getUserChoice() {
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter your choice (1-2): ");
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 2) {
                    valid = true;
                } else {
                    System.out.println("Invalid choice. Please choose a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }

    public void handleMenuOption(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Starting a new game...");
                break;
            case 2:
                System.out.println("Exiting the game. Thanks for playing!");
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
                break;
        }
    }
}