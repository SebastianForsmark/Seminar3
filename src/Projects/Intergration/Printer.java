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
        System.out.println("Inspection results have been printed!");
    }

}
