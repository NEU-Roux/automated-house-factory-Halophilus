/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public enum ResourceType {
    // Repository of ResourceType data
    // Public static final ResourceType STONE = new ResourceType(5.5);
    STONE(Const.STONE_WEIGHT, "Stone", 1, false),
    WOOD(Const.WOOD_WEIGHT, "Wood", 0.5,false),

    // Crafted ResourceTypes
    HOUSE(STONE.weight * Const.WOOD_IN_HOUSE
               + WOOD.weight * Const.STONE_IN_HOUSE,
                "House",
        STONE.weight * Const.STONE_IN_HOUSE //
                    / (STONE.weight * Const.STONE_IN_HOUSE + WOOD.weight * Const.WOOD_IN_HOUSE),
    true);

    private final double weight;
    private final String name;
    private final double breakdownFactor;
    private boolean crafted;

    ResourceType(double weight, String name, double breakdownFactor, boolean crafted) {
        this.weight = weight;
        this.name = name;
        this.breakdownFactor = breakdownFactor;
        this.crafted = crafted;
    }

    // Getters for ResourceType fields
    public double getWeight() {return this.weight;}
    public String getName() {return this.name;}

    @Override
    public String toString() {
        return getName();
    }
}

