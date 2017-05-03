package Projects.Data;

import Projects.Model.*;

import java.util.Random;

public class Database {

private Random r = new Random();
String[] possibleParts = {"Exhaust Pipe","Drivers Chair","Headlights","Left front tire","Ejector seat","Illegal nitrous system","Steering wheel"};

    /**
     * Takes a registration number for a vehicle and returns the inspections for that vehicle, currently randomized to replace a database.
     * @param regNo The submitted registration number during the search.
     * @return Returns a randomly generated <code>InspectionChecklist</code>.
     */
    public InspectionChecklist fetchInspectionsByRegNo(String regNo){
        return createRandomInspection(regNo);
    }

    /**
     * Returns a <code>InspectionChecklist</code> with a random (between 1 and 7) number of <code>InspectionDTO</code>'s.
     * @return The randomly generated <code>InspectionChecklist</code>.
     */
    private InspectionChecklist createRandomInspection(String regNo){
        int numberOfInspections = 1+r.nextInt(7);

        InspectionDTO[] inspections = new InspectionDTO[numberOfInspections];

        for (int i = 0; i < numberOfInspections-1 ; i++) {
            inspections[i] = randomInspectionDTO(regNo);
        }
        return new InspectionChecklist(inspections);

    }

    /**
     * Randomly generates a cost from 49.99 to 999.99 in increments of 50.
     * @return The randomly generated cost.
     */
    private double randomCost(){
        return 49.99+(50*r.nextInt(19));
    }

    /**
     * Randomly generates a potential part to be .
     * @return A random member of the <code>possibleParts</code> array.
     */
    private String randomPartToInspect(){
        return possibleParts[r.nextInt(5)];

    }

    /**
     * Randomly generates an <code>InspectionDTO</code>.
     * @return A randomly generated <code>InspectionDTO</code>.
     */
     InspectionDTO randomInspectionDTO(String regNo){
       return new InspectionDTO(randomPartToInspect(), randomCost(), false, regNo);
    }

    public void storeInspection(InspectionChecklist completedInspection){
        System.out.println("Inspection stored in database!");
    }
}
