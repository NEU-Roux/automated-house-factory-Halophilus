/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */

//
public class ElementalFactory implements Factory{
    public Resource bin;
    public ResourceType resourceType;

    public ElementalFactory(ResourceType resourceType) {
        // New Resource delegate for accumulating storedWeight
        this.resourceType = resourceType;
        bin = new Resource(this.resourceType, 0);
    }

    // Flag for successful object intake
    public boolean takeResource(Object intake){
        return bin.takeResource(intake);
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
