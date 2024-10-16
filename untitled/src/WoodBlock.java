/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public class WoodBlock extends Block {
    public WoodBlock() {
        super(ResourceType.WOOD, Const.WOOD_WEIGHT);
    }

    public Resource breakBlock(){
        return new Resource(getResourceType(), getUnitWeight() * 0.5);
    }
}
