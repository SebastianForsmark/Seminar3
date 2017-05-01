package Projects.Model;


public class InspectionChecklist {
    private int numberOfInspections;
    public InspectionDTO[] inspectionDTOArray;

    public InspectionChecklist(int numberOfInspections, InspectionDTO[] inspectionsFromDatabase) {
        this.numberOfInspections = numberOfInspections;
        inspectionDTOArray = inspectionsFromDatabase;

    }
    public void updateInspectionDTO(boolean isPassed, InspectionDTO target){
        int x = identifyArrayIndex(target);
        if(x>=0)
        this.inspectionDTOArray[x] = new InspectionDTO(target, isPassed);
    }

    private int identifyArrayIndex(InspectionDTO target){
        for (int i = 0; i < inspectionDTOArray.length-1 ; i++) {
            if (inspectionDTOArray[i].getCost() == target.getCost() && inspectionDTOArray[i].getPartToInspect() == target.getPartToInspect() && inspectionDTOArray[i].getRegNo() == target.getRegNo()){
                return i;
            }
        }
        return -1;
    }
}