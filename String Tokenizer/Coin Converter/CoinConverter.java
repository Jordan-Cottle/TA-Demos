
/**
 * This CoinConverter takes in a number of copper coins and tells you how many higher valued coins they would be worth.
 * Since different games/kingdoms/countries/etc value different metals differently,
 * the class has a constructor that allows for the conversion ratios to be specified.
 * 
 * This class was designed to review concepts that were frequently missed on the Lab and Take Home Tests.
 * It covers the use of constants as well as some basic math to convert one measurement into another.
 * It also has javadoc comments on each method to describe what they do and demonstrate javadoc syntax.
 *
 * @author Jordan Cottle
 * @version 1.1
 */
public class CoinConverter
{
    // These fields hold equivalent measures of coins.
    // Each of these should represent the same amount of money
    private int copperCoins = 0;
    private int silverCoins = 0;
    private int goldCoins = 0;
    private int platinumCoins = 0;
    
    // These are constants that will be initialized in the constructor
    // Each object can have unique values for these constants, but they cannot change once the object is created
    private final int COPPER_PER_SILVER;
    private final int SILVER_PER_GOLD;
    private final int GOLD_PER_PLATINUM;

    /**
     * Constructor for objects of class CoinConverter. 
     * Provides default values for the conversion constants.
     * 
     * Copper -> Silver = 100 coins
     * Silver -> Gold = 10 coins
     * Gold -> Platinum = 5 coins
     * 
     * @param copper The number of copper coins to base our conversions off of
     */
    public CoinConverter(int copper)
    {   
        // Set constants to default values
        COPPER_PER_SILVER = 100;
        SILVER_PER_GOLD = 10;
        GOLD_PER_PLATINUM = 5;
        
        // Use set method to handle conversion
        setValue(copper);
    }
    
    /**
     * Constructor that allows for specifying different values for the constants.
     * 
     * @param copper The starting number of coins to convert
     * @param copperToSilver The number of copper coins it takes to equal one silver coin
     * @param silverToGold The number of silver coins it takes to equal one gold coin
     * @param goldToPlatinum The number of gold coins it takes to equal one platinum coin
     */
    public CoinConverter(int copper, int copperToSilver, int silverToGold, int goldToPlatinum){
        // Use provided values for the conversion constants
        COPPER_PER_SILVER = copperToSilver;
        SILVER_PER_GOLD = silverToGold;
        GOLD_PER_PLATINUM = goldToPlatinum;
        
        // Use set method to handle conversion
        setValue(copper);
    }
    
    /**
     * Set method to update the value of this CoinConverter.
     * This method only takes in a value for the number of copper coins.
     * 
     * @param copper The number of copper coins to base our conversions off of. Cannot be a negative value.
     */
    public void setValue(int copper){
        // Validate input
        if(copper < 0){
            // Print warning to user
            System.err.println("You can't enter a negative value of coins!");

            // End function early, do NOT continue to the lines below
            return;
        }
        
        // Set the new value into the field
        copperCoins = copper;
        
        // Update the other fields to keep my object consistent
        silverCoins = copperCoins / COPPER_PER_SILVER;
        goldCoins = silverCoins / SILVER_PER_GOLD;
        platinumCoins = goldCoins / GOLD_PER_PLATINUM;
    }
    
    /**
     * The toString method for the CoinConverter displays the number of coins of each type that would be worth the same.
     * 
     * @return A String containing all of the conversions calculated by this CoinConverter.
     */
    public String toString(){
        // Use String.format for a much cleaner way of producing a complex String.
        return String.format("Copper: %d\nSilver: %d\nGold: %d\nPlatinum: %d",
                // Each of the %d's above will be replaced with the respective values below
                // %d signifies a placeholder for an integer. %f works for floats/doubles and %s for other Strings
                    copperCoins,
                    silverCoins,
                    goldCoins,
                    platinumCoins);
    }
}






