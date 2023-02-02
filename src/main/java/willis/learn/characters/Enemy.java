package willis.learn.characters;

public class Enemy extends Character {
    // Variable to store the players current xp
    int playerXp;

    public Enemy(String name, int playerXp) {
        super(name, (int) (Math.random()*playerXp + playerXp/3 + 5), (int) (Math.random()*(playerXp/4 + 2) + 1));

        // Assigning variable
        this.playerXp = playerXp;
    }

    // Enemy specific attack and defense calculations
    @Override
    public int attack() {
        return (int) (Math.random()*(playerXp/4 + 1) + xp/4 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(playerXp/4 + 1) + xp/4 + 4);
    }
}
