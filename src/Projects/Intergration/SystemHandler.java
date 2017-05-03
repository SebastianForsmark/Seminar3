package Projects.Intergration;


import Projects.Model.InspectionChecklist;
import Projects.Model.Receipt;


public class SystemHandler {
    Display numberDisplay;
    private Garage garage;
    private Printer printer;

    public SystemHandler() {
        numberDisplay = new Display();
        garage = new Garage();
        printer = new Printer();
    }

    /**
     * Closes the garage door
     */

    public void nextInspection() {
        garage.openDoor();
        numberDisplay.nextNumber();
    }

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
