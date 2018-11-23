import java.util.ArrayList;

public class MAIN {
    public static void main(String args[]){

        ArrayList<String> ListOfWords = new ArrayList<>();
        String filePath = "C:\\Users\\PARTHIT PATEL\\IdeaProjects\\OmkarTextMiningProject\\csvfile1.csv";


        RemoveStopWords rsw = new RemoveStopWords();
        LogicForCSV csw = new LogicForCSV();


        RSSFeedParser parser = new RSSFeedParser(
                "http://feeds.reuters.com/Reuters/PoliticsNews");
        Feed feed = parser.readFeed();
        for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);
           ListOfWords = rsw.removestopwords(message.getDescription());
           System.out.println(ListOfWords);
           ListOfWords = rsw.removeRepeatingWords(ListOfWords);
           System.out.println(ListOfWords);
           csw.ForCSV = ListOfWords;
           csw.GetPairOfWords(csw.ForCSV);
        }

        csw.readCSVObj();



    }
}
