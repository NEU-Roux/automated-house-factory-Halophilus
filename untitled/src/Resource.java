/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public abstract class Resource {
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

    private void setStoredWeight(double storedWeight) throws NegativeResource{
        if (storedWeight > 0) {this.storedWeight = storedWeight;}
        else {throw new NegativeResource("The stored weight cannot be negative.");}

    }

    // Access/mutators for resourceType
    public ResourceType getResourceType() {return resourceType;}
    private void setResourceType(ResourceType resourceType) {this.resourceType = resourceType;}

    // Function for modifying resource quantities
    public void modifyResource(double resourceAmount){
        // resourceAmount can be positive or negative
        try { setStoredWeight(getStoredWeight() + resourceAmount); }
        catch (NegativeResource nr){
            System.out.println(nr.getMessage());
            System.out.println("Setting stored weight to zero.");
            setStoredWeight(0);
        }
    }
}
