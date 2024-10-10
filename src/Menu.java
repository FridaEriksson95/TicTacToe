import java.util.Scanner;

public class Menu {
    //instancevariable to read players input
    private Scanner scanner;

    //constructor with scanner-object to reuse in rest of code
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * the selections for the menu when the game ends
     * @return choice
     */
    public int showMenu() {
        System.out.println("Would you like to play again? ❌⭕️");
        System.out.println("1. Yes please! Start a new game️❗️");
        System.out.println("2. No, we're fine. Please exit🚫");

        return getUserChoice();
    }
    /**
     * A switch-case to treat the players option in menu
     * makes it easier to add more alternatives to the menu
     * @param choice
     */
    public void handleMenuOption(int choice) {
        switch (choice) {
            // if press 1, this prints out
            case 1:
                System.out.println("Starting a new game...");
                break;
            // if press 2, this prints out
                case 2:
                System.out.println("Exiting the game. Thanks for playing!");
                break;
            // if incorrect choice, this prints out
                default:
                System.out.println("Invalid choice. Please choose a valid option.");
                break;
        }
    }

    /**
     * a try-catch to validate users choice
     * @return
     */
    private int getUserChoice() {
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter your choice (1-2): ");
            String input = scanner.nextLine();
            try {
                //converts string to int
                choice = Integer.parseInt(input);
                //checks if input is bigger than/or equals to 1 and if input is smaller than/or equals to 2
                if (choice >= 1 && choice <= 2) {
                    valid = true;
                //if input is not 1 or 2, this prints out
                } else {
                    System.out.println("Invalid choice. Please choose a valid option.");
                }
                //if input is a letter or character, this prints out
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        //if input is 1 or 2, the choosen choice will be returned
        return choice;
    }

    /**
     * the optionhandler for menu if player wants to play again
     * @return
     */
    public boolean ifPlayAgain() {
        int choice = showMenu();
        handleMenuOption(choice);
        return choice == 1;
    }
}