package Google.August.ElevatorSystemDesign.algorithm;

import Google.August.ElevatorSystemDesign.model.Direction;

public class PendingRequests {

    private int floor;
    private Direction dir;

    public  PendingRequests(int floor, Direction dir)
    {
        this.floor= floor;
        this.dir= dir;
    }

}
