package Projects.Intergration;

/**
 * This is a facade to the hardware of the GARAGE, currently only the door. Created as a singleton.
 */
class Garage {
    private static final Garage GARAGE = new Garage();
    private boolean doorIsOpen = false;

    static Garage getGarage() {
        return GARAGE;
    }
    private Garage(){

    }

    /**
     * "Opens the door" by printing a message of the door status, if the door is already open it prints an error message.
     */
    void openDoor() {

        if (doorIsOpen) {
            System.out.println("The door is already open.");
        } else {
            System.out.println("The door is being opened.");
            doorIsOpen = true;
        }
    }

    /**
     * "Closes the door" by printing a message of the door status, if the door is already closed it prints an error message.
     */
    void closeDoor() {
        if (doorIsOpen) {
            System.out.println("The door is being closed.");
            doorIsOpen = false;
        } else {
            System.out.println("The door is already closed.");
        }

    }

}