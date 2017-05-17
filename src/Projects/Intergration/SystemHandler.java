package Projects.Intergration;


import Projects.Model.InspectionChecklist;
import Projects.Model.Receipt;

/**
 * Acts as intermediary between <code>Controller</code> and some external systems.
 */
public class SystemHandler {
    Display numberDisplay;
    private Garage garage;
    private Printer printer;

    public SystemHandler() {
        numberDisplay = Display.getDisplay();
        garage = Garage.getGarage();
        printer = new Printer();
    }

    /**
     * Receives command from <code>Controller</code> to initiate inspection, opens the <code>Garage</code> door and updates the <code>Display</code>.
     */

    public void nextInspection() {
        garage.openDoor();
        numberDisplay.nextNumber();
    }

    /**
     * Closes the garage door
     */
    public void closeGarageDoor() {
        garage.closeDoor();
    }

    /**
     * Prints the <code>InspectionChecklist</code> after it's been updated with results.
     *
     * @param inspectionResults The updated <code>InspectionChecklist</code>
     */
    public void printResults(InspectionChecklist inspectionResults) {
        printer.printInspectionResult(inspectionResults);
    }

    /**
     * Prints the receipt of payment
     *
     * @param receipt The information of the payment
     */
    public void printReceipt(Receipt receipt) {
        printer.printReceipt(receipt);
    }
}
