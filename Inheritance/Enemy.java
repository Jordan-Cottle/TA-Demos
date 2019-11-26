public class Enemy extends Fighter{

    // count and sequence for making decisions in battle
    private int count = 0;
    private int[] sequence = {
        Fighter.ATTACK,
        Fighter.ATTACK,
        Fighter.ATTACK,
        Fighter.DEFEND
    };

    /**
     * Builds an Enemy to battle against
     * @param name The name of the Enemy
     * @param hp The starting and max health of the Enemy
     * @param atk The amount of damage the Enemy does per attack
     * @param def The amount of damage the Enemy absorbs when they are attacked
     */
    public Enemy(String name, int hp, int atk, int def){
        // Call parent constructor
        super(name, hp, atk, def);
    }

    /**
     * Handles making battle decisions for the enemies.
     * 
     * Simply cycles through a predefined list of choices.
     * 
     * @return One of the Fighter constants representing a choice in battle. Repeats in a predefined cycle.
     */
    protected int makeDecision(){
        int decision = sequence[count++];

        if(count == sequence.length){
            count = 0;
        }

        return decision;
    }

}