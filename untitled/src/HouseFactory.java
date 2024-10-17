public class HouseFactory implements Factory{
    public int stoneBlocks;
    public int woodBlocks;
    public HouseFactory() {
        stoneBlocks = 0;
        woodBlocks = 0;
    }

    public boolean takeResource(Object intake) {
        if (intake instanceof Block) {
            if (((Block) intake).getResourceType() == ResourceType.STONE) {
                stoneBlocks++;
            } else if (((Block) intake).getResourceType() == ResourceType.WOOD) {
                woodBlocks++;
            }
        } else if (intake == null) {
            //System.out.println("WoodBlockFactory.takeResource: Null resource");
        } else {
            //System.out.println("WoodBlockFactory.takeResource: Illegal resource type");
        }
        return false;
    }

    public Block produce(){
        if (stoneBlocks >= Const.STONE_IN_HOUSE && woodBlocks >= Const.WOOD_IN_HOUSE) {
            stoneBlocks -= Const.STONE_IN_HOUSE;
            woodBlocks -= Const.WOOD_IN_HOUSE;
            return new HouseBlock();
        }
        return null;
    }

    public void displayInventory(){
        System.out.println("Stone blocks: " + stoneBlocks + "\n" + "Wood blocks: " + woodBlocks);
    }
}


