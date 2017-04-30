package Projects.Model;


public class Inspection {
    private InspectionChecklist inspectionChecklist;
    private Double cost;

    public Inspection(InspectionChecklist inspections){
        this.inspectionChecklist = inspections;
        this.cost=calculateCost();
    }

    /**
     * Proceeds through the <code>InspectionChecklist</code> and sums the costs of each individual <code>InspectionDTO</code>
     * @return The sum of all the costs in the array of <code>InspectionDTO</code>'s
     */
    private double calculateCost(){
        double cost = 0;
        InspectionDTO[] DTOArray = this.inspectionChecklist.inspectionDTOArray;
        for (int i = 0; i < DTOArray.length-1; i++) {
             cost += DTOArray[i].getCost();
        }
        return cost;
    }

    /**
     *
     * @return The cost of the <code>Inspection</code>
     */
    public Double getCost() {
        return cost;
    }
}
