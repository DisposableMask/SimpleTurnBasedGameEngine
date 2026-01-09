package Engine;

import entities.Player;
import locations.HomeLocation;

public class SimsGame extends GameEngine
{
    private final Player player;
    private SimsGame()
    {
        System.out.println("Sims Game Constructor!");

        player = new Player();
        AddEntity(player); // Add player to the entity list
    }

    // Optional to add @Override but good practice
    @Override
    protected void Start()
    {
        System.out.println("Sims Game Start!");
        player.SetLocation(new HomeLocation());
    }

    @Override
    protected void Update()
    {
        //System.out.println("Update!");
    }

    // public is redundant for main() method in Java 25
    static void main()
    {
        SimsGame game = new SimsGame();

        // Call parent class initialize engine
        game.InitializeEngine();
    }
}
