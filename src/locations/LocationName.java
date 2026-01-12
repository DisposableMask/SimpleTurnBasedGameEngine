package locations;

public enum LocationName
{
    HOME("Home"),
    RESTAURANT("Restaurant"),
    WORK("Work");

    private final String locationName;

    LocationName(String name)
    {
        locationName = name;
    }

    public String getName()
    {
        return locationName;
    }
}
