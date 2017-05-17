package Projects.View;

import Projects.Controller.InspectionResultsObserver;

/**
 * Keeps track of and prints out the number of passed and failed inspections.
 */
public class InspectionStatsView implements InspectionResultsObserver {
    private int passedInspections = 0;
    private int failedInspections = 0;

    private void printResults(){
        System.out.println("-------------------------------\nNumber of passed inspections: "+passedInspections+"\nNumber of failed inspections: "+failedInspections+"\n-------------------------------");
    }

    /**
     * Increases the number of passed inspections by 1.
     */
    public void reportSuccess(){
        passedInspections++;
    }

    /**
     * Increases the number of failed inspections by 1.
     */
    public void reportFailure(){
        failedInspections++;
    }

    /**
     * Informs the observer whether the inspection passed or failed.
     * @param isPassed Whether the inspection passed or failed.
     */
    @Override
    public void newResult(boolean isPassed) {

        if(isPassed)
            passedInspections++;

        else
            failedInspections++;

        printResults();
    }

}
