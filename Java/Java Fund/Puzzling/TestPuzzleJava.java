import java.util.ArrayList;

import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println("The Random Array (TenRolls) is : "+randomRolls);
		String rand = generator.getRandomLetter();
        System.out.println("The Random Letter is : "+rand);
        String password = generator.generatePassword();
        System.out.println("The Generate Password is : "+password);
        String password2 = generator.getNewPasswordSet(80);
        System.out.println("The Generate New Password is : "+password2);
        generator.shuffleArray();

    	//..
		// Write your other test cases here.
		//..
	}
}