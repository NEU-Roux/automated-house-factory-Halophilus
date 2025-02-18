import java.util.ArrayList;

/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */

// Delegation of the WoodBlockFactory
public class WoodBlockFactory implements Factory{
    private final ElementalFactoryDelegate delegate;

    public WoodBlockFactory(){
        delegate = new ElementalFactoryDelegate(ResourceType.WOOD);
    }

    public ArrayList<Resource> takeResource(ArrayList<Resource> intake){
        return delegate.takeResource(intake);
    }

    public Block produce(){
        return delegate.produce();
    }

    public void displayInventory(){
        delegate.displayInventory();
    }

}
