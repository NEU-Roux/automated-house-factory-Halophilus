public class HouseBlock extends Block {
    public HouseBlock() {
        super(ResourceType.HOUSE, 0);
    }

    public Resource breakBlock() {
        return new Resource(ResourceType.STONE, Const.STONE_WEIGHT);
    }
}
