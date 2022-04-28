public class Goblin extends Entity{
    @Override
    Entity attack(Entity target) {
        return null;
    }

    @Override
    public String toString()
    {
        return "Goblin: " + this.name + ", HP: " + this.health + ", Strength:" + strength;
    }
}
