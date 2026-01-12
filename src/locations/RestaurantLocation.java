package locations;

import java.util.ArrayList;
import java.util.List;

public class RestaurantLocation extends Location
{
    RestaurantLocation(LocationName name)
    {
        super(name);

        WorkLocation workLocation = CreateLocationByName(LocationName.WORK, () -> new WorkLocation(LocationName.WORK));

        List<Location> connectedLocations = new ArrayList<>();
        connectedLocations.add(workLocation);

        SetConnectedLocations(connectedLocations);

        // TODO: Only print when player moves to this location
        for (Location location : connectedLocations)
        {
            System.out.println("Restaurant Connected Location: " + location.GetName());
        }
    }
}
