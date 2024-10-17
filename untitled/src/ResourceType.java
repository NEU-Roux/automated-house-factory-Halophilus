/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public enum ResourceType {
    // Repository of ResourceType data
    // Public static final ResourceType STONE = new ResourceType(5.5);
    STONE(5.5, "Stone"),
    WOOD(2.5, "Wood"),

    // Crafted ResourceTypes
    HOUSE(STONE.weight*Const.WOOD_IN_HOUSE
               + WOOD.weight*Const.STONE_IN_HOUSE,
                "House");

    private final double weight;
    private final String name;

    ResourceType(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    // Getters for ResourceType fields
    public double getWeight() {return this.weight;}
    public String getName() {return this.name;}

    @Override
    public String toString() {
        return getName();
    }
}

