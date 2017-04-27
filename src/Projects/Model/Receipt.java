package Projects.Model;


import Projects.Util.Amount;

public class Receipt {
    private Amount cost;
    private boolean approved;

    public Receipt(Amount cost, boolean approved){
        this.cost = cost;
        this.approved = approved;
    }

    public Amount getCost() {
        return cost;
    }

    public boolean getApproved(){
        return approved;
    }
}
