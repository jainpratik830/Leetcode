package LLD.Traffic_Signal;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TrafficController trafficController = TrafficController.getInstance();

        // Create roads
        Road road1 = new Road(1, "Main Street");
        Road road2 = new Road(2, "Broadway");
        Road road3 = new Road(3, "Park Avenue");
        Road road4 = new Road(4, "Elm Street");

        // Create traffic lights
        TrafficLight trafficLight1 = new TrafficLight(1, 6);
        TrafficLight trafficLight2 = new TrafficLight(2, 6);
        TrafficLight trafficLight3 = new TrafficLight(3, 6);
        TrafficLight trafficLight4 = new TrafficLight(4, 6);

        // Assign traffic lights to roads
        road1.setTrafficLight(trafficLight1);
        road2.setTrafficLight(trafficLight2);
        road3.setTrafficLight(trafficLight3);
        road4.setTrafficLight(trafficLight4);

        // Add roads to the traffic controller
        trafficController.addRoad(road1);
        trafficController.addRoad(road2);
        trafficController.addRoad(road3);
        trafficController.addRoad(road4);

        // Start traffic control
        trafficController.controlTraffic();
        Thread.sleep(10000);
        // Simulate an emergency on a specific road
        trafficController.handleEmergency(2);
    }

}
