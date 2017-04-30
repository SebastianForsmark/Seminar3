package Projects.Intergration;


import Projects.Data.Database;
import Projects.Model.InspectionChecklist;

public class DatabaseManager {
private Database database = new Database();

    public DatabaseManager(){
        Database database = new Database();
    }
    public InspectionChecklist FindInspectionsByRegNo(String regNo){
        return database.fetchInspectionsByRegNo(regNo);
    }
}
