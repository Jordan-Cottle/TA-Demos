import java.util.Scanner;
public class Driver{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        double real = getDouble("Enter the real component for a complex number: ");
        double imaginary = getDouble("Enter the imaginary component for a complex number: ");

        Complex c = new Complex(real, imaginary);

        System.out.println(c);
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