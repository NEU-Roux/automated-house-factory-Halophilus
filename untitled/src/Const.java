import java.util.HashMap;
import java.util.Map;

/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
// A static, final repository for global variables
public final class Const {
    // Block weights
    public static final double STONE_WEIGHT = 5.5;
    public static final double WOOD_WEIGHT = 2.5;

    // House recipe info
    public static final int WOOD_IN_HOUSE = 10;
    public static final int STONE_IN_HOUSE = 4;
    public static final double HOUSE_WEIGHT = STONE_WEIGHT * STONE_IN_HOUSE + WOOD_WEIGHT * WOOD_IN_HOUSE;

    // Return recipe map ResourceType to return Resource storedWeight
    // Allows for dynamic returns from block breaks
    public static Map<ResourceType, Double> HOUSE_RETURN = new HashMap<ResourceType, Double>();
    public static Map<ResourceType, Double> STONE_RETURN = new HashMap<ResourceType, Double>();
    public static Map<ResourceType, Double> WOOD_RETURN = new HashMap<ResourceType, Double>();

    static {
        HOUSE_RETURN.put(ResourceType.STONE, STONE_IN_HOUSE * STONE_WEIGHT);
        STONE_RETURN.put(ResourceType.STONE, STONE_WEIGHT);
        WOOD_RETURN.put(ResourceType.WOOD, STONE_WEIGHT);
    }


}
