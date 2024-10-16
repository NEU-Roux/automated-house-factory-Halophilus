/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public class WoodBlockFactory implements Factory{
    public Resource bin;
    public WoodBlockFactory() {
        bin = new Resource(ResourceType.WOOD, 0);
    }

    public void takeResource(Object intake) {
        if (intake instanceof Resource) {
            if (((Resource) intake).getType() == ResourceType.WOOD) {
                double availableResource = ((Resource) intake).getStoredWeight();
                bin.modifyResource(availableResource);
                ((Resource) intake).modifyResource(-availableResource);
            } else {System.out.println("WoodBlockFactory.takeResource: Resource type mismatch");}
        } else if (intake == null) {
            System.out.println("WoodBlockFactory.takeResource: Null resource");
        } else {
            System.out.println("WoodBlockFactory.takeResource: Illegal resource type");
        }
    }

    public Block produce(){
        try {
            bin.modifyResource(-Const.WOOD_WEIGHT);
            return new WoodBlock();
        }
        catch (NegativeResource nr){System.out.println(nr.getMessage());}
        return null;
    }

    public void displayInventory(){
        System.out.printf("%.2f\n", bin.getStoredWeight());
    }
}
