
/**
 * Write a description of class DataSet here.
 *
 * @author Jordan Cottle
 * @version 9/4/2019
 */
public class DataSet
{
    private final double [] numbers;
    
    private double total;
    
    /**
     * Creates a new DataSet from an array of doubles.
     * 
     * @param numbers An array of numbers to put into this DataSet
     */
    public DataSet(double [] numbers){
        this.numbers = numbers;
        
        double total = 0;
        for(double number: this.numbers){
            total += number;
        }
        
        this.total = total;
    }
    
    /**
     *  Gets the numbers stored in this DataSet
     *  
     *  @return The numbers stored in this DataSet
     */
    public double[] getNumbers(){
        return this.numbers;
    }
    
    /**
     * Calculates total of the numbers in this DataSet
     * 
     * @return The total of the numbers in this DataSet
     */
    public double getTotal(){
        return this.total;
    }
    
    /**
     * Calculates the mean, or average, value of this DataSet
     * 
     * @return The mean of this DataSet
     */
    public double calculateMean(){
        return getTotal() / numbers.length;
    }
}
