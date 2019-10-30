public class Invoice{
    private String id;
    private String description;
    private double amount;
    private boolean isPaid;
    private Customer customer;

    public Invoice(){

    }

    public Invoice(String id, String description, double amount, Customer customer){
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.isPaid = false;
        this.customer = customer;

        this.customer.addInvoice(this);
    }

    public String toString(){
        String customerString = customer.toString();
        customerString = customerString.replaceAll("\n", "\n\t");
        
        return String.format("ID: %s\nDescription: %s\nAmount: %.2f\nCustomer:\n\t%s",
                            id, description, amount, customerString);
    }

    public int compareTo(Invoice other){
        if(this.amount > other.amount){
            return 1;
        }else if(this.amount < other.amount){
            return -1;
        }else{
            return 0;
        }
    }

    public boolean equals(Object o){
        if(!(o instanceof Invoice)){
            return false;
        }

        Invoice other = (Invoice) o;

        return this.id.equals(other.id);
    }

    public double pay(double amountPaid){
        if (amountPaid > this.amount){
            System.err.println("Customer has overpaid! Returning the change!");
            this.amount = 0;
            this.isPaid = true;
            return amountPaid - this.amount;
        }

        this.amount -= amountPaid;

        if(this.amount == 0){
            this.isPaid = true;
        }
        return 0;
    }

    public void setPaid(){
        this.isPaid = true;
    }

    public double getAmount(){
        return amount;
    }

    public String getId(){
        return this.id;
    }

    public boolean isPaid(){
        return this.isPaid;
    }
}