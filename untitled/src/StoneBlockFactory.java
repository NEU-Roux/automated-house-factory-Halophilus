/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
// Delegation of the StoneBlockFactory
public class StoneBlockFactory{
    private final ElementalFactoryDelegate delegate;

    public StoneBlockFactory(){
        delegate = new ElementalFactoryDelegate(ResourceType.STONE;
    }

    public boolean takeResource(Object intake){
        return delegate.takeResource(intake);
    }

    public Block produce(){
        return delegate.produce();
    }

    public void displayInventory(){
        delegate.displayInventory();
    }

}