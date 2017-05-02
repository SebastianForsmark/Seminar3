package Projects.Controller;


import Projects.Intergration.CreditCard;
import Projects.Intergration.DatabaseManager;
import Projects.Intergration.PaymentAuthorization;
import Projects.Intergration.SystemHandler;
import Projects.Model.Inspection;
import Projects.Model.InspectionChecklist;
import Projects.Model.InspectionDTO;
import Projects.Model.Receipt;

public class Controller {
    private DatabaseManager databaseManager = new DatabaseManager();
    private SystemHandler systemHandler = new SystemHandler();
    private PaymentAuthorization paymentAuthorization = new PaymentAuthorization();
    public Inspection currentInspection;

    public Controller(){

    }

    /**
     * Collects the <code>InspectionChecklist</code> from the <code>Database</code>, creates an <code>Inspection</code> and calculates the sum of the costs.
     * @param regNo The registration number received from View
     * @return The cost of the <code>Inspection</code>
     */
    public double enterRegNo(String regNo){
        InspectionChecklist inspections = databaseManager.FindInspectionsByRegNo(regNo);
        currentInspection = new Inspection(inspections);
        return currentInspection.getCost();
    }

    /**
     * Closes the <code>Garage</code> door
     */
    public void closeGarageDoor(){
        systemHandler.closeGarageDoor();
    }

    /**
     * Authorizes the payment and prints a <code>Receipt</code>
     * @param creditcard The <code>CreditCard</code> constructed in the View
     * @param cost The Cost derived from the <code>InspectionChecklist</code>
     */
    public void registerPayment(CreditCard creditcard, Double cost){
        boolean isApproved = paymentAuthorization.authorizePayment(creditcard, cost);
        Receipt paymentReceipt = new Receipt(cost, isApproved);
        print(paymentReceipt);
    }

    /**
     * Requests the next <code>InspectionDTO</code>
     * @return The next <code>InspectionDTO</code> contained in the <code>InspectionChecklist</code>
     */
    public InspectionDTO getNextInspection(){
    return currentInspection.fetchNextInspection();
    }

    public void registerResult(String result, InspectionDTO target){
        boolean isPassed;
        if (
            result.equalsIgnoreCase("passed")||
            result.equalsIgnoreCase("pass")||
            result.equalsIgnoreCase("Passed!")) {
            isPassed = true;
        }
        else isPassed = false;
    currentInspection.updateInspectionChecklist(isPassed, target);
    }

    public void inspectionComplete(InspectionChecklist inspectionResults){
        databaseManager.storeInspectionResults(inspectionResults);
        print(inspectionResults);

    }
    private void print(InspectionChecklist inspectionResults){
        systemHandler.printResults(inspectionResults);
    }
    private void print(Receipt paymentReceipt){
        systemHandler.printReceipt(paymentReceipt);
    }
}
