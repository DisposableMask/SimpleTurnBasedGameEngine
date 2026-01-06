public class SimsGame extends GameEngine
{
    // Optional to @Override but good practice
    @Override
    protected void Start()
    {
        System.out.println("Start!");
    }

    @Override
    protected void Update()
    {
        System.out.println("Update!");
    }

    // public is redundant for main() method in Java 25
    static void main()
    {
        SimsGame game = new SimsGame();

        // Call parent class initialize engine
        game.InitializeEngine();
    }
}
