import java.util.ArrayList;
public class Array2 {
    public static void main(String[] args){
        ArrayList<Integer> zaki = new ArrayList<Integer>();
        zaki.add(2);
        zaki.add(3);
        zaki.add(5);
        zaki.set(1,6);
        // ArrayList<Integer> arayClone = (ArrayList<Integer>)zaki.clone();

        // System.out.println(arayClone);
        int[] populationTotals = new int[255];
        populationTotals.add(222);
        System.out.println(populationTotals.get(0));
        for(int i :zaki) {
            System.out.println(i);
        }
        for (int i=0;i<zaki.size();i++){
            System.out.println(zaki.get(i));
        }
       

}