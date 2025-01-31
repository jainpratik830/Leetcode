package LLD.Traffic_Signal;

public class TrafficLight {



    private final int id;
    private Signal currentSignal;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private int duration;

    public TrafficLight(int id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    public synchronized void changeSignal(Signal signal){
        this.currentSignal= signal;
        notifyObservers();
    }

    public Signal getCurrentSignal(){
        return currentSignal;
    }



    private void notifyObservers() {
        // Notify observers (e.g., roads) about the signal change
        // ...
    }
}
