package Projects.View;

import Projects.Controller.*;
import Projects.Intergration.*;
import Projects.Model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class View {
    private Scanner keyboard = new Scanner(System.in);
    private double cost;
    private Controller controller;

    public View(Controller contr) {
        controller = contr;
        contr.addObserver(new InspectionStatsView());
    }

    /**
     * Loops through the entire flow of the inspection in a constant loop after initiating the systems.
     */
    public void initiateInspection() {
        while (true) {
            beginInspection();
            try {
                inputRegistrationNumber();
            }
            catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            }
            handlePayment();
            inspectAndSubmitResults();
        }
    }



    /**
     * -------------------------------------------        Below are divided sub-methods for the 'view'         -------------------------------------------
     */



    private void beginInspection(){
        System.out.println("Press Enter to initiate next inspection: ");
        String initiate = keyboard.nextLine();
        controller.initiateInspection();
        System.out.println("Press Enter to close door ");
        String closeDoor = keyboard.nextLine();
        controller.closeGarageDoor();
    }

    private void inputRegistrationNumber()throws FileNotFoundException{
        cost = 0;
        while (true) {
            try {
                System.out.println("Please enter registration number: ");
                String registrationNumber = keyboard.nextLine();
                cost = controller.enterRegNo(registrationNumber);
                break;
            } catch (IllegalArgumentException | RegNoNotFoundException e) {
                System.out.println(e.getMessage());
                FileOutputStream fos = new FileOutputStream(new File("exceptionlog.txt"), true);
                PrintStream ps = new PrintStream(fos);
                e.printStackTrace(ps);
            }
        }
    }
    private void handlePayment(){
        int intCost = (int) cost;
        System.out.println("The cost is: " + intCost + " SEK");
        System.out.println("Press Enter to pay");
        String pay = keyboard.nextLine();
        CreditCard creditCard = new CreditCard(1234, "894583054", "John Smith", "2018/09", 231);
        controller.registerPayment(creditCard, cost);
        System.out.println("Press Enter to continue");
        String proceedToInspection = keyboard.nextLine();
    }
    private void inspectAndSubmitResults(){
        InspectionDTO currentInspection;
        for (int i = 0; i < controller.currentInspection.currentInspectionChecklist.inspectionDTOArray.length; i++) {
            currentInspection = controller.getNextInspection();
            System.out.println("Registration number: " + currentInspection.getRegNo());
            System.out.println("Part to Inspect: " + currentInspection.getPartToInspect());
            System.out.println("Cost: " + (int) currentInspection.getCost());
            System.out.println("Passed: " + currentInspection.getPassed());
            System.out.println("Enter inspection result");
            String keyboardInput = keyboard.nextLine();
            controller.registerResult(keyboardInput, currentInspection);
        }
        controller.inspectionComplete(controller.currentInspection.currentInspectionChecklist);
    }
}
