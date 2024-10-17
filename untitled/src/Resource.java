import java.util.ArrayList;

/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public class Resource {
    private double storedWeight;
    private ResourceType resourceType;

    public Resource(ResourceType resourceType) {
        setResourceType(resourceType);
        setStoredWeight(0);
    }

    public Resource(ResourceType resourceType, double storedWeight) {
        this(resourceType);
        setStoredWeight(storedWeight);
    }

    // Access/mutators for storedWeight
    public double getStoredWeight() {
        return storedWeight;
    }

    private void setStoredWeight(double storedWeight) throws NegativeResource {
        if (storedWeight >= 0) {
            this.storedWeight = storedWeight;
        } else {
            throw new NegativeResource("The stored weight cannot be negative.");
        }

    }

    // Access/mutators for resourceType
    public ResourceType getType() {
        return resourceType;
    }

    private void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    // Function for modifying resource quantities
    public void modifyResource(double resourceAmount) throws NegativeResource {
        resourceAmount += getStoredWeight();
        if (resourceAmount >= 0) {
            setStoredWeight(resourceAmount);
        } else {
            throw new NegativeResource("The stored weight cannot be negative.");
        }
    }

    // takeResource refactored to the Resource parent class
    // Takes Resource and transfers value to current instance
    public ArrayList<Resource> takeResource(ArrayList<Resource> resources) {
        for (Resource resource : resources) { // For all of the
            if (this.getType() == resource.resourceType) { // And its of the appropriate type...
                double availableResource = resource.getStoredWeight();
                this.modifyResource(availableResource); // Increment local storage
                resource.modifyResource(-availableResource); // Subtract it from the target Resource
            }
        }
        return resources;
    }
}
