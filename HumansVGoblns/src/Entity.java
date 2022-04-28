import java.util.HashMap;

abstract class Entity {
    String name = "";
    float health = 5f;
    float strength = 2f;
    HashMap<Character, Integer> position;

    abstract Entity attack(Entity target);

    public void setHealth(float hp)
    {
        this.health = hp;
    }

    public float getHealth() {
        return health;
    }

    public void setStrength(float str)
    {
        this.strength = str;
    }

    public float getStrength() {
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
