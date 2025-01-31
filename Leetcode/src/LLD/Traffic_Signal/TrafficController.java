package LLD.Traffic_Signal;

import java.util.HashMap;
import java.util.Map;

public class TrafficController {

    private static TrafficController instance;
    private final Map<Integer, Road> roads;

    public TrafficController() {
        this.roads = new HashMap<>();
    }

    public static TrafficController getInstance(){
        if (instance == null) {
            instance = new TrafficController();
        }
        return instance;
    }

    public void addRoad(Road road){
        roads.put(road.getId(),road);
    }

    public void removeRoad(Road road){
        roads.remove(road.getId());
    }

    public void controlTraffic() {
        new Thread(() -> {
            while (true) {
                try {
                    for (Road road : roads.values()) {
                        System.out.println("Turning Light GREEN for road: "+road.getId());
                        road.getTrafficLight().changeSignal(Signal.GREEN);
                        waitFor(road.getTrafficLight().getDuration());
                        System.out.println("Turning Light YELLOW for road: "+road.getId());
                        road.getTrafficLight().changeSignal(Signal.YELLOW);
                        waitFor(5);
                        System.out.println("Turning Light RED for road: "+road.getId());
                        road.getTrafficLight().changeSignal(Signal.RED);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void waitFor(int seconds) throws InterruptedException {

        Thread.sleep(seconds * 1000L);

    }

    public void handleEmergency(int roadId) throws InterruptedException {

        Road road = roads.get(roadId);
        Thread.currentThread().join();
        System.out.println("Having Emergency on Road: "+road.getId());
        if (road!=null){
            System.out.println("Turning all the lights RED");
            for (Road currRad : roads.values()) {
                TrafficLight trafficLight = road.getTrafficLight();
                trafficLight.changeSignal(Signal.RED);
            }
            System.out.println("Turning Light GREEN for road: "+road.getId());
            road.getTrafficLight().changeSignal(Signal.GREEN);
//            Set Custom Wait time here
            waitFor(road.getTrafficLight().getDuration());
            road.getTrafficLight().changeSignal(Signal.RED);
            System.out.println("Resseting the traffic");
            controlTraffic();
        }
    }
}
