package willis.learn.story;

import willis.learn.characters.Player;
import willis.learn.gamelogic.GameLogic;

// Class that does nothing but storing methods to print out every part of the story
public class MainStory {

    public static void printMainIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(60);
        System.out.println("\tSTORY");
        GameLogic.printSeparator(60);
        System.out.println("Enter Here the main story line of your game");
        System.out.println("Be creative in what the main plot lines you have in store for your hero");
        GameLogic.promptEnterKey();
    }

    public static void printFirstActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(60);
        System.out.println("\tACT I - INTRO");
        GameLogic.printSeparator(60);
        System.out.println("Enter here the ACT I story line of your game");
        System.out.println("Explain plot points you wish your hero to follow in order to progress in the game");
        GameLogic.promptEnterKey();
    }

    public static void printFirstActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(60);
        System.out.println("\tACT I - OUTRO");
        GameLogic.printSeparator(60);
        System.out.println("Wrap up the ACT I story line of your game");
        System.out.println("Explain plot points your hero has overcome to progress in the game");
        GameLogic.promptEnterKey();
    }

    public static void printSecondActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(60);
        System.out.println("\tACT II - INTRO");
        GameLogic.printSeparator(60);
        System.out.println("Enter Here the ACT II story line of your game");
        System.out.println("Explain the game is getting harder for the hero");
        GameLogic.promptEnterKey();
    }

    public static void printSecondActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(60);
        System.out.println("\tACT II - OUTRO");
        GameLogic.printSeparator(60);
        System.out.println("Wrap up the ACT II story line of your game");
        System.out.println("Explain plot points your hero has overcome to progress in the game");
        GameLogic.promptEnterKey();
    }

    public static void printThirdActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(60);
        System.out.println("\tACT III - INTRO");
        GameLogic.printSeparator(60);
        System.out.println("Enter Here the ACT III story line of your game");
        System.out.println("Throw in a twist challenge the hero has to overcome");
        GameLogic.promptEnterKey();
    }

    public static void printThirdActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(60);
        System.out.println("\tACT I - INTRO");
        GameLogic.printSeparator(60);
        System.out.println("Wrap up the ACT III story line of your game");
        System.out.println("Explain plot points your hero has overcome to progress in the game");
        GameLogic.promptEnterKey();
    }

    public static void printFinalActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(60);
        System.out.println("\tFINAL ACT - INTRO");
        GameLogic.printSeparator(60);
        System.out.println("Enter Here the ACT I story line of your game");
        System.out.println("Prepare the hero for the end boss battle");
        GameLogic.promptEnterKey();
    }

    public static void printEnd(Player player) {
        GameLogic.clearConsole();
        GameLogic.printSeparator(60);
        System.out.println("\tTHE EVIL WARLORD IS DEAD!!");
        GameLogic.printSeparator(60);
        System.out.println("Congratulations " + player.name + "! You have finished this sample text RPG");
        System.out.println("You were able to beat the Evil Warlord with " + player.hp + " health left!");
        System.out.println("You finished the game with " + player.gold + " gold and " + player.xp + " XP!");
        GameLogic.promptEnterKey();
    }
}
