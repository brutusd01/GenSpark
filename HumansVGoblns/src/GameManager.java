import java.util.Scanner;

public class GameManager {

    public static Scanner input = new Scanner(System.in);
    public static Human player = new Human(10,5, "John");
    public static Land map = new Land();


    public GameManager()
    {
        Start();
    }

    void Start()
    {
        map.GenGrid();
        map.Print();
        map.SpawnPlayer(player);

        StartTurn();
    }

    void StartTurn()
    {

        System.out.println("\n\nWhich direction would you like to move? {[N]orth, [S]outh, [W]est, [E]ast}");
        switch (input.nextLine())
        {
            case "n":
            case "N":
            case "North":
                System.out.println("Moving north!");
               map.MovePlayer(player.x() + 1, player.y());
               break;
        }
    }

}
