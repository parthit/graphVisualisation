import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LogicForCSV {



    List<CSVObject> csvobj = new ArrayList<CSVObject>();
    CSVObject obj;
    private static Scanner x;
    List<ForPairOfWords> StoreToRemoveDublicates = new ArrayList<>();
    ArrayList<String> ForCSV = new ArrayList<>();
    int i = ForCSV.size();

    List<ForPairOfWords> pairOfwords = new ArrayList<>();

    public void GetPairOfWords(ArrayList<String> csvarr){

        ForPairOfWords obj;

        for(int i=0;i<csvarr.size();i++){
            for(int j=i+1;j<csvarr.size();j++)
            {
                obj = new ForPairOfWords();
                obj.setTerm1(csvarr.get(i));
                obj.setTerm2(csvarr.get(j));
                pairOfwords.add(obj);
            }
        }

        WritePairOfWords(pairOfwords);
    }

    public void WritePairOfWords(List<ForPairOfWords> obj){

        List<ForPairOfWords> pairOfwords = new ArrayList<>();
        pairOfwords = obj;
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("C:\\Users\\PARTHIT PATEL\\IdeaProjects\\OmkarTextMiningProject\\PairOfWords.csv");
            fileWriter.append("Term1, Term2");
            fileWriter.append("\n");
            for(ForPairOfWords c:pairOfwords){
                fileWriter.append(c.getTerm1());
                fileWriter.append(", ");
                fileWriter.append(c.getTerm2());
                fileWriter.append("\n");
            }

        }catch(Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
        }finally {
            {
                try{
                    fileWriter.flush();
                    fileWriter.close();
                }catch(Exception iox){
                    iox.printStackTrace();
                }

            }
        }
    }

    public void readCSVObj() {
        BufferedReader reader = null;
        try {
            List<ForPairOfWords> pairOfWords = new ArrayList<>();
            String line = "";
            reader = new BufferedReader(new FileReader("C:\\Users\\PARTHIT PATEL\\IdeaProjects\\OmkarTextMiningProject\\PairOfWords.csv"));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] feilds = line.split(",");
                if (feilds.length > 0) {
                    ForPairOfWords obj = new ForPairOfWords();
                    obj.setTerm1(feilds[0]);
                    obj.setTerm2(feilds[1]);
                    pairOfWords.add(obj);
                }
            }

            for (ForPairOfWords c : pairOfWords) {
                String term1 = c.getTerm1();
                String term2 = c.getTerm2();
                System.out.println(term1 + " " + term2);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {

            try {
                reader.close();
            } catch (Exception iox) {
                iox.printStackTrace();
            }
        }
    }

//    }
//    public void deleteRecord(String t1, String t2){
//        String tempFile = "C:\\Users\\PARTHIT PATEL\\IdeaProjects\\OmkarTextMiningProject\\temp.csv";
//        String filePath = "C:\\Users\\PARTHIT PATEL\\IdeaProjects\\OmkarTextMiningProject\\PairOfWords.csv";
//        File oldFile = new File(filePath);
//        File newFile = new File(tempFile);
//        String termm1 = "";
//        String termm2 = "";
//        try{
//            FileWriter fw = new FileWriter(tempFile,true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter pw = new PrintWriter(bw);
//            x =new Scanner(new File(filePath));
//            x.useDelimiter("[,\n]");
//            while(x.hasNext()){
//
//                termm1 = x.next();
//                termm2 = x.next();
//                if(!termm1.equals(t1)){
//                    pw.println(termm1+","+termm2);
//                }
//                x.close();
//                pw.flush();
//                pw.close();
//                oldFile.delete();
//                File dump = new File(filePath);
//                newFile.renameTo(dump);
//            }
//
//
//
//        }catch(Exception ex){
//            System.out.println(ex);
//        }
//    }



    public void writeCSV(String filePath)  //writeCSV ka zaroorat nahi hai. Neeche wala function is useless
    {

        for(String c : ForCSV) {
            obj = new CSVObject();
            obj.setId(i);
            obj.setTerm(c);
            csvobj.add(obj);
            i++;
        }
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(filePath);
            fileWriter.append("ID, Term");
            fileWriter.append("\n");
            for(CSVObject c:csvobj){
                fileWriter.append(String.valueOf(c.getID()));
                fileWriter.append(", ");
                fileWriter.append(c.getTerm());
                fileWriter.append("\n");
            }

        }catch(Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
        }finally {
            {
                try{
                    fileWriter.flush();
                    fileWriter.close();
                }catch(Exception iox){
                    iox.printStackTrace();
            }

            }
        }

    }

    public void readCSV(String filePath){ //this function is not used
        BufferedReader reader = null;
        try{
            List<CSVObject> csvobj = new ArrayList<CSVObject>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();

            while((line = reader.readLine()) != null){
                String[] feilds = line.split(",");
                if(feilds.length>0){
                    CSVObject obj = new CSVObject();
                    obj.setId(Integer.parseInt(feilds[0]));
                    obj.setTerm(feilds[1]);
                    csvobj.add(obj);
                }
            }

            for(CSVObject c: csvobj){
                int id = c.getID();
                String term = c.getTerm();
                System.out.println("[Id]="+id+" [Term]="+term);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }finally {
            try{
                reader.close();
            }catch(Exception iox){
                iox.printStackTrace();
            }
        }
    }

    ArrayList<String> GetCompleteGraph(ArrayList<String> ListOfWords){ //this function is also useless
        for(int i=0;i<ListOfWords.size();i++){
            for(int j=i+1;j<ListOfWords.size();j++)
            {
                    System.out.println(ListOfWords.get(i)+" "+ListOfWords.get(j));
            }
        }

        return ListOfWords;

    }
}
