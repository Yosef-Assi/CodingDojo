import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello,"+name+",Lovely to see you.";
    }
    // NINJA BONUS
    public String guestGreeting(String name,String dayPeriod) {
        
        return "Good"+" "+dayPeriod+","+name+",Lovely to see you.";
    }
    
    public String dateAnnouncement() {
        Date date=new Date(); 
        // YOUR CODE HERE
        return "It is currently," +date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if (conversation.contains("Alexis")){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";


        }
        else if (conversation.contains("Alfred")){
            return "At your service. As you wish, naturally.";


        }
        else {
            return "Right. And with that I shall retire.";
        }
    }
    
	
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    public String respondStausAlfred(String conversation) {
        // YOUR CODE HERE
        if (conversation.contains("Angry")){
            return "Im angry Alexis";


        }
        else if (conversation.contains("Sad")){
            return "Im Sad Alexis";


        }
        else {
            return "Alfred ..........";
        }
    }
    // Write your own AlfredQuote method using any of the String methods you have learned!
}