/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
abstract public class Block {
    // Singular class for all variations of the Block object
    private ResourceType resourceType;
    private boolean broken;// Default false
    private boolean depleted;

    // Standard constructor
    public Block(ResourceType resourceType) {
        setResourceType(resourceType);
    }

    // resourceType getters and setters
    public ResourceType getResourceType() {return resourceType;}
    public void setResourceType(ResourceType resourceType) {this.resourceType = resourceType;}

    // Blocks that
    public boolean isBroken() {return broken;}
    public boolean isDepleted() {return depleted;}

    private void setBroken(boolean broken) {this.broken = broken;}
    private void setDepleted(boolean depleted) {this.depleted = depleted;}

    // breakBlock method
    public Resource breakBlock(){

        setBroken(true);
        return null;
    }

    // toString override
    @Override
    public String toString() {
        String weight = String.format("%.2f", resourceType.getWeight());
        return resourceType + "block, weight: " + weight;
    }
}
