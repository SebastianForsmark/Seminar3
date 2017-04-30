package Projects.Intergration;


public class SystemHandler {
    Display numberDisplay;
    Garage garage;
    Printer printer;
    CashRegister cashRegister;

    public SystemHandler(){
        Display numberDisplay = new Display();
        Garage garage = new Garage();
        Printer printer = new Printer();
        CashRegister cashRegister = new CashRegister();
    }
}
