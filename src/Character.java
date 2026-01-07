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
        System.out.println("Character Name: " + GetName());
    }

    @Override
    public void Update()
    {

    }

    // Attributes
    private String name;

    // Methods
}

class Player extends Character
{
    Player()
    {
        // All players will have a "Player" name
        super("Player");
        // GameEngine.GetGameEngine().AddEntity(this);
    }

}
