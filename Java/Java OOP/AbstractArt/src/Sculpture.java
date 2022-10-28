
public class Sculpture extends Art{
	private String material ;
	public Sculpture(String title, String author, String description,String material) {
		super(title, author ,description);
		this.material = material;
	}
	@Override
	public void viewArt() {
			String art="";
			 art += "The Title is "+ ""+this.getTitle() +" ";
			 art +="The Author is "+""+this.getAuthor()+" ";
			 art +="Description is "+""+this.getDescription()+" ";
			 art +="Metrial is "+""+this.material;
			 System.out.println(art);
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

}
