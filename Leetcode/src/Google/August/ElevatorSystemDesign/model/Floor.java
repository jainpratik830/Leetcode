package Google.August.ElevatorSystemDesign.model;

public class Floor {

    int level;
    Display display;
    Button button;


    public Floor(int level) {
        this.level = level;
        this.button = new ExternalButton();
    }

    public void pressButton(Direction direction){
        this.button.pressButton(level,direction);
    }

    public void setDisplay(int floor,Direction dir) {
        this.display.direction= dir;
        this.display.floor = floor;
    }
}
