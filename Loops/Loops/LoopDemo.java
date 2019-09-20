import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * Write a description of class LoopDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoopDemo
{
    public static void main(String[] cheese) throws FileNotFoundException{
        int [] numbers = new int[10];// {1, 2, 3, 4, 5};

        Scanner in = new Scanner(System.in);

        File file = new File("numbers.txt");

        Scanner fileReader = new Scanner(file);

        // Put user input into array
        for(int i =0; i < numbers.length; i++){
            // Get a number from the user
            System.out.println("Enter a number: ");
            int num1 = in.nextInt();

            // Get a number from the file
            int num2 = fileReader.nextInt();
            System.out.println("Adding " + num2 + " to your number!");

            numbers[i] = num1 + num2;
        }
        in.close();
        fileReader.close();

        //Print contents of array and write to file
        File outputFile = new File("abcdefghijklmopqrstuvwxyz.alphabet");
        PrintWriter writer = new PrintWriter(outputFile);
        for(int i =0; i < numbers.length; i++){
            writer.println("Index " + i + " = " + numbers[i]);
        }
        writer.close();

        int product = 1;
        for(int i =0; i < numbers.length; i++){
            //product = product * numbers[i];
            product *= numbers[i];
        }

        System.out.println("The product is " + product); 

        for(int i = 1; i < 15; i++){
            System.out.println("The factorial of " + i +" is " + factorial(i));
        }
    }

    public static int factorial(int n){
        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }

        return result;
    }

}








