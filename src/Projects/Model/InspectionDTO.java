package Projects.Model;


 public class InspectionDTO {
     private String regNo;
     private String partToInspect;
     private double cost;
     private boolean passed;

    public InspectionDTO(String partToInspect, double cost, boolean passed, String regNo){
        this.partToInspect = partToInspect;
        this.cost = cost;
        this.passed = passed;
        this.regNo = regNo;
    }
    public InspectionDTO(InspectionDTO oldDTO, boolean passed){
        this.partToInspect = oldDTO.partToInspect;
        this.cost = oldDTO.cost;
        this.passed = passed;
    }
     /**
      * @return The associated vehicles registration number.
      */
     public String getRegNo() {
         return regNo;
     }

     public String getPartToInspect() {
        return partToInspect;
    }
     /**
      * @return The <code>cost</code> of inspecting this part.
       */
    public double getCost() {
        return cost;
    }
     /**
      * @return Whether the part passed inspection.
      */
    public boolean getPassed(){
        return passed;
    }
}
