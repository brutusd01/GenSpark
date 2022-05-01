public class Human extends Entity {

    public Human(int HP, int STR, String name)
    {
        this.health = HP;
        this.strength = STR;
        this.name = name;
    }


    @Override
    public String toString()
    {
        return "Name: " + this.name + ", HP: " + this.health + ", Strength:" + strength;
    }

    @Override
    int attack(Entity target) {
        if(target != null) {
            int damage = (int)(Math.random() * getStrength());
            target.setHealth(target.getHealth() - damage);
            if(damage > 0)System.out.println(String.format("%s took %s damage! They have %s health left!", target.name, damage, target.getHealth()));
            else if(damage == 0) System.out.println("Uh oh, you missed!");
        }
        assert target != null;
        return target.getHealth();
    }
}
