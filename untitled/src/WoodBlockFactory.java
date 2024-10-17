/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */

//
public class WoodBlockFactory{
    private ElementalFactoryDelegate delegate;

    public WoodBlockFactory(){
        delegate = new ElementalFactoryDelegate(ResourceType.WOOD);
    }

    public boolean takeResource(Object intake){
        return delegate.takeResource(intake);
    }

    public Block produce(){
        return delegate.produce();
    }

}
