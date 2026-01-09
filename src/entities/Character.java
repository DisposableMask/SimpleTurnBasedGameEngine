package entities;

import locations.Location;

public class Character extends Entity
{
    Character(final String name)
    {
        super(name);
    }

    // Core functions
    @Override
    public void Start()
    {
        System.out.println("entities.Character Name: " + GetName());
    }

    @Override
    public void Update()
    {
    }

    public void SetLocation(Location NewLocation)
    {
        currentLocation = NewLocation;
    }


    // Attributes
    private String name;
    private Location currentLocation;

    // Getters
    public Location GetCurrentLocation()
    {
        return currentLocation;
    }
}
