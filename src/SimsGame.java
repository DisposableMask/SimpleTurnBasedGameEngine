public class SimsGame extends GameEngine
{
    public SimsGame()
    {
        System.out.println("Sims Game Constructor!");
        Character Player = new Character("Player");
        AddEntity(Player);
    }

    // Optional to add @Override but good practice
    @Override
    protected void Start()
    {
        System.out.println("Sims Game Start!");
    }

    @Override
    protected void Update()
    {
        //System.out.println("Update!");
    }

    // public is redundant for main() method in Java 25
    static void main()
    {
        SimsGame game = new SimsGame();

        // Call parent class initialize engine
        game.InitializeEngine();
    }
}
