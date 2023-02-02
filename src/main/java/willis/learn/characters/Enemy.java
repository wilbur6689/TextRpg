package willis.learn.characters;

public class Enemy extends Character {
    // Variable to store the players current xp
    int enemyXp;

    public Enemy(String name, int enemyXp) {
        super(name, (int) (Math.random()* enemyXp + enemyXp /3 + 5), (int) (Math.random()*(enemyXp /4 + 2) + 1));

        // Assigning variable
        this.enemyXp = enemyXp;
    }

    // Enemy specific attack and defense calculations
    @Override
    public int attack() {
        return (int) (Math.random()*(enemyXp /4 + 1) + xp/4 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(enemyXp /4 + 1) + xp/4 + 4);
    }
}
