import java.util.ArrayList;
public class TestOrder {
    public static void main(String[] args) {
    
        // Menu items
        Orders order1 = new Orders();
        Orders order2 = new Orders();
        //Items
        Items item1 = new Items("latte",2.6);
        Items item2 = new Items("coffe",5);

        System.out.println(order1.getName());
        System.out.println(order2.getName());

        Orders order11 = new Orders("Zaki");
        Orders order12 = new Orders("Khaled");
        Orders order13 = new Orders("Sameer");
        order13.addItems(item1);
        order13.addItems(item1);

        order12.addItems(item2);
        order12.addItems(item1);


        order13.display();
        System.out.println("**************************");

        order12.display();
        order2.setBoolean(true);
        System.out.println(order2.getStatusMessage(order2.getBoolean()));
       
        // System.out.printf("Ready: %s\n", order1.ready);
    }
}