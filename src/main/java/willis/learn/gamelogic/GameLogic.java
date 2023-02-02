package willis.learn.gamelogic;

import willis.learn.characters.Player;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    // method to get user input from console
    public static int readInt(String promt, int userChoices){
        int input;

        do {
            System.out.println(promt);
            try{
                input =  Integer.parseInt(scanner.next());
            } catch(Exception e) {
                input = -1;
                System.out.println("Please enter an integer!");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }

    // Method to simulate clearing out the console
    public static void clearConsole(){
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    }

    // Method to print a separator with length n
    public static void printSeparator(int n){
        for (int i=0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // Method to print a heading
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    // Method to stop the game until user enters anything
    public static void anythingToContinue(){
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }

    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    // Method to start the game
    public static void startGame() {
        boolean nameSet = false;
        String name;

        // Print Title Screen
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("AGE OF THE EVIL OVERLORD");
        System.out.println("SAMPLE TEXT RPG");
        printSeparator(30);
        printSeparator(40);
        promptEnterKey();

        // Getting the player name
        do{
            clearConsole();
            printHeading("What is your name traveler? ");
            name = scanner.next();

            // Asking the player if he wants to correct his choice
            clearConsole();
            printHeading("Your name is " + name + ".\nIs this correct?");
            System.out.println("(1) Yes");
            System.out.println("(2) Nope, I want to change my name.");
            int input = readInt("-> ", 2);
            if (input == 1) {
                nameSet = true;
            }
        }while(!nameSet);

        // Create a new player object with the name
        player = new Player(name);

        // Start main game loop (Next part)
        // gameLoop();
    }
}
