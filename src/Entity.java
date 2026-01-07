// All objects in the game are known as entities
public abstract class Entity
{
    Entity(final String name)
    {
        this.name = name;
    }
    public abstract void Start();
    public abstract void Update();

    // Attributes
    final protected String name;

    // Methods
    public String GetName()
    {
        return name;
    }
}
