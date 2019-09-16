/**
 * A class to represent a Complex number
 *
 * @author Jordan Cottle
 * @version 9/6/2019
 */
public class Complex
{
    private final double realComponent;
    private final double complexComponent;
    
    /**
     * Creates a new Complex number from a real and imaginary component.
     * 
     * @param real The real portion of a Complex number
     * @param imaginary The imaginary component of a Complex number
     */
    public Complex(double real, double imaginary){
        this.realComponent = real;
        this.complexComponent = imaginary;
    }
    
    /**
     * Calculates the mean, or average, value of this DataSet
     * 
     * @return The mean of this DataSet
     */
    public String toString(){
        return "" + realComponent + " + " + complexComponent + "i";
    }
}
