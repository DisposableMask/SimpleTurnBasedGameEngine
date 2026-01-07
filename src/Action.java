// Only 1 function for now
@FunctionalInterface
public interface Action
{
    // All Actions should be logged and be capable of being performed
    void Perform(String ActionName);
}


abstract class BaseAction implements Action
{
    // Final to prevent child classes to override
    @Override
    public final void Perform(String ActionName)
    {
        System.out.println("Currently performing " + ActionName + "...");
        Execution();
    }

    // Child classes to implement its own functionality
    protected abstract void Execution();
}