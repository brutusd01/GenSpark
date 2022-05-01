import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Land {

    private final String[][] grid;
    private int rows = 10;
    private int columns = 10;
    HashMap<Character, Integer> lastPlayerPos; //Used to "move" where the player emoji is
    HashMap<Character, Integer> eventLoc;
    private int maxGoblins = 5;
    public int goblinsLeft = 0;
    public String human = "\uD83D\uDE0E";
    public String goblin = "\uD83D\uDC7F";
    public Boolean fight = false;

    public Land()
    {
        grid = new String[rows][columns];
    }

    void GenGrid() {

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++){
                grid[r][c] = "*";
            }
        }
    }

    void SpawnPlayer(Human player)
    {

        HashMap<Character, Integer> pos = new HashMap<>();
        int r = (int)(Math.random() * (rows-1)) + 1;
        int c = (int)(Math.random() * (columns-1)) + 1;

        pos.put('x',r);
        pos.put('y',c);
        lastPlayerPos = pos;
        grid[r][c] = human;
        //MovePlayer(player,r,c);
        player.position = pos;
    }

    void GenGoblins()
    {
        goblinsLeft = 0; //Reset the count
        for (int i = 1; i <= maxGoblins; i++) {
            goblinsLeft++;
            var newGobo = new Goblin();
            newGobo.position = new HashMap<>();
            int r = (int) (Math.random() * (rows-1)) + 1;
            int c = (int) (Math.random() * (columns-1)) + 1;
            if (grid[r][c].equals("*"))
            {
                grid[r][c] = goblin;
                newGobo.setPosition(r,c);
            }
            else while(!Objects.equals(grid[r][c], "*"))
            { //Redo the randomization until it finds an untaken spot
                r = (int) (Math.random() * (rows-1)) + 1;
                c = (int) (Math.random() * (columns-1)) + 1;
                grid[r][c] = goblin;
                newGobo.setPosition(r,c);
            }
        }
    }

    public void ResetSpace(int x, int y)
    {
        if(!grid[x][y].equals(human))
            grid[x][y] = "*";
        Print();
    }

    //TODO: Make this take the player as a target to move the player all in one function.

    void MovePlayer(Human player, int x, int y)
    {
        if(x >=rows || y >columns || x<=0 || y<=0) {
            Print();
            System.out.println("Area out of bounds, move somewhere else!");
            return;
        }
        if(CheckPos(x, y).equals("*")) {//If it is just land move there
            try {
                if (lastPlayerPos != null) grid[lastPlayerPos.get('x')][lastPlayerPos.get('y')] = "*";
                assert lastPlayerPos != null;
                lastPlayerPos.replace('x', x); //Set new last player pos
                lastPlayerPos.replace('y', y);
                grid[x][y] = human;
                Print();
            } catch (Exception e) {
                System.out.println("Area out of bounds, move somewhere else!");
                Print();
            }
        }
        if(CheckPos(x, y).equals(goblin))
        {
            eventLoc = new HashMap<>();
            eventLoc.put('x', x);
            eventLoc.put('y',y);
            fight = true;
        }
    }

    void Print()
    {
        System.out.println();
        for (int r = 0; r < rows; r++) {
            System.out.println(); //Add a blank line for every row
            for (int c = 0; c < columns; c++){
                System.out.print(grid[r][c] + " "); //Add a space between each character
            }
        }
    }

    String CheckPos(int x, int y)
    {
     return grid[x][y];
    }
}
