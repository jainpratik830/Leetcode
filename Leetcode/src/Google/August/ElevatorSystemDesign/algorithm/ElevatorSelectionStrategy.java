package Google.August.ElevatorSystemDesign.algorithm;

import Google.August.ElevatorSystemDesign.ElevatorController;
import Google.August.ElevatorSystemDesign.ElevatorSystem;
import Google.August.ElevatorSystemDesign.model.Direction;

import java.util.List;

public class ElevatorSelectionStrategy {


    protected List<ElevatorController> elevatorControllerList = ElevatorSystem.INSTANCE.getElevatorControllerList();


    public int selectElevator(int floor, Direction dir) {
        return 0;
    }

}
