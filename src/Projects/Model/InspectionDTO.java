package Projects.Model;

 public class InspectionDTO {
     private String regNo;
     private String partToInspect;
     private double cost;
     private boolean passed;

     /**
      * The DTO in which information about each partial inspection exists.
      * @param partToInspect The part of the car that is to be inspected.
      * @param cost The price of the <code>Inspection</code>.
      * @param passed Whether the <code>Inspection</code> was passed.
      * @param regNo The registration number of the vehicle to be inspected.
      */
    public InspectionDTO(String partToInspect, double cost, boolean passed, String regNo){
        this.partToInspect = partToInspect;
        this.cost = cost;
        this.passed = passed;
        this.regNo = regNo;
    }

     /**
      * Second constructor used to edit an existing DTO.
      * @param oldDTO The DTO that will be updated with new information.
      * @param passed Whether the vehicle <code>passed</code> the <code>Inspection</code>.
      */
     InspectionDTO(InspectionDTO oldDTO, boolean passed){
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

     /**
      * @return The part to be inspected
      */
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
