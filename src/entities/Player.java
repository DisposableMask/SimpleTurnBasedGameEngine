package entities;

import locations.Location;

import java.util.Scanner;

public class Player extends Character
{
    public Player()
    {
        // All players will have a "Player" name
        super("Player");
    }

    // Extend the functionality of SetLocation to print to console if it is the player
    public void SetLocation(Location newLocation)
    {
        super.SetLocation(newLocation);

        System.out.println("-- Player::START --");
        System.out.println("Currently at " + GetCurrentLocation().GetName());
        System.out.println("Printing Location Options...");
        System.out.println("-- END --");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        System.out.println("Your choice is: " + choice);
        // Perform the action at the current location
        GetCurrentLocation().PerformActionOn(this, choice);
    }

}