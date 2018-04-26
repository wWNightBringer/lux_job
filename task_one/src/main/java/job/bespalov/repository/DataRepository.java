package job.bespalov.repository;

public interface DataRepository {
    void addToTableValues(int title,int numberLine,String line,String longestLine,
                          String shortestLine,int lineLegth,int averageLengthWord);
    void addToTableNamespace(String title);
}
