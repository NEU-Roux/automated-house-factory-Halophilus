/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public class StoneBlock extends Block {
    public StoneBlock() {
        super(ResourceType.STONE, Const.STONE_WEIGHT);
    }

    public Resource breakBlock() {
        return new Resource(getResourceType(), getUnitWeight());
    }
}
