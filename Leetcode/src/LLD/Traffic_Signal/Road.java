package LLD.Traffic_Signal;

public class Road {

   private final int id;
    private final String name;

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    private TrafficLight trafficLight;


    public Road(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

}
