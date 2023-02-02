package willis.learn;

import willis.learn.gamelogic.GameLogic;

public class Main {
    public static void main(String[] args) {

        GameLogic.printHeading("Testing Helper Methods!");
        GameLogic.anythingToContinue();
        GameLogic.clearconsole();
        int input = GameLogic.readInt("Enter 1, 2, or 3: ", 3);
        System.out.println("You chose number " + input);
    }
}