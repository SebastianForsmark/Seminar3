package Projects.Model;


public class Inspection {
    public InspectionChecklist currentInspectionChecklist;
    private Double cost;
    private int part = -1;

    public Inspection(InspectionChecklist inspections) {
        this.currentInspectionChecklist = inspections;
        this.cost = calculateCost();
    }

    /**
     * Proceeds through the <code>InspectionChecklist</code> and sums the costs of each individual <code>InspectionDTO</code>
     *
     * @return The sum of all the costs in the array of <code>InspectionDTO</code>'s
     */
    double calculateCost() {
        double cost = 0;
        InspectionDTO[] DTOArray = this.currentInspectionChecklist.inspectionDTOArray;
        for (int i = 0; i <= DTOArray.length - 1; i++) {
            cost += DTOArray[i].getCost();
        }
        return cost;
    }

    /**
     * Proceeds through the array starting at 0 and incrementing with each method call.
     *
     * @return The next <code>InspectionDTO</code> in the array.
     */
    public InspectionDTO fetchNextInspection() {
        part++;
        if (part <= currentInspectionChecklist.inspectionDTOArray.length)
            return this.currentInspectionChecklist.inspectionDTOArray[part];
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Updates the <code>isPassed</code> boolean of an <code>InspectionDTO</code>.
     *
     * @param isPassed The result of the <code>Inspection</code>.
     * @param target   The <code>InspectionDTO</code> that needs updating.
     */
    public void updateInspectionChecklist(boolean isPassed, InspectionDTO target) {
        currentInspectionChecklist.updateInspectionDTO(isPassed, target);
    }

    /**
     * @return The cost of the <code>Inspection</code>
     */
    public Double getCost() {
        return cost;
    }
}
