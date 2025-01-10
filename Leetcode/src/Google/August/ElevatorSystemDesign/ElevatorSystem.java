package Google.August.ElevatorSystemDesign;

import Google.August.ElevatorSystemDesign.algorithm.ElevatorControlStrategy;
import Google.August.ElevatorSystemDesign.algorithm.ElevatorSelectionStrategy;
import Google.August.ElevatorSystemDesign.model.Floor;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {

    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    private List<ElevatorController> elevatorControllerList= new ArrayList<ElevatorController>();
    public static ElevatorControlStrategy elevatorControlStrategy;
    public static ElevatorSelectionStrategy elevatorSelectionStrategy;
    public List<Floor> floors= new ArrayList<Floor>();

    public static ElevatorSystem INSTANCE= new ElevatorSystem();

    private ElevatorSystem()
    {

    }

    public void addElevator(ElevatorController e)
    {
        elevatorControllerList.add(e);
    }
    public void removeElevator(ElevatorController e)
    {
        elevatorControllerList.remove(e);
    }
    public void setElevatorControlStrategy(ElevatorControlStrategy elevatorControlStrategy)
    {
        this.elevatorControlStrategy= elevatorControlStrategy;
    }
    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy)
    {
        this.elevatorSelectionStrategy= elevatorSelectionStrategy;
    }
    public  void addFloor(Floor floor)
    {
        floors.add(floor);
    }

}
