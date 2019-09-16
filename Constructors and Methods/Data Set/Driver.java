import java.util.Scanner;
/**
 * Write a description of class Driver here.
 *
 * @author Jordan Cottle
 * @version 9/4/2019
 */
public class Driver
{
    private static final int COUNT = 5;
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){    
        DataSet data = makeDataSet(COUNT);
        System.out.println(data.getTotal());
    }
    
    /**
     * Creates a DataSet object of a specified size using numbers entered by the user
     * 
     * @param size The number of numbers to include in the DataSet
     * 
     * @return A DataSet object created with size elements provided by the user
     */
    private static DataSet makeDataSet(int size){
        double[] numbers = new double[size];
        for(int i = 0; i < numbers.length; i++){
           numbers[i] = getDouble("Enter a number: ");
        }
        
        return new DataSet(numbers);
    }
    
    /**
     * Gets a double from stdin
     * 
     * @param prompt The message to display to the user
     * 
     * @return A double value read in from standard input
     */
    private static double getDouble(String prompt){
        System.out.print(prompt);
        double value = in.nextDouble();
        in.nextLine();
        return value;
    }
    
    /**
     * Gets an integer from stdin
     * 
     * @param prompt The message to display to the user
     * 
     * @return An integer value read in from standard input
     */
    private static int getInt(String prompt){
        System.out.print(prompt);
        int value = in.nextInt();
        in.nextLine();
        return value;
    }
}



















