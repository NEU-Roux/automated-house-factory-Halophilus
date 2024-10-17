import java.util.ArrayList;

public class HouseFactory implements Factory{
    public int stoneBlocks;
    public int woodBlocks;

    public HouseFactory() {
        stoneBlocks = 0;
        woodBlocks = 0;
    }

    // TakeResource where a block is taken
    public boolean takeResource(Object intake) {
        if (intake instanceof Block intakeBlock) { //
            if (intakeBlock.getResourceType()==ResourceType.STONE) {
                stoneBlocks++;
            } else if (intakeBlock.getResourceType()==ResourceType.WOOD) {
                woodBlocks++;
            }
        } else if (intake == null) {
            //System.out.println("WoodBlockFactory.takeResource: Null resource");
        } else {
            //System.out.println("WoodBlockFactory.takeResource: Illegal resource type");
        }
        return false;
    }

    // Implementation for handling list of raw material.
    @Override
    public ArrayList<Resource> takeResource(ArrayList<Resource> resources) {
        return null;
    }

    public Block produce(){
        if (stoneBlocks >= Const.STONE_IN_HOUSE && woodBlocks >= Const.WOOD_IN_HOUSE) {
            stoneBlocks -= Const.STONE_IN_HOUSE;
            woodBlocks -= Const.WOOD_IN_HOUSE;
            return new Block(ResourceType.HOUSE);
        }
        return null;
    }

    public void displayInventory(){
        System.out.println("Stone blocks: " + stoneBlocks + "\n" + "Wood blocks: " + woodBlocks);
    }
}


