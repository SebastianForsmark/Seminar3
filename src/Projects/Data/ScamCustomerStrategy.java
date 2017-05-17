package Projects.Data;

/**
 * A strategy that sets the price to maximum for each inspection.
 */

public class ScamCustomerStrategy implements CostCalculationStrategy{
    /**
     * Calculates the cost.
     * @return The cost of inspecting this part.
     */
    @Override
    public double calculateCost() {
        return 999.99;
    }
}
