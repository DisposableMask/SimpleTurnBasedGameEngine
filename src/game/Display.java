package game;

import actions.Action;

import java.util.List;

public class Display
{
    public static void Options(final String msg, final List<Action> actions)
    {
        System.out.println(msg);
        int lineNumber = 1;
        for (Action action : actions)
        {
            System.out.println(lineNumber + ". " + action.GetName());
        }
        System.out.println(lineNumber + ". Quit");
    }
}
