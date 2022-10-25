import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(int numWeeks) {
        int sum=0;
        for(int i=1 ;i<=numWeeks;i+=1){
            sum+=i;
        }
        return sum;
    }
    public double getOrderTotal(double[] prices){
        double sum=0.0;
        for(int i=0 ; i<prices.length;i+=1){
            sum+=prices[i];
        }
        return sum;
    }
    public void displayMenu(ArrayList<String> menuItems) {
        for(int i=0 ;i<menuItems.size();i+=1){
            System.out.println(i+" "+menuItems.get(i));
        }
    }
    public void addCustomer(ArrayList<String> customer){
        System.out.println("Please Enter Your Name");
        String userName = System.console().readLine();
        System.out.println("Hello ,"+userName +" "+"There are "+customer.size()+" people in ahead of you.");
        customer.add(userName);
        System.out.println(customer);


    }




}