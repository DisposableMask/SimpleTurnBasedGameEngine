package locations;

// Java libs
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

// Custom libs
import actions.Action;
import entities.Character;
import game.SimsGame;


public abstract class Location
{
    final private LocationName name;

    // List of all available actions at the location
    private final List<Action> availableActions = new ArrayList<>();

    // List of all connected locations to this location
    private final List<Location> connectedLocations = new ArrayList<>();

    Location(final LocationName locationName)
    {
        name = locationName;
        // Store this new location object into the SimsGame static list of locations
        UpdateLocationInstance(this);
    }

    public String GetName()
    {
        return name.getName();
    }

    //~ Begin Setters
    protected void SetLocationActions(List<Action> actionsToAdd)
    {
        if (actionsToAdd == null || actionsToAdd.isEmpty())
        {
            throw new IllegalArgumentException("actionsToAdd to this location is null or empty!");
        }

        if (!availableActions.isEmpty())
        {
            availableActions.clear();
        }
        availableActions.addAll(actionsToAdd);
    }

    protected void SetConnectedLocations(List<Location> locationsToAdd)
    {
        if (locationsToAdd == null || locationsToAdd.isEmpty())
        {
            throw new IllegalArgumentException("locationsToAdd to this location is null or empty!");
        }

        // Clear the locations
        if (!connectedLocations.isEmpty())
        {
            connectedLocations.clear();
        }
        // Add the locations
        connectedLocations.addAll(locationsToAdd);
    }
    //~ End Setters

    //~ Begin Getters

    //~ End Getters

    // TODO: Delete this unused method
    public void PrintOptions()
    {
        int index = 1;
        for (Action actions : availableActions)
        {
            System.out.println(index + " " + actions.GetName());
            index++;
        }
    }

    private void UpdateLocationInstance(final Location location)
    {
        SimsGame instance = (SimsGame) SimsGame.GetInstance();
        instance.AddLocationToPool(location);
    }

    public void PerformActionOn(final Character inCharacter, final int actionIndex)
    {
        // Identify the action to perform
        final Action action = availableActions.get(actionIndex);

        // Perform action on this character via an interface
        action.Perform(action.GetName(), inCharacter);
    }

    public Location GetConnectedLocationFromIndex(int index)
    {
        return connectedLocations.get(index);
    }

    // Template/Generic function
    protected <T extends Location> T CreateLocationByName(final LocationName locationName, Supplier<T> locationFactory)
    {
        SimsGame instance = (SimsGame) SimsGame.GetInstance();

        // If location is found, case to the supplied type first, else return an empty of object of the supplied type
        return instance.GetLocationFromPoolByName(locationName).map(location -> (T) location).orElseGet(locationFactory);
    }
}
