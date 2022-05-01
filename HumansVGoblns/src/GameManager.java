import java.util.Scanner;
import java.lang.Thread;

public class GameManager {

    public static Scanner input = new Scanner(System.in);
    public static Human player = new Human(10,5, "");
    public static Land map = new Land();
    Boolean gameOver = false;


    public GameManager()
    {
        Start();
    }

    void Start()
    {
        player = new Human(10,5, "");
        gameOver = false;
        System.out.println("\nGreetings, what is your name?");
        player.name = input.nextLine();

        if(player.name.isEmpty() || player.name.isBlank())
        {
            System.out.println("\nShy huh? I'll just call you Thundercat instead.");
            player.name= "Thundercat";
        }
        WaitForSeconds(1000);
        map.GenGrid();
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
            case "north":
            case "up":
                System.out.println("Moving North.");
               map.MovePlayer(player, player.x()-1, player.y());
               break;
            case "s":
            case "S":
            case "South":
            case "south":
            case "down":
                System.out.println("Moving South.");
                map.MovePlayer(player, player.x()+1, player.y());
                break;
            case "e":
            case "E":
            case "East":
            case "east":
            case "right":
                System.out.println("Moving East.");
                map.MovePlayer(player, player.x(), player.y()+1);
                break;
            case "w":
            case "W":
            case "West":
            case "west":
            case "left":
                System.out.println("Moving West.");
                map.MovePlayer(player, player.x(), player.y()-1);
                break;
        }
    }

    void StartCombat()
    {
        Goblin gobo = new Goblin();
        System.out.println("\nYou encounter Goblin: " + gobo.name);
        while(!gameOver || map.fight)
        {
            if(player.getHealth() <= 0)
        {
            GameOver(false);
            return;
        }
            System.out.println("\n"+player.toString());
            System.out.println("\n" + gobo.toString());
            WaitForSeconds(1000);
            System.out.println("\n[A]ttack or [F]lee? (A or F)");
            switch(input.nextLine())
            {
                case "a":
                case "A":
                case "attack":
                case "Attack":
                    player.attack(gobo);
                    WaitForSeconds(1000);
                    if (Dead(gobo)) return;
                    else
                        gobo.attack(player);

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
            System.out.println(String.format("%n%s falls! You win!", gobo.name));
            map.goblinsLeft--;
            if(map.goblinsLeft > 0)System.out.println(String.format("%nThere are %s goblins left on the map!", map.goblinsLeft));
            else if(map.goblinsLeft <=0)GameOver(true);
            WaitForSeconds(1000);
            map.ResetSpace(map.eventLoc.get('x'), map.eventLoc.get('y'));
            map.fight = false;
            return true;
        }
        return false;
    }

    private void GameOver(boolean win)
    {
        gameOver = true;
        map.fight = false;

       if(win) System.out.println("\nCongrats! You beat all the goblins!");
        WaitForSeconds(1000);
       if(!win) System.out.println("\nYou fall unconscious... Your legend ends here because you lost to a low level mob.");
        WaitForSeconds(1000);
       System.out.println("\nPlay again? [Y/N]");
       try {
           switch (input.nextLine()) {
               case "y":
               case "Y":
                   System.out.println("\nYour legend continues..");
                   WaitForSeconds(1000);
                   Start();
                   break;
               case "N":
               case "n":
                   System.out.println("Au revoir!");
                   System.exit(0);
           }
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }


}
