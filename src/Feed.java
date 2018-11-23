import java.util.ArrayList;
import java.util.List;

/*
 * Stores an RSS feed
 */

//This you will have to understand on your own. Syntax samajh le isko.

public class Feed {

    final String description;


    final List<FeedMessage> entries = new ArrayList<FeedMessage>();

    public Feed( String description) {

        this.description = description;
    }

    public List<FeedMessage> getMessages() {
        return entries;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return  description;
    }

}




