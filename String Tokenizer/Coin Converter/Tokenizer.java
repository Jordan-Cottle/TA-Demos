import java.io.File;
import java.io. IOException;

import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * Uses the StringTokenizer to read data from a comma separated values (CSV) file.
 * 
 * This demo introduces the new concepts (the StringTokenizer) covered in the lab.
 * It also uses the CoinConverter object that was built to cover commonly missed concepts on the recent Lab and Take Home Tests.
 *
 * @author Jordan Cottle
 * @version 1.1
 */
public class Tokenizer
{
    // constant to represent number of line in my text file
    private static final int NUM_CONVERTERS = 3;
   public static void main(String [] cheese) throws IOException{
       // Grab reference to text file that contains the conversion data
       File conversionFile = new File("conversions.txt");
       
       // Create scanner to read file
       Scanner fileReader = new Scanner(conversionFile);

       // Create an array of CoinConverters, one for each line in the file
       CoinConverter[] converters = new CoinConverter[NUM_CONVERTERS];

       for (int i = 0; i < NUM_CONVERTERS; i++){ // Read file contents
            // Get next line from my text file
           String line = fileReader.nextLine();
           
           // Tokenize the line of input
           StringTokenizer tokens = new StringTokenizer(line);
           
           // Pull tokens out of tokenizer and convert to integers
           int copper = Integer.parseInt(tokens.nextToken());
           int copperToSilver = Integer.parseInt(tokens.nextToken());
           int silverToGold = Integer.parseInt(tokens.nextToken());
           int goldToPlatinum = Integer.parseInt(tokens.nextToken());
           
           // Use the data gathered above to create a new CoinConverter
           // Also stores the new CoinConverter in the array to read from it later
           converters[i] = new CoinConverter(
                                       copper,
                                       copperToSilver,
                                       silverToGold,
                                       goldToPlatinum
                                   );
        }

        // Done reading from file, close scanner
        fileReader.close();
        
        // Go through the array of CoinConverters and print each one
        for(int i = 0; i < NUM_CONVERTERS; i++){
            // Print the CoinConverter by using its toString method implicitly
            System.out.println(converters[i]);
            // Separate each CoinConverter with a line to see them better
            System.out.println("---------------------------");
        }
    }
}
