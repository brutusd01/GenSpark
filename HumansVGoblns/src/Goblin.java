public class Goblin extends Entity{

    String[] names = {"Unc", "Duch", "Gobo", "Abobo", "Keke"};
    public Goblin()
    {
        this.strength = 2;
        this.health = (int)(Math.random() * 3) + 1;
        this.name = names[(int)(Math.random() * names.length)];
    }

    @Override
    int attack(Entity target) {
        return target.getHealth();
    }

    @Override
    public String toString()
    {
        return "Goblin: " + this.name + ", HP: " + this.health + ", Strength:" + strength;
    }
}
