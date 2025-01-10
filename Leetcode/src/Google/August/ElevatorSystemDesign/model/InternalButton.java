package Google.August.ElevatorSystemDesign.model;

import Google.August.ElevatorSystemDesign.dispatcher.InternalDispatcher;

import java.util.ArrayList;
import java.util.List;

public class InternalButton extends Button{

    InternalDispatcher internalDispatcher;
    private List<Integer> floors= new ArrayList<Integer>();

    public InternalButton()
    {
        internalDispatcher = new InternalDispatcher();
    }



    @Override
    public void pressButton(int floor,Direction direction,int elevator){
        floors.add(floor);
        System.out.println("Pressed floor "+ floor + " from elevator "+ elevator);
        internalDispatcher.submitRequest(floor, direction, elevator);
    }

}
