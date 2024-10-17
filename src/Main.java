import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

/*
Driver file for Automated House Factory Assignment

This file will not work until assignment has been completely implmented. 

6/21/2022
-Dr. G

*/
public class Main
{
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Resource> resources;

        Factory stoneBlockProducer = new StoneBlockFactory();
        Factory woodBlockProducer = new WoodBlockFactory();
        HouseFactory houseBlockProducer = new HouseFactory(); // HouseFactory has unique underlying functionality

        Block h1;

        //Infinite simulation loop CTRL + C to terminate simulation
        while(true)
        {
            resources = mineResource(); // Generates a list of resources

            //switch(resource.getType())
            //{
            //    case STONE: stoneBlockProducer.takeResource(resource); break;
            //    case WOOD: woodBlockProducer.takeResource(resource); break;
            //}

            // Extract resources relevant to the factory
            // Mutates elements in resources in place
            woodBlockProducer.takeResource(resources);
            stoneBlockProducer.takeResource(resources);

            // Attempt to generate Blocks from available materials in each ElementalFactory
            houseBlockProducer.takeResource(stoneBlockProducer.produce());
            houseBlockProducer.takeResource(woodBlockProducer.produce());

            // Try to make a house
            h1 = houseBlockProducer.produce();

            if (h1 != null) System.out.println("**HOUSE BUILT**");

            // Dispose of house block
            h1 = null;


            System.out.println("Stone Producer");
            stoneBlockProducer.displayInventory();
            System.out.println("Wood Producer");
            woodBlockProducer.displayInventory();
            System.out.println("House Producer");
            houseBlockProducer.displayInventory();

            System.out.println();

            //pauses simulation for 2 seconds so it is visable
            Thread.sleep(2000);
        }
    }

    //generate a random Resource with a random weight
    // EXTENSION: Packages Resource objects in ArrayList
    public static ArrayList<Resource> mineResource()
    {
        Random r = new Random();
        ArrayList<Resource> resourceList = new ArrayList<Resource>();

        ResourceType type = ResourceType.STONE;
        double weight = Math.round((Math.abs(r.nextDouble()))*100.0)/10.0 ;
        int select = r.nextInt(2);

        switch(select)
        {
            case 0: type = ResourceType.STONE; break;
            case 1: type = ResourceType.WOOD; break;
        }
        System.out.println("GENERATED " + type + " OF WEIGHT " + weight);
        resourceList.add(new Resource(type, weight));
        return resourceList;
    }
}

