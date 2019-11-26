import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Driver{
    private static String[] enemyData;
    public static void main(String[] args) {
        // First load enemy data into memory from the file
        String fileName = "enemyData.txt";
        File data = new File(fileName);

        Scanner dataReader;
        try{
            dataReader = new Scanner(data);
        }catch (FileNotFoundException e){
            System.err.println("Oops, couldn't find the file!");
            System.err.printf("Please make sure that %s is available and try again.", fileName);
            return;
        }

        enemyData = new String[countLines(fileName)];

        for(int i = 0; i < enemyData.length; i++){
            enemyData[i] = dataReader.nextLine();
        }
        dataReader.close();

        // Next build an array of enemies from the data
        Enemy[] enemies = new Enemy[enemyData.length];

        for(int i = 0; i < enemies.length; i++){
            enemies[i] = buildEnemy(i);
        }

        Scanner in = new Scanner(System.in);

        // Get a name for the hero
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        in.close();

        // Create the hero
        Hero hero = new Hero(name, 100, 10, 3);

        // Start the journey!
        System.out.println("Welcome to the arena! You have many foes waiting for you.");

        // Battle each enemy in the sequence
        for(int i = 0; i < enemies.length; i++){
            System.out.printf("%s approaches!", enemies[i].toString());
            hero.battle(enemies[i]);

            if(!hero.alive()){
                System.out.println("You have been defeated!");
                return;
            }
        }

        // The dragon should kill the hero for sure
        System.out.println("Wow, you've defeated all of my minions!");
        System.out.println("You weren't supposed to make it this far...");
        
        // Unless a clever player modifies the enemy data file....
    }

    /**
     * Builds an enemy from the data read in from the files
     * 
     * @param type The index of the enemy in the data file
     * @return A new Enemy object using the parameters from the data file
     */
    private static Enemy buildEnemy(int type){
        String data = enemyData[type];

        StringTokenizer tokenizer = new StringTokenizer(data);

        String name = tokenizer.nextToken();
        int hp = Integer.parseInt(tokenizer.nextToken());
        int atk = Integer.parseInt(tokenizer.nextToken());
        int def = Integer.parseInt(tokenizer.nextToken());

        return new Enemy(name, hp, atk, def);
    }

    /**
     * Counts the number of lines in a file by opening it and skipping over the lines
     * 
     * @param fileName The path to the file to count
     * @return The number of lines in the specified file
     */
    private static int countLines(String fileName){
        File data = new File(fileName);

        Scanner dataReader;
        try{
            dataReader = new Scanner(data);
        }catch (FileNotFoundException e){
            System.err.println("Oops, couldn't find the file!");
            System.err.printf("Please make sure that %s is available and try again.", fileName);
            return 0;
        }

        int count = 0;
        while(dataReader.hasNext()){
            dataReader.nextLine();
            count++;
        }

        dataReader.close();
        return count;
    }
}