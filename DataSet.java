
/**
 * Class to represent a set of numbers.
 * 
 * This class will also contain a set of functions that can be used to analyze the data in the data set.
 * 
 * @author Jordan Cottle
 * @version 9/11/2019
 */
public class DataSet{
    double[] numbers;

    /**
     * Creates a new DataSet from an array of numbers
     */
    public DataSet(double[] data){
        this.numbers = data;
    }

    /**
     * Calculates the total sum of all values in this DataSet
     * 
     * @return The total sum of all data values in this DataSet
     */
    public double calcTotal(){
        double total = 0;

        // Standard for loop
        for(int i = 0; i < this.numbers.length; i++){
            total += this.numbers[i];
        }

        total = 0;
        // Or use enhanced for loop
        for(double number: numbers){
            total += number;
        }

        return total;
    }

    /**
     * Calculates the mean of this DataSet
     * 
     * @return The average, or mean, of the data in this DataSet
     */
    public double calcAverage(){
        double average = this.calcTotal() / this.numbers.length;

        return average;
    }
}