import java.util.ArrayList;
public class Museum {
	 public static void main(String[] args) {
	        // TODO: create paintings and sculptures here
		 ArrayList<Art> museum = new ArrayList<Art> ();
		 Painting pain1 = new Painting("Moon","Jame","Opaoa","Oil");
		 Painting pain2 = new Painting("Moon2","Jame","Opaoa","WaterColor");
		 Painting pain3 = new Painting("The Sun","Sonar","Opaoa","Oil");
		 Sculpture scu1 = new Sculpture("King","Xeyha","Opaoa","Iron");
		 Sculpture scu2 = new Sculpture("The League","Orn","Opaoa","Bronze");
		 System.out.println(pain1.getPaintType());
		 System.out.println(pain2.getPaintType());
		 System.out.println(pain3.getPaintType());
		 System.out.println(pain1.getTitle());
		 System.out.println(scu1.getMaterial());
		 System.out.println(scu2.getMaterial());
		 museum.add(pain1);
		 museum.add(pain2);
		 museum.add(pain3);
		 museum.add(scu1);
		 museum.add(scu2);
		 for(Art show : museum) {
			 show.viewArt();
		 }
	
		 
	    }
}
