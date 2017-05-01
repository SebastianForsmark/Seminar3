package Projects.Intergration;


import Projects.Model.InspectionChecklist;
import Projects.Model.Receipt;

public class SystemHandler {
    Display numberDisplay = new Display();
    Garage garage = new Garage();
    Printer printer = new Printer();
    CashRegister cashRegister = new CashRegister();

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
