package willis.learn.gamelogic;

import willis.learn.characters.Player;
import willis.learn.story.MainStory;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    // Story elements
    public static int place = 0, act;
    public static String[] places = {"Everlasting Mountains", "Haunted Forest", "Castle of the Evil Warlord", "Throne Room"};

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

        // Print the story intro
        MainStory.printMainIntro();

        // Create a new player object with the name
        player = new Player(name);

        // Print first story act intro
        MainStory.printFirstActIntro();

        //  Setting isRunning to True, so the game loop can continue
        isRunning = true;

        // Start main game loop (Next part)
        gameLoop();
    }

    // Method to continue the journey

    private static void continueJourney() {

    }
    // Method to print the main menu

    private static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an Action to perform:");
        printSeparator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }

    private static void characterInfo() {
        clearConsole();
        printHeading("CHARACTER INFORMATION");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp);
        printSeparator(20);


        // printing the chosen traits
        if(player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades -1]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0) {
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades -1]);
            printSeparator(20);
        }

        promptEnterKey();
    }

    private static void gameLoop() {
        while(isRunning) {
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1) {
                continueJourney();
            } else if (input == 2) {
                characterInfo();
            } else {
                isRunning = false;
            }
        }
    }
}
