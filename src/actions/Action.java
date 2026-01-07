package actions;

// Only 1 function for now
@FunctionalInterface
public interface Action
{
    // All actions should be logged and be capable of being performed
    void Perform(String ActionName, Character character);
}