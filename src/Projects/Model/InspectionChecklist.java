package Projects.Model;


public class InspectionChecklist {
    public InspectionDTO[] inspectionDTOArray;

    /**
     * Constructor used after accessing the <code>Database</code>.
     *
     * @param inspectionsFromDatabase The array of <code>InspectionDTO</code>'s returned from the <code>Database</code>.
     */
    public InspectionChecklist(InspectionDTO[] inspectionsFromDatabase) {
        inspectionDTOArray = inspectionsFromDatabase;

    }

    /**
     * Updates the <code>isPassed</code> boolean of an <code>InspectionDTO</code>.
     *
     * @param isPassed The result of the <code>Inspection</code>.
     * @param target   The <code>InspectionDTO</code> that needs updating.
     */
    void updateInspectionDTO(boolean isPassed, InspectionDTO target) {
        int x = identifyArrayIndex(target);
        if (x == -1) {
            return;
        } // If it isn't part of the array, replace nothing.
        this.inspectionDTOArray[x] = new InspectionDTO(target, isPassed);
    }

    /**
     * Proceeds through an array comparing the <code>target</code>'s </code> <code>cost</code>, <code>PartToInspect</code>, and <code>RegNo</code> for a match, then returns the index of the match.
     *
     * @param target The <code>InspectionDTO</code> whose index needs to be found.
     * @return the index of the target <code>InspectionDTO</code>.
     */
    int identifyArrayIndex(InspectionDTO target) {
        for (int i = 0; i < inspectionDTOArray.length; i++) {
            if (
                    inspectionDTOArray[i].getCost() == target.getCost() && //Is the cost is the same?
                            inspectionDTOArray[i].getPartToInspect().equals(target.getPartToInspect())  && //Is the part is the same?
                            inspectionDTOArray[i].getRegNo().equals(target.getRegNo())  //Is the RegNo the same?
                    ) {
                return i;
            }
        }
        return -1;
    }
}