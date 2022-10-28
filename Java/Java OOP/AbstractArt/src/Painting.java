
public class Painting extends Art{

	private String paintType ;
	
	public Painting(String title, String author, String description,String paintType) {
		super(title, author ,description);
		this.paintType= paintType;
	}
	@Override
	public void viewArt() {
		String art="";
		 art += "The Title is "+" "+ this.getTitle()+" ";
		 art +="The Author is "+" "+this.getAuthor()+" ";
		 art +="Description is "+" "+this.getDescription()+" ";
		 art +="Paint type is "+" "+this.paintType +" ";
		 System.out.println(art);
	}
	public String getPaintType() {
		return paintType;
	}
	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	

}
