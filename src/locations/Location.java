package locations;

// Java libs
import java.util.ArrayList;
import java.util.List;

// Custom libs
import actions.Action;
import entities.Character;


public abstract class Location
{
    final private String name;

    Location(final String locationName)
    {
        name = locationName;
    }

    public String GetName()
    {
        return name;
    }

    // List of all available actions at the location
    private List<Action> availableActions = new ArrayList<>();

    // List of all connected locations to this location
    private List<Location> connectedLocations = new ArrayList<>();

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
}
