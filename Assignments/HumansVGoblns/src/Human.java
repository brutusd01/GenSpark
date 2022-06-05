public class Human extends Entity {

    public Human(int HP, int STR, String name)
    {
        this.health = HP;
        this.strength = STR;
        this.name = name;
    }
    public Human()
    {
        this.health = 10;
        this.strength = 5;
        this.name = "";
    }


    @Override
    public String toString()
    {
        return "Human{: " + this.name + ", HP: " + this.getHealth() + ", Strength:" + strength + "}";
    }

    @Override
    int attack(Entity target) {
        if(target != null) {
            int damage = (int)(Math.random() * getStrength());
            target.setHealth(target.getHealth() - damage);
            if(damage > 0)System.out.println(String.format("%n%s swings at %s for %s damage! They have %s health left!", this.name, target.name, damage, target.getHealth()));
            else if(damage == 0) System.out.println(String.format("%nUh oh, %s missed!",this.name));
        }
        assert target != null;
        return target.getHealth();
    }
}
