/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public interface Factory {
    boolean takeResource(Object resourceBlock);
    Block produce();
    void displayInventory();
}
