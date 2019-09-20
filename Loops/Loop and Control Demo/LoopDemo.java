
/**
 * Write a description of class LoopDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoopDemo
{
    public static void main(String[] args){
        int [] numbers = {3, 5, 7, 8, 3, 9};
        
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]);
            
            System.out.print(" -> ");
            numbers[i] =(int) (Math.random()*25 + 1);
            
            System.out.println(numbers[i]);
        }
        
        int total = 0;
        int i = 0;
        while(i < numbers.length){
            int num = numbers[i];
            total = total + num;
            i++;
        }
        
        System.out.println("The total is : " + total);
    }
}










