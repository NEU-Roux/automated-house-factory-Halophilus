/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public class StoneBlockFactory implements Factory{
    public Resource bin;
    public StoneBlockFactory() {
        bin = new Resource(ResourceType.STONE, 0);
    }

    public boolean takeResource(Object intake) {
        if (intake instanceof Resource) {
            if (((Resource) intake).getType() == ResourceType.STONE) {
                double availableResource = ((Resource) intake).getStoredWeight();
                System.out.println("AVAILABLE STONE RESOURCE: " + availableResource);
                System.out.println("EXISTING STONE INVENTORY");
                displayInventory();
                bin.modifyResource(availableResource);
                ((Resource) intake).modifyResource(-availableResource);
                System.out.println("UPDATED STONE INVENTORY");
                displayInventory();

            } else {
                //System.out.println("StoneBlockFactory.takeResource: Resource type mismatch");
            }

        } else if (intake == null) {
            //System.out.println("StoneBlockFactory.takeResource: Null resource");

        } else {
            //System.out.println("StoneBlockFactory.takeResource: Illegal resource type");
        }
        return false;
    }

    public Block produce(){
        try {

            bin.modifyResource(-Const.STONE_WEIGHT);
            System.out.println("STONE BLOCK PRODUCED");
            System.out.println("UPDATED STONE INVENTORY: ");
            displayInventory();
            return new StoneBlock();
        }
        catch (NegativeResource nr){System.out.println(nr.getMessage());}
        return null;
    }

    public void displayInventory(){
        System.out.printf("%.2f\n", bin.getStoredWeight());
    }
}
