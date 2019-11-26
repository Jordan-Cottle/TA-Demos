import java.util.Scanner;

public class Hero extends Fighter{
    // Scanner to handle player input
    private static Scanner in = new Scanner(System.in);

    /**
     * Constructs a Hero for the player to control
     * @param name The name of the Hero
     * @param hp The starting and maximum health of the Hero
     * @param atk The amount of damage the Hero will do with each attack
     * @param def The amount of damage the Hero will absorb when they are attacked
     */
    public Hero(String name, int hp, int atk, int def){
        // Call parent constructor to set up values
        super(name, hp, atk, def);
    }

    protected int makeDecision(){
        System.out.println(this);
        System.out.println("1: Attack");
        System.out.println("2: Defend");

        System.out.print("Enter your choice: ");
        String choice = in.nextLine();

        // Parse choice and return one of the Fighter constants.
        switch(choice){
            case "1":
            case "Attack":
            case "attack":
                return Fighter.ATTACK;
            case "2":
            case "Defend":
            case "defend":
                return Fighter.DEFEND;
            default:
                System.out.println("Sorry, choice not recognized! Please try again!");
                return makeDecision();
        }
    }
}