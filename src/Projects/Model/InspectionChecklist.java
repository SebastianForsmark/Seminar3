package Projects.Model;


public class InspectionChecklist {
    int numberOfInspections;
    InspectionDTO[] inspectionDTOArray;

    public InspectionChecklist(int numberOfInspections, InspectionDTO[] inspectionsFromDatabase) {
        this.numberOfInspections = numberOfInspections;
        inspectionDTOArray = inspectionsFromDatabase;

    }
}