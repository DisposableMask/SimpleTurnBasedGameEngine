package actions;

import entities.Character;

public abstract class BaseAction implements Action
{
    private String name;

    BaseAction(final Character inCharacter)
    {

    }

    // Final to prevent child classes to override
    @Override
    public final void Perform(final String actionName, final Character inCharacter)
    {
        System.out.println("Currently performing " + actionName + "...");
        Execution(inCharacter);
    }

    // Child classes to implement its own functionality
    protected abstract void Execution(final Character inCharacter);

    public String GetName()
    {
         return name;
    }
}