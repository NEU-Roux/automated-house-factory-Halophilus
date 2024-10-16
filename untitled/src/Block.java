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
    public Block(ResourceType resourceType, double unitWeight) {
        setResourceType(resourceType);
        setUnitWeight(unitWeight);
    }

    // House constructor
    // Takes two
    public Block(Block blockA, Block blockB){}

    // resourceType getters and setters
    public ResourceType getResourceType() {return resourceType;}
    protected void setResourceType(ResourceType resourceType) {this.resourceType = resourceType;}

    // unitWeight getters and setters
    public double getUnitWeight() {return unitWeight;}
    protected void setUnitWeight(double unitWeight) {this.unitWeight = unitWeight;}

    // breakBlock method, unimplemented
    public Resource breakBlock(){
        return null;
    }

    // toString override
    @Override
    public String toString() {
        String blockType = switch (resourceType) {
            case WOOD -> "Wood";
            case STONE -> "Stone";
            case HOUSE -> "House";
            default -> "Undefined";
        };
        String weight = String.format("%.2f", unitWeight);
        return blockType + "block, weight: " + weight;
    }
}
