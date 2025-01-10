package Google.August.ElevatorSystemDesign.algorithm;

import Google.August.ElevatorSystemDesign.ElevatorController;
import Google.August.ElevatorSystemDesign.ElevatorSystem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorControlStrategy {

    private Queue<PendingRequests> pendingRequestList= new LinkedList<PendingRequests>();
    private List<ElevatorController> elevatorControllerList = ElevatorSystem.INSTANCE.getElevatorControllerList();


    public Queue<PendingRequests> getPendingRequestList() {
        return pendingRequestList;
    }

    public void setPendingRequestList(Queue<PendingRequests> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }


    public void moveElevator(ElevatorController elevatorController)
    {

    }

}
