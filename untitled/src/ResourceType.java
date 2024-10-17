/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public enum ResourceType {
    STONE(5.5),
    WOOD(2.5),
    HOUSE(STONE.weight*Const.WOOD_IN_HOUSE
               + WOOD.weight*Const.STONE_IN_HOUSE);

    private final double weight;
    ResourceType(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return this.weight;
    }
}
