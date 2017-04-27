package Projects.Intergration;

import Projects.Model.Receipt;
import Projects.Model.InspectionResult;

class Printer {
    public Printer(){
    }

    void printReceipt(Receipt receipt){
        System.out.println("Receipt has been printed!");
    }

    void printInspectionResult(InspectionResult result){
        System.out.println("Inspection results have been printed!");
    }

}
