package Projects.Intergration;


import Projects.Model.InspectionChecklist;
import Projects.Model.Receipt;

public class SystemHandler {
    private Display numberDisplay = new Display();
    private Garage garage = new Garage();
    private Printer printer = new Printer();
    private CashRegister cashRegister = new CashRegister();

    public SystemHandler(){

    }
    public void closeGarageDoor(){
        garage.closeDoor();
    }

    public void printResults(InspectionChecklist inspectionResults){
        printer.printInspectionResult(inspectionResults);
    }

    public void printReceipt(Receipt receipt){
        printer.printReceipt(receipt);
    }
}
