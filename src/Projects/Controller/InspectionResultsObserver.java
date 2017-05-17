package Projects.Controller;

/**
 * An interface for an observer that receives a boolean.
 */
public interface InspectionResultsObserver {

void newResult(boolean isPassed);
}
