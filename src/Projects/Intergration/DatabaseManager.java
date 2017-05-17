package Projects.Intergration;


import Projects.Data.Database;
import Projects.Model.InspectionChecklist;

/**
 * Handles commands and requests to the <code>Database</code>
 */
public class DatabaseManager {
    private Database database;

    public DatabaseManager() {
        database = new Database();
    }

    /**
     * Locates inspections by registration number. Throws an exception if the argument is not 6 characters long.
     * @param regNo The vehicles registration number
     * @return The <code>InspectionChecklist</code> containing <code>InspectionDTO</code>'s
     * @throws IllegalArgumentException The registration number needs to be 6 characters long.
     */
    public InspectionChecklist findInspectionsByRegNo(String regNo) throws IllegalArgumentException, RegNoNotFoundException {

        if (regNo.length() < 6) {
            throw new IllegalArgumentException("Registration number too short!");
        }
        if (regNo.length() > 6) {
            throw new IllegalArgumentException("Registration number too long!");
        } else
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
