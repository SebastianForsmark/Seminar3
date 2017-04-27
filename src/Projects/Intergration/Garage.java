package Projects.Intergration;

/**
 * This is a facade to the hardware of the GARAGE, currently only the door.
 */
class Garage {

    private boolean doorIsOpen = false;
    public Garage() {
    }

    /**
     * Opens the door
     */
    void openDoor() {

        if (doorIsOpen) {
            System.out.println("The door is already open.");}
        else{
            System.out.println("The door is being opened.");
            doorIsOpen = true;
        }
    }

    /**
     * Closes the door
     */
     void closeDoor() {
        if (doorIsOpen){
            System.out.println("The door is being closed.");
            doorIsOpen = false;
        }
        else{
            System.out.println("The door is already closed.");
        }

    }

}