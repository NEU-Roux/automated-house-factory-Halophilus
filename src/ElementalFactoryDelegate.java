import java.util.ArrayList;

/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */

// Delegate class for WoodBlockFactory and StoneBlockFactory
public class ElementalFactoryDelegate implements Factory{
    // Delegate for handling Factory behaviors for elemental ResourceTypes
    public Resource bin;
    public ResourceType resourceType;

    public ElementalFactoryDelegate(ResourceType resourceType) {
        // New Resource delegate for accumulating storedWeight
        this.resourceType = resourceType;
        bin = new Resource(this.resourceType, 0);
    }

    // Processes list of Resources and extracts storedWeight from matching ResourceTypes
    public ArrayList<Resource> takeResource(ArrayList<Resource> resources){
        return bin.takeResource(resources);
    }

    // Produces Blocks of local ResourceType, null default if insufficient resources are present
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

    // Displays storedWeight
    public void displayInventory(){
        System.out.printf("%.2f\n", bin.getStoredWeight());
    }
}
