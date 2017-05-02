package Projects.Model;


public class InspectionChecklist {
    private int numberOfInspections;
    public InspectionDTO[] inspectionDTOArray;

    public InspectionChecklist(int numberOfInspections, InspectionDTO[] inspectionsFromDatabase) {
        this.numberOfInspections = numberOfInspections;
        inspectionDTOArray = inspectionsFromDatabase;

    }
     void updateInspectionDTO(boolean isPassed, InspectionDTO target){
        int x = identifyArrayIndex(target);
        if(x>=0)
        this.inspectionDTOArray[x] = new InspectionDTO(target, isPassed);
    }

    private int identifyArrayIndex(InspectionDTO target){
        for (int i = 0; i < inspectionDTOArray.length-1 ; i++) {
            if (
                    inspectionDTOArray[i].getCost() == target.getCost() && //Cost is the same
                    inspectionDTOArray[i].getPartToInspect() == target.getPartToInspect() && //Part is the same
                    inspectionDTOArray[i].getRegNo() == target.getRegNo() // RegNo is the same
                    ){
                return i;
            }
        }
        return -1;
    }
}