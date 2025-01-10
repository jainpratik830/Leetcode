package Google.August.ElevatorSystemDesign.model;

import Google.August.ElevatorSystemDesign.dispatcher.ExternalDispatcher;

public class ExternalButton extends Button{

    private ExternalDispatcher edispatcher= ExternalDispatcher.Instance;
    private Direction direction;
    @Override
    public void pressButton(int floor,Direction direction){
        direction= direction;
        System.out.println("Pressed " + direction + " from floor " + floor);
        edispatcher.submitExternalRequest(floor,direction);
    }

}
