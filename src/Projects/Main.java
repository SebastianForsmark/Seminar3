package Projects;
import Projects.Controller.Controller;
import Projects.Intergration.*;
import Projects.Model.InspectionDTO;import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Controller contr = new Controller();
        System.out.println("Please enter registration number: ");
        String registrationNumber = keyboard.nextLine();
        double cost = contr.enterRegNo(registrationNumber);
        int intCost = (int) cost;
        System.out.println("The cost is: " + intCost + " SEK");
        CreditCard creditCard = new CreditCard(1234,"894583054","John Smith","2018/09",231);
        contr.registerPayment(creditCard,cost);
        System.out.println("Press any key to continue");
        String anyKey = keyboard.nextLine();

        for (int i = 0; i <contr.currentInspection.currentInspectionChecklist.inspectionDTOArray.length-1 ; i++) {
            InspectionDTO currentInspection = contr.getNextInspection();
            System.out.println("Registration number: " + currentInspection.getRegNo());
            System.out.println("Part to Inspect: " + currentInspection.getPartToInspect());
            System.out.println("Cost: " + (int) currentInspection.getCost());
            System.out.println("Passed: " + currentInspection.getPassed());
            System.out.println("Enter inspection result");
            String keyboardInput = keyboard.nextLine();
            contr.registerResult(keyboardInput,currentInspection);
        }
        contr.inspectionComplete(contr.currentInspection.currentInspectionChecklist);
    }

}
