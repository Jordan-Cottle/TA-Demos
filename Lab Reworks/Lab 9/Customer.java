import java.util.Arrays;

public class Customer{
    private String lastName;
    private String firstName;
    private String id;
    private Invoice[] invoices = new Invoice [5];
    private int invoiceCount = 0;

    public Customer(){

    }

    public Customer(String id, String name){
        this.id = id;


        String [] names = name.split(" ", 2);
        this.firstName = names[0];
        this.lastName = names[1];
    }

    public Customer(String id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(Customer source){
        this.id = source.id;
        this.firstName = source.firstName;
        this.lastName = source.lastName;

        // Shallow copy of invoices
        this.invoices = source.invoices;
    }

    public String toString(){
        return String.format("ID: %s\nName: %s, %s",
                            id, lastName, firstName);
    }

    private static Invoice[] resize(Invoice[] Invoices, double multiple){
        int newSize = (int) (Invoices.length * multiple);

        Invoice[] result = new Invoice[newSize];

        for(int i = 0; multiple >= 1 ? i < Invoices.length: i < newSize; i++){
            result[i] = Invoices[i];
        }

        return result;
    }

    public void addInvoice(Invoice newInvoice){
        if (this.invoiceCount == invoices.length-1){
            this.invoices = resize(this.invoices, 2);
        }

        this.invoices[this.invoiceCount++] = newInvoice;
    }

    public double totalDue(){
        double total = 0;
        for(int i = 0; i < this.invoiceCount; i++){
            total += this.invoices[i].getAmount();
        }

        return total;
    }

    public String getName(){
        return String.format("%s %s", firstName, lastName);
    }
}