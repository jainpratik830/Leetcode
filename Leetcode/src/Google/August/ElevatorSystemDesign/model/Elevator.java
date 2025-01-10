package Google.August.ElevatorSystemDesign.model;

public class Elevator {

    public int id;
    Door door;
    Display display;
    Button button;
    int currFloor;
    public Direction dir;

    public Elevator(int id)
    {
        this.id= id;
        door= new Door();
        display= new Display();
        currFloor= 0;
        dir= Direction.NONE;
        button= new InternalButton();

    }

    public void move(int floor,Direction dir){
        System.out.println("Elevator " + id + "moving " + dir);
        System.out.println("Elevator " + id + "stops at floor " + floor);
        door.open(id);
        door.close(id);

        //called everytime when currFloor value changes
        setDisplay();
    }

    public void pressButton(int floor)
    {
        Direction dir= Direction.NONE;
        if(floor>currFloor)
            dir= Direction.UP;
        else if(floor<currFloor)
            dir= Direction.DOWN;
        button.pressButton(floor, dir, id);
    }

    private void setDisplay()
    {
        display.floor=(currFloor);
        display.direction=(dir);

    }

}
