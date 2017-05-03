package Projects.Model;

/**
 * Contains information about the payment and <code>PaymentAuthorization</code> to be printed on the <code>Printer</code>.
 */
public class Receipt {
    private double cost;
    private boolean approved;

    public Receipt(double cost, boolean approved) {
        this.cost = cost;
        this.approved = approved;
    }

    /**
     * @return The <code>cost</code> of the full inspection.
     */
    public double getCost() {
        return cost;
    }

    /**
     * @return Whether the payment was <code>approved</code>.
     */
    public boolean getApproved() {
        return approved;
    }
}
