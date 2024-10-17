/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */

//
public class ElementalFactoryDelegate implements Factory{
    // Delegate for handling Factory behaviors for elemental ResourceTypes
    public Resource bin;
    public ResourceType resourceType;

    public ElementalFactoryDelegate(ResourceType resourceType) {
        // New Resource delegate for accumulating storedWeight
        this.resourceType = resourceType;
        bin = new Resource(this.resourceType, 0);
    }

    // Flag for successful object intake
    public boolean takeResource(){
        return bin.takeResource(intake);
    }

    //
    // Produces Blocks of local ResourceType, null default
    public Block produce(){
        try {
            bin.modifyResource(-resourceType.getWeight());

            return new Block(resourceType);
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
