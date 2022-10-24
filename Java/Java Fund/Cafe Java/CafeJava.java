public class CafeJava {
    public static void main(String [] args){
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
          // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffe =2.5;
        double latte = 4.5;
        double cappuccino =5.5;
         
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1);
        System.out.println(isReadyOrder1 ? generalGreeting + customer1 +","+ "The Order is ready and coffe price is "+dripCoffe :generalGreeting + customer1 +","+"The Order is not ready yet");
         // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if(isReadyOrder4){
                    System.out.println(generalGreeting + customer4 +","+ "The Order is ready and cappuccino price is "+cappuccino);

        }
        else {
            System.out.println(generalGreeting + customer4 +","+"The Order is not ready yet");
        }
        System.out.println(generalGreeting + customer2 +" "+ "you ordered 2 lattes and the total price is "+latte*2);
        if(isReadyOrder2){
            System.out.println(generalGreeting + customer2 +","+"The Order is ready and 2 lattes price is "+latte*2);

        }
        else {
            System.out.println(generalGreeting + customer2 +","+"The Order is not ready yet");

        }
        double newPrice=latte-dripCoffe;
        System.out.println(generalGreeting + customer3 + ","+"You ordered a latte, but the price of the coffee was miscalculated instead of the latte ,so the new price is "+newPrice);
    }
}