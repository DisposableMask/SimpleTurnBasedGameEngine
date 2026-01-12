package locations;

import java.util.ArrayList;
import java.util.List;

public class WorkLocation extends Location
{
    public WorkLocation(LocationName name)
    {
        super(name);

        // Get the existing connectedLocations from location pool
        HomeLocation homeLocation = CreateLocationByName(LocationName.HOME, () -> new HomeLocation(LocationName.HOME));
        RestaurantLocation restaurantLocation = CreateLocationByName(LocationName.RESTAURANT, () -> new RestaurantLocation(LocationName.RESTAURANT));

        // Set the connected locations at the start
        List<Location> connectedLocations = new ArrayList<>();
        connectedLocations.add(homeLocation);
        connectedLocations.add(restaurantLocation);

        SetConnectedLocations(connectedLocations);

        // TODO: Only print when player moves to this location
        for (Location location : connectedLocations)
        {
            System.out.println("Work Connected Location: " + location.GetName());
        }
    }
}
