/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */

//
public class WoodBlockFactory implements Factory{
    public Resource bin;
    public ResourceType resourceType;

    public WoodBlockFactory() {
        // New Resource delegate for accumulating storedWeight
        bin = new Resource(ResourceType.WOOD, 0);
    }

    public boolean takeResource(Object intake){

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
