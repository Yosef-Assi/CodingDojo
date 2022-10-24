public class AlfredTest {
    /*
    * This main method will always be the launch point for a Java application
    * For now, we are using the main to test all our 
    * AlfredQuotes methods.
    */
    public static void main(String[] args) {
        // Make an instance of AlfredQuotes to access all its methods.
        AlfredQuotes alfredBot = new AlfredQuotes();
        
        // Make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        String testGreetingPeriod = alfredBot.guestGreeting("Beth Kane","evening");
        String alexisTest = alfredBot.respondBeforeAlexis(
                            "Alexis! Play some low-fi beats."
                            );
        String alfredTest = alfredBot.respondBeforeAlexis(
            "I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = alfredBot.respondBeforeAlexis(
            "Maybe that's what Batman is about. Not winning. But failing.."
        );
        // sensi bouns 
        String respondMoodAlfredAngry =  alfredBot.respondStausAlfred("alfred is  Angry");
        String respondMoodAlfredSad =  alfredBot.respondStausAlfred("alfred is  Sad");
        String respondMoodAlfredSomething =  alfredBot.respondStausAlfred("alfred something");



        // Print the greetings to test.
        System.out.println(testGreeting);
        
        // Uncomment these one at a time as you implement each method.
        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);
        System.out.println(testGreetingPeriod);
        System.out.println(respondMoodAlfredAngry);
        System.out.println(respondMoodAlfredSad);
        System.out.println(respondMoodAlfredSomething);

    }
}