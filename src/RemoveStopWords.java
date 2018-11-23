import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveStopWords {

    ArrayList<String> removeRepeatingWords(ArrayList<String> wordList){
        Set<String> set = new HashSet<>();

        set.addAll(wordList);
        wordList.clear();
        wordList.addAll(set);
        return wordList;
    }


    ArrayList<String> removestopwords(String tweet){

        /*The parameter is Tweet because i copied this from the Sentiment analysis project
        However over here, the parameter that this function receives is individual articles from the URL mentioned
        in the MAIN function. You can rename it to anything you want.
         */
        ArrayList<String> wordsList = new ArrayList<String>();
        String[] stopwords = {"a", "the", "as", "able", "about",
                "above", "according", "accordingly", "across", "actually",
                "after", "afterwards", "again", "against", "aint", "all",
                "allow", "allows", "almost", "alone", "along", "already",
                "also", "although", "always", "am", "among", "amongst", "an",
                "and", "another", "any", "anybody", "anyhow", "anyone", "anything",
                "anyway", "anyways", "anywhere", "apart", "appear", "appreciate",
                "appropriate", "are", "arent", "around", "as", "aside", "ask", "asking",
                "associated", "at", "available", "away", "awfully", "be", "became", "because",
                "become", "becomes", "becoming", "been", "before", "beforehand", "behind", "being",
                "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both",
                "brief", "but", "by", "cmon", "cs", "came", "can", "cant", "cannot", "cant", "cause", "causes",
                "certain", "certainly", "changes", "clearly", "co", "com", "come",
                "comes", "concerning", "consequently", "consider", "considering", "contain",
                "containing",    "contains","corresponding","could", "couldnt", "course", "currently",
                "definitely", "described", "despite", "did", "didnt", "different", "do", "does",
                "doesnt", "doing", "dont", "done", "down", "downwards", "during", "each", "edu",
                "eg", "eight", "either", "else", "elsewhere", "enough", "entirely", "especially",
                "et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere",
                "ex", "exactly", "example", "except", "far", "few", "ff", "fifth", "first", "five", "followed",
                "following", "follows", "for", "former", "formerly", "forth", "four", "from", "further",
                "furthermore", "get", "gets", "getting", "given", "gives", "go", "goes", "going", "gone"
                , "got", "gotten", "greetings", "had", "hadnt", "happens", "hardly", "has", "hasnt", "have",
                "havent", "having", "he", "hes", "hello", "help", "hence", "her", "here", "heres", "hereafter",
                "hereby", "herein", "hereupon", "hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how",
                "howbeit", "however", "i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", "inc",
                "indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead", "into", "inward", "is", "isnt",
                "it", "itd", "itll", "its", "its", "itself", "just", "keep", "keeps", "kept", "know", "knows", "known", "last",
                "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely",
                "little", "look", "looking", "looks", "ltd", "mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely"
                , "might", "more", "moreover", "most", "mostly", "much", "must", "my", "myself", "name", "namely", "nd", "near",
                "nearly", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "no", "nobody",
                "non", "none", "noone", "nor", "normally", "not", "nothing", "novel", "now", "nowhere", "obviously", "of", "off"
                , "often", "oh", "ok", "okay", "old", "on", "once", "one", "ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours", "ourselves", "out", "outside", "over", "overall", "own", "particular", "particularly", "per", "perhaps", "placed", "please", "plus", "possible", "presumably", "probably", "provides", "que", "quite", "qv", "rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", "relatively", "respectively", "right", "said", "same", "saw", "say", "saying", "says", "second", "secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible", "sent", "serious", "seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six", "so", "some", "somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure", "ts", "take", "taken", "tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their", "theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore", "therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre", "theyve", "think", "third", "this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "twice", "two", "un", "under", "unfortunately", "unless", "unlikely", "until", "unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually", "value", "various", "very", "via", "viz", "vs", "want", "wants", "was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome", "well", "went", "were", "werent", "what", "whats", "whatever", "when", "whence", "whenever", "where", "wheres", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos", "whoever", "whole", "whom", "whose", "why", "will", "willing", "wish", "with", "within", "without", "wont", "wonder", "would", "would", "wouldnt", "yes", "yet", "you", "youd", "youll", "youre", "youve", "your", "yours", "yourself", "yourselves", "zero","Monday", "A","the","This","I", "can", "Tuesday", "Wednesday", "Thursday", "Friday", "(Reuters)","has", "are", "no", "--", "A", "they've", "We", "How","shows", "There", "been", "<"};


        tweet = tweet.trim().replaceAll("\\s+", " ");
        tweet = tweet.replace("'s","");
        tweet = tweet.replace(",", "");
        tweet =tweet.replace("(", "");
        tweet =tweet.replace(")", "");
        tweet =tweet.replace(".", "");
        tweet =tweet.replace("?", "");
        tweet=tweet.replace("\"","");
        String[] words = tweet.split(" ");
        //Here we have stored all the words in the article(Tweet) as individual words in a string array called words



        int sol = wordsList.size();
        for (String word : words) {
            if(!word.equals(" ")) {
                wordsList.add(word);
            }
        }

        for (int i = sol; i < wordsList.size(); i++) {
            for (int j = 0; j < stopwords.length; j++) {
                if (stopwords[j].contains(wordsList.get(i))) {
                    wordsList.remove(i);
                    i--;
                    break;
                }
            }
        }


        return wordsList;
    }



}