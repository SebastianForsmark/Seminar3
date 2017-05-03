package Projects.Intergration;


import Projects.Data.Database;
import Projects.Model.InspectionChecklist;

public class DatabaseManager {
    private Database database;

    public DatabaseManager() {
        database = new Database();
    }

    public InspectionChecklist findInspectionsByRegNo(String regNo) throws IllegalArgumentException {
        if (regNo.length()<6){
            throw new IllegalArgumentException("Registration number too short!");
        }
        if (regNo.length() > 6) {
            throw new IllegalArgumentException("Registration number too long!");
        }
        else
        return database.fetchInspectionsByRegNo(regNo);
        }

    /**
     * Sends the results of the inspection in the form of a <code>InspectionChecklist</code> to the database.
     *
     * @param inspectionResults The results of the inspection.
     */
    public void storeInspectionResults(InspectionChecklist inspectionResults) {
        database.storeInspection(inspectionResults);
    }
}
