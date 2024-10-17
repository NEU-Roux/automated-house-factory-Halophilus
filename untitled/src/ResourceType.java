import java.util.HashMap;
import java.util.Map;

/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public enum ResourceType {
    // Repository of ResourceType data
    // Public static final ResourceType STONE = new ResourceType(5.5);
    STONE(Const.STONE_WEIGHT, "Stone", Const.STONE_RETURN),
    WOOD(Const.WOOD_WEIGHT, "Wood", Const.WOOD_RETURN),

    // Crafted ResourceTypes
    HOUSE(Const.HOUSE_WEIGHT, "House", Const.HOUSE_RETURN);

    private final double weight;
    private final String name;
    private final Map<ResourceType, Double> yields;


    ResourceType(double weight, String name, Map<ResourceType, Double> yields) {
        this.weight = weight;
        this.name = name;
        this.yields = yields;
    }
    // Getters for ResourceType fields
    public double getWeight() {return this.weight;}
    public String getName() {return this.name;}
    public Map<ResourceType, Double> getYields() {return yields;}

    @Override
    public String toString() {
        return getName();
    }


}

