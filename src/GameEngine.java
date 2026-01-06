import java.util.ArrayList;
import java.util.List;

public abstract class GameEngine
{
    /**
     *  This Class will manage main game loop and initialize global variables
     *  Typical game engines contain functions like BeginPlay()/Start() and Tick(float deltaTime)/Update()
     *  We will implement them here.
     */

    // Whether the game loop should run
    protected boolean bIsRunning = true;

    // Abstract means inheriting classes need to implement the function
    protected abstract void Start();
    protected abstract void Update();

    // Creates a dynamic array of entities with initial size of 1
    // (for the player at first but may increase as more characters are in the game)
    protected List<Entity> entityList = new ArrayList<>(1);

    // Because java crashes if you try to add an object to the array list while still looping through it.
    // Gemini suggests using a spawn queue to curb the potential crash
    protected List<Entity> spawnQueue = new ArrayList<>(0);

    // Initialize the Engine to call the abstract functions
    protected void InitializeEngine()
    {
        // Initialize all entities
        for (Entity entity : entityList)
        {
            entity.Start();
        }

        // After looping through the entity list, add all elements of the spawn queue to the entity list
        if (!spawnQueue.isEmpty())
        {
            entityList.addAll(spawnQueue);
            spawnQueue.clear();
        }

        // Start the game here
        Start();
        UpdateEngine();
    }

    // Game Loop
    private void UpdateEngine()
    {
        while (bIsRunning)
        {
            // Update all entities before updating game loop
            for (Entity entity : entityList)
            {
                entity.Update();
            }

            Update();
        }
    }

    // Allow other classes to add entities to the entity list
    public void AddEntity(Entity NewEntity)
    {
        entityList.add(NewEntity);
    }
}