import java.util.ArrayList;

/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
// Custom implementation of Factory for crafted items
public class HouseFactory implements Factory{
    public int stoneBlocks;
    public int woodBlocks;

    // Defaults to no starting resources
    public HouseFactory() {
        stoneBlocks = 0;
        woodBlocks = 0;
    }

    // TakeResource where a block is taken, boolean success flag for future functionality
    public boolean takeResource(Object intake) {
        if (intake instanceof Block intakeBlock) { //
            if (intakeBlock.getResourceType()==ResourceType.STONE) {
                stoneBlocks++;
                return true;
            } else if (intakeBlock.getResourceType()==ResourceType.WOOD) {
                woodBlocks++;
                return true;
            }
        } else if (intake == null) {
            return false;
            //System.out.println("WoodBlockFactory.takeResource: Null resource");
        } else {
            return false;
            //System.out.println("WoodBlockFactory.takeResource: Illegal resource type");
        }
        return false;
    }

    // Implementation for handling list of raw material.
    @Override
    public ArrayList<Resource> takeResource(ArrayList<Resource> resources) {
        return null;
    }

    // Attempts to generate house block
    public Block produce(){
        // If there are enough blocks
        if (stoneBlocks >= Const.STONE_IN_HOUSE && woodBlocks >= Const.WOOD_IN_HOUSE) {
            stoneBlocks -= Const.STONE_IN_HOUSE;
            woodBlocks -= Const.WOOD_IN_HOUSE;
            return new Block(ResourceType.HOUSE);
        }
        return null;
    }

    // Displays int STONE and WOOD block quantities
    public void displayInventory(){
        System.out.println("Stone blocks: " + stoneBlocks + "\n" + "Wood blocks: " + woodBlocks);
    }
}


