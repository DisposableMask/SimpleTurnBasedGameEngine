package actions;

import entities.Character;

public interface Action
{
    // All actions should be logged and be capable of being performed
    void Perform(String ActionName, Character character);

    // All actions should have a name
    String GetName();
}