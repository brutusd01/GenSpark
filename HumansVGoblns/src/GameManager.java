import java.util.Scanner;
import java.lang.Thread;

public class GameManager {

    public static Scanner input = new Scanner(System.in);
    public static Human player = new Human(10,5, "John");
    public static Land map = new Land();
    Boolean gameOver = false;


    public GameManager()
    {
        Start();
    }

    void Start()
    {
        map.GenGrid();

        map.Print();
        map.SpawnPlayer(player);
        map.GenGoblins();
        map.Print();
        do {
            StartTurn();
        }while(!gameOver);
    }

    void StartTurn()
    {
        if(map.fight)
        {
            StartCombat();
        }
        else
            moveDirection();
    }

    private void moveDirection() {
        System.out.println("\n\nWhich direction would you like to move? {[N]orth, [S]outh, [W]est, [E]ast}");
        switch (input.nextLine())
        {
            case "n":
            case "N":
            case "North":
            case "up":
                System.out.println("Moving North.");
               map.MovePlayer(player, player.x()-1, player.y());
               break;
            case "s":
            case "S":
            case "South":
            case "down":
                System.out.println("Moving South.");
                map.MovePlayer(player, player.x()+1, player.y());
                break;
            case "e":
            case "E":
            case "East":
            case "right":
                System.out.println("Moving East.");
                map.MovePlayer(player, player.x(), player.y()+1);
                break;
            case "w":
            case "W":
            case "West":
            case "left":
                System.out.println("Moving West.");
                map.MovePlayer(player, player.x(), player.y()-1);
                break;
        }
    }

    void StartCombat()
    {
        Goblin gobo = new Goblin();
        System.out.println("You encounter Goblin: " + gobo.name);
        while(!gameOver || map.fight)
        {
            System.out.println("[A]ttack or [F]lee? (A or F)");
            switch(input.nextLine())
            {
                case "a":
                case "A":
                case "attack":
                    player.attack(gobo);
                    WaitForSeconds(2000);
                    if (Dead(gobo)) return;
                    break;
                case "F":
                case "f":
                case "flee":
                case "Flee":
                    System.out.println("Run away!");
                    map.fight = false;
                    map.Print();
                    return;
            }
        }
    }

    private void WaitForSeconds(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean Dead(Goblin gobo) {
        if(gobo.getHealth() <= 0) //Check to see if its dead
        {
            System.out.println(String.format("%s falls! You win!", gobo.name));
            map.goblinsLeft--;
            if(map.goblinsLeft > 0)System.out.println(String.format("You now have %s goblins left on the map!", map.goblinsLeft));
            else if(map.goblinsLeft <=0)GameOver(true);
            map.ResetSpace(map.eventLoc.get('x'), map.eventLoc.get('y'));
            map.fight = false;
            return true;
        }
        return false;
    }

    private void GameOver(boolean win)
    {
       if(win) System.out.println("Congrats! You beat all the goblins!");
        WaitForSeconds(5000);
       if(!win) System.out.println("Game over. Your legend ends here.");
        WaitForSeconds(5000);
       System.out.println("Play again? [Y/N]");
       switch(input.nextLine())
       {
           case "y":
           case "Y":
               System.out.println("Your legend continues!");
               break;
           case "N":
           case "n":
               System.out.println("Au revoir!");
                System.exit(0);
       }
    }


}
