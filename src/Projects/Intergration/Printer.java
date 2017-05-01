package Projects.Intergration;

import Projects.Model.InspectionChecklist;
import Projects.Model.Receipt;

class Printer {
    public Printer(){
    }

    /**
     * Prints the payment receipt.
     * @param receipt The receipt from the card payment.
     */
    void printReceipt(Receipt receipt){
        System.out.println("Receipt has been printed!");
    }

    /**
     * Prints the result of the inspection.
     * @param result The <code>InspectionChecklist</code> created at the end of the inspection.
     */
    void printInspectionResult(InspectionChecklist result){
        System.out.println("-------------------");
        for (int i = 0; i < result.inspectionDTOArray.length-1 ; i++) {
            System.out.println("Part: " + result.inspectionDTOArray[i].getPartToInspect());
            String inspectionResult;

            if(result.inspectionDTOArray[i].getPassed()){
                inspectionResult = "Passed!";
            }
            else{
                inspectionResult = "Failed!";
            }
            System.out.println("Result: " + inspectionResult);
            System.out.println("-------------------");
        }

    }

}
