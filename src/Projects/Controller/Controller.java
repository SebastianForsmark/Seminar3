package Projects.Controller;


import Projects.Intergration.DatabaseManager;
import Projects.Intergration.SystemHandler;
import Projects.Model.Inspection;
import Projects.Model.InspectionChecklist;

public class Controller {
    private DatabaseManager databaseManager = new DatabaseManager();
    SystemHandler systemHandler = new SystemHandler();

    public Controller(){

    }

    /**
     * Collects the <code>InspectionChecklist</code> from the <code>Database</code>, creates an <code>Inspection</code> and calculates the sum of the costs.
     * @param regNo The registration number received from View
     * @return The cost of the <code>Inspection</code>
     */
    public double enterRegNo(String regNo){
        InspectionChecklist inspections = databaseManager.FindInspectionsByRegNo(regNo);
        Inspection currentInspection = new Inspection(inspections);
        return currentInspection.getCost();
    }
}
