import java.util.ArrayList;
import java.util.Map;

/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
// Now a generic object
 public class Block {
    // Singular class for all variations of the Block object
    private ResourceType resourceType;
    private boolean broken;// Default false

    // Standard constructor
    public Block(ResourceType resourceType) {
        setResourceType(resourceType);
    }

    // resourceType getters and setters
    public ResourceType getResourceType() {return resourceType;}
    public void setResourceType(ResourceType resourceType) {this.resourceType = resourceType;}

    // broken Block functionality
    public boolean isBroken() {return broken;}
    private void setBroken() {this.broken = true;}

    // breakBlock method
    public ArrayList<Resource> breakBlock(){
        if (!broken){ // If the block isn't broken
            ArrayList<Resource> resources = new ArrayList<>();
            for (Map.Entry<ResourceType, Double> entry : resourceType.getYields().entrySet()){
                resources.add(new Resource(entry.getKey(), entry.getValue()));
            } // Get the yields for the specific resourceType
            setBroken(); // Formally break the block
            return resources; // Return list of Resources yielded from the broken Block
        } else { return null; }
    }

    // toString override
    @Override
    public String toString() {
        String weight = String.format("%.2f", resourceType.getWeight());
        return resourceType + "block, weight: " + weight;
    }
}
