import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Items item1 = new Items();
        Items item2 = new Items();
        Items item3 = new Items();
        Items item4 = new Items();
        // Order variables -- order1, order2 etc.
        item1.name="mocha";
        item1.price=2.5;
        //Item2
        item2.name="latte";
        item2.price=2.5;
        //Item3
        item3.name="drip coffe";
        item3.price=5.5;
        //Item4
        item4.name="capuccino";
        item4.price=6.0;
        //Orders
        Orders order1 = new Orders();
        Orders order2 = new Orders();
        Orders order3 = new Orders();
        Orders order4 = new Orders();
        //Order1
        order1.name="Cindhuri";
        //Order2
        order2.name="Jimmy";
        //Order3
        order3.name="Noah";
        //Order4
        order4.name="Sam";
        // Application Simulations
        order2.arraylist.add(item1);
        order2.total+=item1.price;
        order2.ready= true;
        //order3 status
        order3.arraylist.add(item4);
        order3.total+=item4.price;
        //order4 
        order4.arraylist.add(item2);
        order4.total+=item2.price;
        //order1 ready status
        order1.ready=true;
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Order2 total: %s\n", order2.total);
        System.out.println("Order3 total: "+order3.total + " Order3 is: "+ item4.name);
        System.out.println("Order4 total: "+order4.total + " Order4 is: "+ item2.name);
        System.out.println("Name : "+order1.name + " Order1 is ready ?  "+ order1.ready);
        order4.arraylist.add(item2);
        order4.total+=item2.price;
        System.out.println("New Price For Order4 so total is: "+order4.total + " Order4 is 2 "+ item2.name);
        System.out.println("Order2 for: " + order2.name + " and the order is ready ? "+order2.ready);


       
        // System.out.printf("Ready: %s\n", order1.ready);
    }
}