import java.io.StringBufferInputStream;

public class CSVObject {
    int id;
    String term;

    public void setId(int ID)
    {
        id = ID;
    }

    public int getID(){
        return id;
    }

    public void setTerm(String termm){
        term = termm;
    }

    public String getTerm(){
        return term;
    }
}
