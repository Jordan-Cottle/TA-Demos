import java.util.Scanner;
public class Driver{
    /*
        This Scanner is a static member of the Driver class
        This allows us to create static helper functions that can all use the same Scanner
    */
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        // Call our helper function to get input from the user
        double real = getDouble("Enter the real component for a complex number: ");
        double imaginary = getDouble("Enter the imaginary component for a complex number: ");

        // Use the values we got to create a new Complex object
        Complex c = new Complex(real, imaginary);

        // Implicit call to c.toString();
        System.out.println(c);

        // Remember to close your scanners!
        in.close();
    }

    /**
     * Displays a prompt to the user and retrieves a double from stdin
     * @param prompt The message to display to the user
     * @return A double value entered by the user
     */
    private static double getDouble(String prompt){
        System.out.print(prompt);
        double value = in.nextDouble();

        return value;
    }
}