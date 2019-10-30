public class Driver{
    public static void main(String[] args) {
        Customer[] customers = new Customer[2];

        customers[0] = new Customer("123", "Joe Bob");
        customers[1] = new Customer("321", "Jane Doe");

        Invoice[] invoices = new Invoice[3];
        invoices[0] = new Invoice("12345", "Eggs", 2.99, customers[0]);
        invoices[1] = new Invoice("12346", "Bacon", 4.99, customers[1]);
        invoices[2] = new Invoice("12345", "TV", 129.99, customers[0]);

        for(int i = 0; i < invoices.length; i++){
            System.out.println(invoices[i]);
        }

        for(int i = 0; i < invoices.length; i++){
            for(int j = i; j < invoices.length; j++){
                Invoice a = invoices[i];
                Invoice b = invoices[j];
                System.out.println(String.format("Invoice %s ($%.2f) compared to Invoice %s ($%.2f): %d", a.getId(), a.getAmount(), b.getId(), b.getAmount(), a.compareTo(b)));
                System.out.println(String.format("Invoice %s equals Invoice %s: %b", a.getId(), b.getId(), a.equals(b)));
                System.out.println();
                
            }
        }

        for(Customer c: customers){
            System.out.println(String.format("%s has a total balance of %.2f", c.getName(), c.totalDue()));
        }
    }
}