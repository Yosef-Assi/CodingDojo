import java.util.ArrayList;
public class TestOrder {
    public static void main(String[] args) {
        System.out.println("**************************");
        OrderKiosk kiosk = new OrderKiosk();
        kiosk.addMenuItem("Tea",5.9);
        kiosk.addMenuItem("Milk",7.2);
        kiosk.addMenuItem("XL",8.9);
        kiosk.addMenuItem("Blue",15.9);
        kiosk.addMenuItem("latte",25.9);
        kiosk.newOrder();
     }
}