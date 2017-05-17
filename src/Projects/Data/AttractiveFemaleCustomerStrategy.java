package Projects.Data;

/**
 * A strategy that sets the price of each partial inspection to 1.
 */

public class AttractiveFemaleCustomerStrategy implements CostCalculationStrategy{
    /**
     * Calculates the cost.
     * @return The cost of inspecting this part.
     */
    @Override
    public double calculateCost() {
        return 1.0;
    }
}
