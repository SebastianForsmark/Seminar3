package Projects.Data;

/**
 * An interface for different ways of calculating the cost of each individual inspection.
 */
public interface CostCalculationStrategy {
    /**
     * Calculates the cost.
     * @return The cost of inspecting this part.
     */
    double calculateCost();
}
