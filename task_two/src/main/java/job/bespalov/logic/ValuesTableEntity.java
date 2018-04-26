package job.bespalov.logic;

import javax.persistence.*;

@Entity
@Table(name = "values_table", schema = "job_lux")
public class ValuesTableEntity {
    private int numberLine;
    private String line;
    private String longestWord;
    private String shortestWord;
    private int lengthLine;
    private int averageWord;
    private TablenamespaceEntity tablenamespaceByTitleId;

    @Basic
    @Column(name = "number_line", nullable = false)
    public int getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(int numberLine) {
        this.numberLine = numberLine;
    }

    @Basic
    @Column(name = "line", nullable = false, length = 45)
    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Basic
    @Column(name = "longest_word", nullable = false, length = 45)
    public String getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(String longestWord) {
        this.longestWord = longestWord;
    }

    @Basic
    @Column(name = "shortest_word", nullable = false, length = 45)
    public String getShortestWord() {
        return shortestWord;
    }

    public void setShortestWord(String shortestWord) {
        this.shortestWord = shortestWord;
    }

    @Basic
    @Column(name = "length_line", nullable = false)
    public int getLengthLine() {
        return lengthLine;
    }

    public void setLengthLine(int lengthLine) {
        this.lengthLine = lengthLine;
    }

    @Basic
    @Column(name = "average_word", nullable = false)
    public int getAverageWord() {
        return averageWord;
    }

    public void setAverageWord(int averageWord) {
        this.averageWord = averageWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValuesTableEntity that = (ValuesTableEntity) o;

        if (numberLine != that.numberLine) return false;
        if (lengthLine != that.lengthLine) return false;
        if (averageWord != that.averageWord) return false;
        if (line != null ? !line.equals(that.line) : that.line != null) return false;
        if (longestWord != null ? !longestWord.equals(that.longestWord) : that.longestWord != null) return false;
        if (shortestWord != null ? !shortestWord.equals(that.shortestWord) : that.shortestWord != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numberLine;
        result = 31 * result + (line != null ? line.hashCode() : 0);
        result = 31 * result + (longestWord != null ? longestWord.hashCode() : 0);
        result = 31 * result + (shortestWord != null ? shortestWord.hashCode() : 0);
        result = 31 * result + lengthLine;
        result = 31 * result + averageWord;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "title_id", referencedColumnName = "ID_tile", nullable = false)
    public TablenamespaceEntity getTablenamespaceByTitleId() {
        return tablenamespaceByTitleId;
    }

    public void setTablenamespaceByTitleId(TablenamespaceEntity tablenamespaceByTitleId) {
        this.tablenamespaceByTitleId = tablenamespaceByTitleId;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
