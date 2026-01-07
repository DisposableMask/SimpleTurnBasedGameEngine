package locations;

import actions.BaseAction;

import java.util.ArrayList;
import java.util.List;

public abstract class Location
{
    // Available actions at the location
    private List<BaseAction> availableActions = new ArrayList<>();
}
