package LLD.Traffic_Signal;

import java.util.HashMap;
import java.util.Map;

public class TrafficController {
    private static TrafficController instance;
    private final Map<Integer, Road> roads;
    private Thread trafficThread;  // Store reference to traffic control thread
    private volatile boolean emergencyMode = false;  // Flag to indicate emergency

    public TrafficController() {
        this.roads = new HashMap<>();
    }

    public static TrafficController getInstance() {
        if (instance == null) {
            instance = new TrafficController();
        }
        return instance;
    }

    public void addRoad(Road road) {
        roads.put(road.getId(), road);
    }

    public void removeRoad(Road road) {
        roads.remove(road.getId());
    }

    public void controlTraffic() {
        trafficThread = new Thread(() -> {
            while (true) {
                try {
                    if (emergencyMode) {
                        System.out.println("Emergency Mode Active. Traffic control paused.");
                        synchronized (this) {
                            wait(); // Pause the thread until emergency is handled
                        }
                    }

                    for (Road road : roads.values()) {
                        System.out.println("Turning Light GREEN for road: " + road.getId());
                        road.getTrafficLight().changeSignal(Signal.GREEN);
                        waitFor(road.getTrafficLight().getDuration());

                        System.out.println("Turning Light YELLOW for road: " + road.getId());
                        road.getTrafficLight().changeSignal(Signal.YELLOW);
                        waitFor(5);

                        System.out.println("Turning Light RED for road: " + road.getId());
                        road.getTrafficLight().changeSignal(Signal.RED);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Traffic Control Interrupted due to Emergency.");
                }
            }
        });
        trafficThread.start();
    }

    private void waitFor(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
    }

    public void handleEmergency(int roadId) throws InterruptedException {
        emergencyMode = true; // Set flag to pause traffic control

        if (trafficThread != null) {
            trafficThread.interrupt();  // Interrupt the thread
        }

        Road road = roads.get(roadId);
        if (road != null) {
            System.out.println("Emergency on Road: " + road.getId());
            System.out.println("Turning all lights RED");
            for (Road currRoad : roads.values()) {
                currRoad.getTrafficLight().changeSignal(Signal.RED);
            }

            System.out.println("Turning Light GREEN for emergency road: " + road.getId());
            road.getTrafficLight().changeSignal(Signal.GREEN);
            waitFor(road.getTrafficLight().getDuration());

            road.getTrafficLight().changeSignal(Signal.RED);
            System.out.println("Emergency Handled. Resuming Normal Traffic.");

            synchronized (this) {
                emergencyMode = false;
                notify();  // Resume traffic control
            }
        }
    }
}
