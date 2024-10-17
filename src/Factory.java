import java.util.ArrayList;

/******
 * Name: Ben Henshaw
 * Assignment: Lab 04: Automated House Factory
 * Date: 10/14/2024
 * Notes: Complex factory simulation
 */
public interface Factory {
    ArrayList<Resource> takeResource(ArrayList<Resource> resources);
    Block produce();
    void displayInventory();
}
