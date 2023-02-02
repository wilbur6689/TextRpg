package willis.learn.characters;

import willis.learn.gamelogic.GameLogic;

public class Player extends Character {

    // Integers to store number of upgrades/skills in each path
    public int numAtkUpgrades, numDefUpgrades;

    // Arrays to store skill names
    public String[] atkUpgrades = {"Strength", "Power", "Might", "Godlike Strength"};
    public String[] defUpgrades = {"Heavy Bones", "StoneSkin", "Scale Armor", "Holy Aura"};

    // Player Specific constructor
    public Player(String name) {
        // Calling the constructor of superClass
        super(name, 100, 0);

        // Setting # of upgrades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;

        // Let player choose a trait when creating a new character
        chooseTrait();
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    // Let the player choose a trait of either skill path
    public void chooseTrait() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);

        // Get the players choice
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();

        // deal with both cases
        if (input == 1) {
            GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        } else {
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.promptEnterKey();
    }
}
