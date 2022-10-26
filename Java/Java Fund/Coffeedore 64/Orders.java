import java.util.ArrayList;
public class Orders {
    private String name;
    private boolean ready;
    private ArrayList<Items> arraylist = new ArrayList<Items>();


    public Orders(){
        this.name="Guest";
        this.arraylist=new ArrayList<Items>();
    }
     public Orders(String name){
        this.name=name;
    }
    public String  getName(){
        return name;

    }
    public void setName(String name){
        this.name=name;
    }
    public boolean  getBoolean(){
        return ready;

    }
    public void setBoolean(boolean ready){
        this.ready=ready;
    }
    public ArrayList<Items> getArray(){
        return arraylist;
    }
    public void setArray(ArrayList<Items> arraylist){
        this.arraylist = arraylist;
    }

    public void addItems(Items item){
        this.arraylist.add(item);
    }
    public String getStatusMessage(boolean ready){
        if(this.ready){
            return "Your order is ready";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon .";
        }

    }

    public void display(){
        System.out.println("Customer Name : "+ this.name);
        double total = 0.0;

       for (Items i :arraylist){
        total+= i.getPrice();
        System.out.println(i.getName() + ": $"+i.getPrice() );
       }
       System.out.println("Your Total : $"+total);

    }
}