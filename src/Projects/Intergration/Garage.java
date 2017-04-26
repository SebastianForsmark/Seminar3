package Projects.Intergration;

/**
 * This is a facade to the hardware of the GARAGE, namely the door and the queue
 * number display on the outside wall.
 */
public class Garage {
    private Display queueNumDisp = new Display();

    /**
     * Creates an instance and connects to the door and queue number display.
     */
    public Garage() {
    }

    /**
     * Opens the door and displays the next queue number.
     */
    public void nextCustomer() {
        queueNumDisp.nextNumber();
    }

    /**
     * Closes the door
     */
    public void closeDoor() {

    }

}