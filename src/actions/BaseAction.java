package actions;

import java.lang.Character;

public abstract class BaseAction implements Action
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