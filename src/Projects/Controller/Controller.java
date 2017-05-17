package Projects.Controller;


import Projects.Intergration.*;
import Projects.Model.Inspection;
import Projects.Model.InspectionChecklist;
import Projects.Model.InspectionDTO;
import Projects.Model.Receipt;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles system operations
 */
public class Controller {
    private DatabaseManager databaseManager;
    private SystemHandler systemHandler;
    private PaymentAuthorization paymentAuthorization;
    public Inspection currentInspection;
    private List<InspectionResultsObserver> inspectionObservers = new ArrayList<>();

    public Controller() {
        databaseManager = new DatabaseManager();
        systemHandler = new SystemHandler();
        paymentAuthorization = new PaymentAuthorization();
    }

    /**
     * Updates the display and opens the door.
     */
    public void initiateInspection() {
        System.out.println("Display updated.");
        systemHandler.nextInspection();
    }

    /**
     *
     * Collects the <code>InspectionChecklist</code> from the <code>Database</code>, creates an <code>Inspection</code> and calculates the sum of the costs.
     *
     * @param regNo The registration number received from View
     * @return The cost of the <code>Inspection</code>
     * @throws IllegalArgumentException The registration number needs to be 6 characters long.
     * @throws RegNoNotFoundException The registration number needs to be found in the <code>Database</code> (Currently hardcoded).
     */
    public double enterRegNo(String regNo) throws IllegalArgumentException, RegNoNotFoundException{
        InspectionChecklist partsOfInspection = databaseManager.findInspectionsByRegNo(regNo);
        currentInspection = new Inspection(partsOfInspection);
        return currentInspection.getCost();
    }

    /**
     * Closes the <code>Garage</code> door
     */
    public void closeGarageDoor() {
        systemHandler.closeGarageDoor();
    }

    /**
     * Authorizes the payment and prints a <code>Receipt</code>
     *
     * @param creditcard The <code>CreditCard</code> constructed in the View
     * @param cost       The Cost derived from the <code>InspectionChecklist</code>
     */
    public void registerPayment(CreditCard creditcard, Double cost) {
        boolean isApproved = paymentAuthorization.authorizePayment(creditcard, cost);
        Receipt paymentReceipt = new Receipt(cost, isApproved);
        print(paymentReceipt);
    }

    /**
     * Requests the next <code>InspectionDTO</code>
     *
     * @return The next <code>InspectionDTO</code> contained in the <code>InspectionChecklist</code>
     */
    public InspectionDTO getNextInspection() {
        return currentInspection.fetchNextInspection();
    }

    /**
     * Takes a <code>String</code> from <code>View</code> and if it says "passed","pass", or "p" then the inspection passed, else it failed. It then informs the observers.
     * @param result <code>String</code> from the inspector after being asked if the inspection passed.
     * @param target The current <code>InspectionDTO</code> being handled.
     */
    public void registerResult(String result, InspectionDTO target) {
        boolean isPassed;
        isPassed = result.equalsIgnoreCase("passed") ||
                result.equalsIgnoreCase("pass") ||
                result.equalsIgnoreCase("p");
        currentInspection.updateInspectionChecklist(isPassed, target);
        informObservers(isPassed);
    }

    /**
     * Stores the inspection results and prints them.
     * @param inspectionResults The results of the inspection as an <code>InspectionChecklist</code>
     */
    public void inspectionComplete(InspectionChecklist inspectionResults) {
        databaseManager.storeInspectionResults(inspectionResults);
        print(inspectionResults);

    }

    private void print(InspectionChecklist inspectionResults) {
        systemHandler.printResults(inspectionResults);
    }

    private void print(Receipt paymentReceipt) {
        systemHandler.printReceipt(paymentReceipt);
    }

    /**
     * Adds an observer to a list of observers.
     * @param obs an object of <code>InspectionResultObserver</code>.
     */
    public void addObserver(InspectionResultsObserver obs){
        inspectionObservers.add(obs);
    }

    /**
     * Informs observing classes that the current inspection passed or failed.
     * @param isPassed Whether the current inspection passed or failed.
     */
    private void informObservers(boolean isPassed){
        for(InspectionResultsObserver obs : inspectionObservers){
            obs.newResult(isPassed);
        }
    }
}
