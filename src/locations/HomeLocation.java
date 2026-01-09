package locations;


import Engine.GameEngine;

/** Consideration on designing the location class
 * 1. Should we instantiate a new HomeLocation object everytime we move a character to this class?
 * 2. If instantiate new HomeLocation. How do we know what is saved in the home location previously?
 * 3. Hence, we keep a weak shared pointer-like reference to the HomeLocation so it will be garbage collected if completely unused.
 */

public class HomeLocation extends Location
{
    public HomeLocation()
    {
        super("Home");

        //SetConnectedLocations(GameEngine.GetInstance());
    }
}
