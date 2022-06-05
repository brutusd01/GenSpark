import java.util.HashMap;

abstract class Entity {
    String name = "";
    int health = 5;
    int strength = 2;
    HashMap<Character, Integer> position;

    abstract int attack(Entity target);

    public void setHealth(int hp)
    {
        this.health = hp;
    }

    public int getHealth() {
        return health;
    }

    public void setStrength(int str)
    {
        this.strength = str;
    }

    public int getStrength() {
        return strength;
    }

    public void setPosition(int x, int y)
    {
        position.replace('x',x);
        position.replace('y',y);
    }
    public int x()
    {
        return position.get('x');
    }

    public int y()
    {
        return position.get('y');
    }

    public HashMap<Character, Integer> getPosition() {
        return this.position;
    }
}
