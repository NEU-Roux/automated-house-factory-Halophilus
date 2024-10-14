/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
abstract public class Block {
    private ResourceType resourceType;
    private double unitWeight;

    // Standard constructor
    public Block(ResourceType resourceType, int unitWeight) {
        setResourceType(resourceType);
        setUnitWeight(unitWeight);
    }

    // House constructor
    // Takes two
    public Block(){}

    // resourceType getters and setters
    public ResourceType getResourceType() {return resourceType;}
    public void setResourceType(ResourceType resourceType) {this.resourceType = resourceType;}

    // unitWeight getters and setters
    public double getUnitWeight() {return unitWeight;}
    public void setUnitWeight(double unitWeight) {this.unitWeight = unitWeight;}
}
