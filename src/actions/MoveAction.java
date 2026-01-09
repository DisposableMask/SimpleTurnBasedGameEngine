package actions;

// Java libs
import java.util.Scanner;

// Custom libs
import entities.Character;
import locations.Location;

public class MoveAction extends BaseAction
{
    public MoveAction(final Character inCharacter)
    {
        super(inCharacter);
        Execution(inCharacter);
    }

    // Nobody should call the function except this constructor
    @Override
    protected final void Execution(final Character inCharacter)
    {
        // Read input and set the character's current location based on the input

        Scanner s = new Scanner(System.in);
        final int index = s.nextInt();
        Location NewLocation = inCharacter.GetCurrentLocation().GetConnectedLocationFromIndex(index);

        // Read input finding the next location
        inCharacter.SetLocation(NewLocation);
    }
}