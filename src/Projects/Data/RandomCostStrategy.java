package Projects.Data;

import java.util.Random;
/**
 * The standard strategy that randomly generates a cost between 49.99 and 999.99.
 */
public class RandomCostStrategy implements CostCalculationStrategy{
    private Random r = new Random();
    /**
     * Calculates the cost.
     * @return The cost of inspecting this part.
     */
    @Override
    public double calculateCost() {
        return 49.99 + (50 * r.nextInt(19));
    }
}
