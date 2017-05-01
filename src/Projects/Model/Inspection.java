package Projects.Model;


import java.util.EmptyStackException;

public class Inspection {
    public InspectionChecklist currentInspectionChecklist;
    private Double cost;
    int part = -1;

    public Inspection(InspectionChecklist inspections){
        this.currentInspectionChecklist = inspections;
        this.cost=calculateCost();
    }

    /**
     * Proceeds through the <code>InspectionChecklist</code> and sums the costs of each individual <code>InspectionDTO</code>
     * @return The sum of all the costs in the array of <code>InspectionDTO</code>'s
     */
    private double calculateCost(){
        double cost = 0;
        InspectionDTO[] DTOArray = this.currentInspectionChecklist.inspectionDTOArray;
        for (int i = 0; i < DTOArray.length-1; i++) {
             cost += DTOArray[i].getCost();
        }
        return cost;
    }

    public InspectionDTO fetchNextInspection(){
        part++;
        return this.currentInspectionChecklist.inspectionDTOArray[part];
    }

    public void updateInspectionChecklist(boolean isPassed, InspectionDTO target){
        currentInspectionChecklist.updateInspectionDTO(isPassed, target);
    }

    /**
     *
     * @return The cost of the <code>Inspection</code>
     */
    public Double getCost() {
        return cost;
    }
}
