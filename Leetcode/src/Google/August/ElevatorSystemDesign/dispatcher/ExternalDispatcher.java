package Google.August.ElevatorSystemDesign.dispatcher;

import Google.August.ElevatorSystemDesign.ElevatorController;
import Google.August.ElevatorSystemDesign.ElevatorSystem;
import Google.August.ElevatorSystemDesign.model.Direction;

import java.util.List;

public class ExternalDispatcher {

    public static ExternalDispatcher Instance=  new ExternalDispatcher();

    private ExternalDispatcher(){

    }

    List<ElevatorController> elevatorControllerList = ElevatorSystem.INSTANCE.getElevatorControllerList();

    public void submitExternalRequest(int floor, Direction direction){


        //for simplicity, i am following even odd,
        for(ElevatorController elevatorController : elevatorControllerList) {

            int elevatorID = elevatorController.elevatorCar.id;
            if (elevatorID%2==1 && floor%2==1){
                elevatorController.submitExternalRequest(floor,direction);
            } else if(elevatorID%2==0 && floor%2==0){
                elevatorController.submitExternalRequest(floor,direction);

            }
        }
    }


}
