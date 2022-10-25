import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        Random random = new Random();
        for (int i=0;i<10;i+=1){
            array.add(random.nextInt(21));
        }
        return array;
    }
    public String getRandomLetter(){
        String[] array2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Random random = new Random();
        int s = random.nextInt(array2.length);
        return array2[s];

    }
    public String generatePassword(){
        String[] array2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String password = "";
        Random random = new Random();

        for(int i=0;i<8;i+=1){
            int s=random.nextInt(array2.length);
            password+=array2[s];
        }
        return password;

    }
    public String getNewPasswordSet(int size2){
        String[] array2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String password = "";
        Random random = new Random();

        for(int i=0;i<size2;i+=1){
            int s=random.nextInt(array2.length);
            password+=array2[s];
        }
        return password;

    }
    //SENSEI BONUS:
    public void shuffleArray(){
        String[] array2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Random random = new Random();
        for(int i=0;i<100;i++){
            int index1 = random.nextInt(array2.length);
            int index2 = random.nextInt(array2.length);
            String swap = array2[index1];
            array2[index1]=array2[index2];
            array2[index2]=swap;   
        }
            System.out.println("Mixed Array by index : ");
        for (int j=0 ;j<array2.length;j+=1){
            System.out.print(array2[j]);
        }
        

        
    }
}