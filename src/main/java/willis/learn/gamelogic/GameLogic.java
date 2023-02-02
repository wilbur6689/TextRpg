package willis.learn.gamelogic;

import willis.learn.characters.Enemy;
import willis.learn.characters.Player;
import willis.learn.story.MainStory;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    // Default random Encounters for first act
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};

    // Default enemy Names for first act
    public static String[] enemies = {"Ogre", "Ogre", "Goblin", "Goblin", "Stone Elemental"};

    // Story elements
    public static int place = 0, act = 1;
    public static String[] places = {"Everlasting Mountains", "Haunted Forest", "Castle of the Evil Warlord", "Throne Room"};

    // method to get user input from console
    public static int readInt(String prompt, int userChoices){
        int input;

        do {
            System.out.println(prompt);
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
        // check if act must be increased
        checkAct();

        // Check if game isn't in last act
        if (act != 4) {
            randomEncounter();
        }
    }

    // Method to calculate a random encounter
    public static void randomEncounter() {
        // Random Number between 0 and the length of the encounters array
        int encounter = (int) (Math.random()* encounters.length);

        // Calling the respective methods
        if (encounters[encounter].equals("Battle")){
            randomBattle();
        } else if (encounters[encounter].equals("Rest")) {
            //takeRest();
        } else {
            //Shop();
        }
    }

    static void checkAct() {
        // Change acts based on XP
        // Check to see if the game needs to increase the act to II
        if (player.xp >= 10 && act == 1) {
            // Increment act and palace
            act = 2;
            place = 1;

            // Story
            MainStory.printFirstActOutro();

            // Let the player "Level up"
            player.chooseTrait();

            // Story
            MainStory.printSecondActIntro();

            // Assign new Values to Enemies
            enemies[0] = "Evil Mercenary";
            enemies[1] = "Goblin";
            enemies[2] = "Wolf Pack";
            enemies[3] = "Henchman of Warlord";
            enemies[4] = "Scary Stranger";

            // Assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";

        // Check to see if the game needs to increase the act to III
        } else if (player.xp >= 50 && act == 2) {
            // Increment act and palace
            act = 3;
            place = 2;

            // Story
            MainStory.printSecondActOutro();

            // Let the player "Level up"
            player.chooseTrait();

            // Story
            MainStory.printThirdActIntro();
            // Assign new Values to Enemies
            enemies[0] = "Evil Mercenary";
            enemies[1] = "Goblin";
            enemies[2] = "Wolf Pack";
            enemies[3] = "Henchman of Warlord";
            enemies[4] = "Scary Stranger";

            // Assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Shop";

            // Fully heal the Player
            player.hp = player.maxHp;

        // Check to see if the game needs to increase the act to the final act
        } else if (player.xp >= 100 && act == 3) {
            // Increment act and palace
            act = 4;
            place = 3;

            // Story
            MainStory.printThirdActOutro();

            // Let the player "Level up"
            player.chooseTrait();

            // Story
            MainStory.printFinalActIntro();
            // Fully heal the Player
            player.hp = player.maxHp;
            // Calling the final Battle
            //finalBattle();
        }
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

    // Creating a random Battle
    public static void randomBattle() {
        clearConsole();
        printHeading("You have encountered an evil minded creature. You'll have to fight it!");
        promptEnterKey();

        // Create new enemy with random name
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.xp));
    }

    // The main BATTLE method
    public static void battle(Enemy enemy) {
        // Main battle loop
        while(true) {
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choose an action to perform:");
            printSeparator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
            int input = readInt("-> ", 3);

            if (input == 1) {
                // Fight
                // Calculate dmg and dmgTook (dmg enemy deals to player)
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();

                // Check that dmg and dmgTook isn't negative
                if(dmgTook < 0) {
                    // add some dmg if player defends very well
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if(dmg < 0) {
                    dmg =0;
                }

                // Deal damage to both parties
                player.hp -= dmgTook;
                enemy.hp -= dmg;

                // Print the info of this battle round
                clearConsole();
                printHeading("BATTLE");
                System.out.println("You Delt " + dmg + " damage to the " + enemy.name + ".");
                printSeparator(15);
                System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                promptEnterKey();

                // Check to see if player is still alive
                if (player.hp <= 0) {
                    playerDied(); // Method to end the game
                    break;
                } else if (enemy.hp <= 0 ) {
                    // Tell the player he won
                    clearConsole();
                    printHeading("You Defeated the " + enemy.name + "!");

                    // Increase the player XP
                    player.xp += enemy.xp;
                    System.out.println("You earned " + enemy.xp + " XP!");
                    promptEnterKey();
                    break;
                }
            } else if (input == 2) {
                // USE A POTION

            } else {
                // RUN AWAY
                clearConsole();

                if (act != 4) {
                    // Chance of 35% to escape
                    if (Math.random()*10 + 1 <= 3.5) {
                        printHeading("You ran away from the " + enemy.name + "!");
                        promptEnterKey();
                        break;
                    } else {
                        // Calculate damage to player
                        printHeading("You didn't manage to escape, get back to the fight!");
                        int dmgTook = enemy.attack();
                        System.out.println("In your hurry you took " + dmgTook + " damage!");
                        promptEnterKey();

                        // Check if player's still alive
                        if(player.hp <= 0) {
                            playerDied(); // Method to end the game
                        }
                    }
                } else {
                    printHeading("YOU CANNOT ESCAPE THE EVIL WARLORD!!!");
                    promptEnterKey();
                }
            }

        }
    }

    private static void playerDied() {
        clearConsole();
        printHeading("You died.....");
        printHeading("You Earned " + player.xp + " XP on your journey. Try to earn more next time!");
        System.out.println("Thank you for player this game!");
        isRunning = false;
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
