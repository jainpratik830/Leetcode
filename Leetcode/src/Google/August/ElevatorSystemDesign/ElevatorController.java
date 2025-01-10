package Google.August.ElevatorSystemDesign;

import Google.August.ElevatorSystemDesign.algorithm.PendingRequests;
import Google.August.ElevatorSystemDesign.model.Direction;
import Google.August.ElevatorSystemDesign.model.Elevator;

import java.util.PriorityQueue;

public class ElevatorController {
    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    public Elevator elevatorCar;

    ElevatorController(Elevator elevatorCar){

        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a,b) -> b-a);

    }
    public void submitExternalRequest(int floor, Direction direction){

        if(direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }
    }

    public void submitInternalRequest(int floor){

    }

    public void controlElevator(){
        while(true) {

            if(elevatorCar.dir == Direction.UP){


            }
        }
    }


}
