import java.util.HashMap;

public class Hash {
    public static void Challange() {
        HashMap<String, String> song = new HashMap<String, String>();
        song.put("Song1", "blabalablablbalbalab");
        song.put("Song2", "dladladlaadladladllda");
        song.put("Song3", "Ylaylaylaylaylaylayls");
        song.put("Song4", "Opsopsopsopsopsopsops");

        String val = song.get("Song2");
        System.out.println("track title for Song2 : "+val);
        for (String i : song.keySet()) {
        System.out.println("Track: " + i + " Lyrics: " + song.get(i));
}

    }
}