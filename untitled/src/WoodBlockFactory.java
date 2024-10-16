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
        if (intake instanceof Resource) { // If the Object is a valid Resource...
            if (((Resource) intake).getType() == ResourceType.WOOD) { //
                double availableResource = ((Resource) intake).getStoredWeight();
                System.out.println("AVAILABLE WOOD RESOURCE: " + availableResource);
                System.out.println("EXISTING WOOD INVENTORY");
                displayInventory();
                bin.modifyResource(availableResource);
                ((Resource) intake).modifyResource(-availableResource);
                System.out.println("UPDATED WOOD INVENTORY");
                displayInventory();
            //
            } else {//System.out.println("WoodBlockFactory.takeResource: Resource type mismatch");
            }

        } else if (intake == null) {
            //System.out.println("WoodBlockFactory.takeResource: Null resource");

        } else {
            //System.out.println("WoodBlockFactory.takeResource: Illegal resource type");
        }
    }

    public Block produce(){
        try {
            bin.modifyResource(-Const.WOOD_WEIGHT);
            System.out.println("WOOD BLOCK GENERATED");
            System.out.println("UPDATED STONE INVENTORY: ");
            displayInventory();
            return new WoodBlock();
        }
        catch (NegativeResource nr){
            //System.out.println(nr.getMessage());
        }
        return null;
    }

    public void displayInventory(){
        System.out.printf("%.2f\n", bin.getStoredWeight());
    }
}
