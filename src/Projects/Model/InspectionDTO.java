package Projects.Model;


import Projects.Util.Amount;

public class InspectionDTO {
    private String partToInspect;
    private Amount cost;
    private boolean passed;

    public InspectionDTO(String partToInspect, Amount cost, boolean passed){
        this.partToInspect = partToInspect;
        this.cost = cost;
        this.passed = passed;
    }
    public InspectionDTO(InspectionDTO oldDTO, boolean passed){
        this.partToInspect = oldDTO.partToInspect;
        this.cost = oldDTO.cost;
        this.passed = passed;
    }

    public String getPartToInspect() {
        return partToInspect;
    }

    public Amount getCost() {
        return cost;
    }
    public boolean getPassed(){
        return passed;
    }
}
