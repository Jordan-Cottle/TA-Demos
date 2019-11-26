public abstract class Fighter{
    // Fields to hold information about a generic Fighter
    private String name;
    private int currHp;
    private int maxHp;
    private int attack;
    private int defense;

    // Fields to represent various states and information for a battle
    private boolean stunned;
    private boolean defending;
    private Fighter target;

    protected static final int ATTACK = 0;
    protected static final int DEFEND = 1;

    /**
     * Builds a fighter with a name, hp, atk, and defense value.
     * @param name The name of the Fighter
     * @param hp The starting and max health of the Fighter
     * @param atk The amount of damage the Fighter will do with each attack
     * @param def The amount of damage the Fighter will absorb each time they are attacked
     */
    public Fighter(String name, int hp, int atk, int def){
        this.name = name;
        this.currHp = hp;
        this.maxHp = hp;
        this.attack = atk;
        this.defense = def;

        this.stunned = false;
        this.defending = false;
    }

    /**
     * Checks if this Fighter is still alive or not
     * @return True if this Fighter is alive, False if they are not.
     */
    public boolean alive(){
        return this.currHp > 0;
    }

    /**
     * This method will simulate a battle between two Fighters. 
     * This method should be invoked on the Fighter who will go first in combat.
     * @param other The other Fighter this Fighter will battle
     * @return True if this fighter wins the battle, False if the other fighter won.
     */
    public boolean battle(Fighter other){
        System.out.printf("%s vs %s\n", this.name, other.name);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        int count = 1;
        while(this.alive() && other.alive()){
            System.out.println("Round " + count++);

            // Handle skipping turn if stunned
            if(this.stunned){
                System.out.println(name + " is stunned!");
                this.stunned = false;
            }else{
                int decision = this.makeDecision();
                this.performAction(decision);
            }

            // Check if other Fighter has died
            if(!other.alive()){
                System.out.println(other.name + " has died!");
                return true;
            }

            // Handle skipping turn if stunned
            if(other.stunned){
                System.out.println(other.name + " is stunned!");
                other.stunned = false;
            }else{
                int decision = other.makeDecision();
                other.performAction(decision);
            }

            System.out.println();
        }

        if(!this.alive()){
            System.out.println(name + " has died!");
        }

        return this.alive();
    }

    /**
     * Performs an attack from this Fighter on the other Fighter. 
     * 
     * If the other Fighter's defense is higher than this fighter's damage this fighter will be stunned.
     * 
     * @param other The Fighter that this one will attack
     * @return True if the attack lands, False if it misses or is blocked.
     */
    private boolean attack(Fighter other){
        int dmg = this.attack - other.getDefense();

        // If attack fails, apply stun and return without doing damage
        if(dmg < 0){
            System.out.println("The attack has no effect!");
            System.out.println(name + " is now stunned!");
            this.stunned = true;
            return false;
        }

        System.out.printf("%s attacks %s for %d damage!\n", this.name, other.name, dmg);
        other.currHp -= dmg;
        return true;
    }

    /**
     * Private 'get' method to handle calculating defense.
     * 
     * @return The amount of damage to mitigate when this Fighter is attacked
     */
    private int getDefense(){
        int def = this.defense;
        if(defending){
            def *= 2;
        }

        return def;
    }

    /**
     * Abstract method. All subclasses of this class that aren't also abstract must implement this method.
     * 
     * This method will be used to control the flow of a battle.
     *  Subclasses can implement this method however they want, but they must return and integer that this class will be expecting.
     * Expected values are enumerated above in the ATTACK and DEFEND constants.
     * @return One of the defined constants Fighter.ATTACK or Fighter.DEFEND
     */
    protected abstract int makeDecision();

    /**
     * Helper function to handle performing actions based on the choice provided by the abstract method.
     * 
     * @param choice The choice to be made, must be one of the predefined constants.
     */
    private void performAction(int choice) throws IllegalArgumentException{
        // Reset the defending flag
        this.defending = false;

        // Perform action based on choice
        switch(choice){
            case ATTACK:
                this.attack(target);
                break;
            case DEFEND:
                this.defending = true;
                break;
            default:
                // Throw an exception with a custom message to force other programmers to use the constants
                throw new IllegalArgumentException("Choice not recognized! Please use one of the predefined constants!");
        }
    }

    /**
     * @return A String that can be used to identify this Fighter.
     */
    public String toString(){
        return String.format("%s (HP: %d, ATK: %d, DEF: %d)",
                             name, currHp, attack, defense);
    }
}