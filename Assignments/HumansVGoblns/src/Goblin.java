public class Goblin extends Entity{

    String[] names = {"Unc", "Duch", "Gobo", "Abobo", "Keke"};

    public Goblin()
    {
        this.strength = (int)(Math.random() * 3) + 2;
        this.health = (int)(Math.random() * 10) + 1;
        this.name = names[(int)(Math.random() * names.length)];
    }

    @Override
    int attack(Entity target) {
        int damage = (int)(Math.random() * getStrength());
        if(damage >0)System.out.println(String.format("%n%s bashes %s with their club for %s.",this.name, target.name, damage));
        else if(damage == 0)System.out.println(String.format("%n%s missed their strike on %s.",this.name, target.name));
        target.setHealth(target.getHealth() - damage);

        return target.getHealth();
    }

    @Override
    public String toString()
    {
        return "Goblin{: " + this.name + ", HP: " + this.health + ", Strength:" + strength + "}";
    }
}
