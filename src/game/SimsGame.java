package game;

import entities.Player;
import locations.HomeLocation;
import locations.Location;
import locations.LocationName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimsGame extends GameEngine
{
    private final Player player;

    private static final List<Location> locationPool = new ArrayList<>();

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
        player.SetLocation(new HomeLocation(LocationName.HOME));
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

        // Call parent class initialize game
        game.InitializeEngine();
    }

    public void AddLocationToPool(final Location location)
    {
        if (!locationPool.contains(location))
        {
            locationPool.add(location);
        }
    }

    public Optional<Location> GetLocationFromPoolByName(LocationName locationName)
    {
        Location location;
        for (Location l: locationPool)
        {
            if (l.GetName().equals(locationName.getName()))
            {
                location = l;
                return Optional.of(location);
            }
        }

        return Optional.empty();
    }
}
