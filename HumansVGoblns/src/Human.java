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
    Entity attack(Entity target) {
        return null;
    }
}
