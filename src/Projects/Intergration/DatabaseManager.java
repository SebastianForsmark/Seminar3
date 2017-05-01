package Projects.Intergration;


import Projects.Data.Database;
import Projects.Model.InspectionChecklist;

public class DatabaseManager {
private Database database = new Database();

    public DatabaseManager(){
    }

    public InspectionChecklist FindInspectionsByRegNo(String regNo){
        return database.fetchInspectionsByRegNo(regNo);
    }

    public void storeInspectionResults(InspectionChecklist inspectionResults){
        database.storeInspection(inspectionResults);
    }
}
