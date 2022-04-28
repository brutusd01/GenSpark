import java.util.HashMap;

public class Land {

    private final String[][] grid;
    private int rows = 8;
    private int columns = 10;
    HashMap<Character, Integer> lastPlayerPos; //Used to "move" where the player emoji is

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
        int r = (int)(Math.random() * rows);
        int c = (int)(Math.random() * columns);

        pos.put('x',r);
        pos.put('y',c);
        lastPlayerPos = pos;
        MovePlayer(r,c);
    }

    //TODO: Make this take the player as a target to move the player all in one function.

    void MovePlayer(int x, int y)
    {
        grid[lastPlayerPos.get('x')][lastPlayerPos.get('y')] = "*";
        lastPlayerPos.replace('x',x); //Set new last player pos
        lastPlayerPos.replace('y',y);
        grid[x][y] = "\uD83D\uDE0E";
        Print();
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
}
