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
    public double getStoredWeight() {return storedWeight;}

    private void setStoredWeight(double storedWeight) throws NegativeResource {
        if (storedWeight >= 0) {this.storedWeight = storedWeight;}
        else {throw new NegativeResource("The stored weight cannot be negative.");}

    }

    // Access/mutators for resourceType
    public ResourceType getType() {return resourceType;}
    private void setResourceType(ResourceType resourceType) {this.resourceType = resourceType;}

    // Function for modifying resource quantities
    public void modifyResource(double resourceAmount) throws NegativeResource{
        resourceAmount += getStoredWeight();
        if (resourceAmount >= 0) {setStoredWeight(resourceAmount);}
        else {throw new NegativeResource("The stored weight cannot be negative.");}
    }

    // takeResource refactored to the Resource parent class
    // Takes Resource and transfers value to current instance
    public boolean takeResource(Object intake) {
        if (intake instanceof Resource) { // If the Object is a valid Resource...
            if (((Resource) intake).getType() == this.getType()) { // And its of the appropriate type...
                double availableResource = ((Resource) intake).getStoredWeight();

                this.modifyResource(availableResource); // Increment local storage
                ((Resource) intake).modifyResource(-availableResource); // Subtract it from the target Resource

                return true;
            } else { // Resource ResourceType mismatch
                //System.out.println("WoodBlockFactory.takeResource: Resource type mismatch");
                return false;
            }

        } else if (intake == null) { // null Object passed to takeResource
            //System.out.println("WoodBlockFactory.takeResource: Null resource");
            return false;
        } else { // invalid Object passed
            //System.out.println("WoodBlockFactory.takeResource: Illegal object type");
            return false;
        }
    }
}
