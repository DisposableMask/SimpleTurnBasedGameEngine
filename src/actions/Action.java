package actions;

// Only 1 function for now
@FunctionalInterface
public interface Action
{
    // All actions should be logged and be capable of being performed
    void Perform(String ActionName, Character character);
}


abstract class BaseAction implements Action
{
    // Final to prevent child classes to override
    @Override
    public final void Perform(String ActionName, Character character)
    {
        System.out.println("Currently performing " + ActionName + "...");
        Execution(character);
    }

    // Child classes to implement its own functionality
    protected abstract void Execution(Character character);
}