package locations;

import java.util.ArrayList;
import java.util.List;

/** Consideration on designing the location class
 * 1. Should we instantiate a new HomeLocation object everytime we move a character to this class?
 * 2. If instantiate new HomeLocation. How do we know what is saved in the home location previously?
 * 3. Hence, we keep a weak shared pointer-like reference to the HomeLocation so it will be garbage collected if completely unused.
 */

public class HomeLocation extends Location
{
    public HomeLocation(LocationName name)
    {
        super(name);

        // Try to find a location by its name else create a new object with that name
        WorkLocation workLocation = CreateLocationByName(LocationName.WORK, () -> new WorkLocation(LocationName.WORK));

        // Get the existing connectedLocations from location pool
        List<Location> connectedLocations = new ArrayList<>();
        connectedLocations.add(workLocation);

        // Set the connected locations at the start
        SetConnectedLocations(connectedLocations);

        // TODO: Only print when player moves to this location
        for (Location location : connectedLocations)
        {
            System.out.println("Home Connected Location: " + location.GetName());
        }
    }
}
