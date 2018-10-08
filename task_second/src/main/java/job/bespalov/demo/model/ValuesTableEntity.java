package job.bespalov.demo.model;

import javax.persistence.*;
/**
 * Create class {@link ValuesTableEntity} and used hibernate
 *
 * @author Bespalov Andrew
 * @version 1.0
 */
@Entity
@Table(name = "values_table", schema = "job_lux", catalog = "")
public class ValuesTableEntity {
    private int numberLine;
    private String line;
    private String longestWord;
    private String shortestWord;
    private int lengthLine;
    private int averageWord;
    private TablenamespaceEntity tablenamespaceByTitleId;
    private String id;
    private int idValue;

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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ValuesTableEntity that = (ValuesTableEntity) object;

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

    @Id
    @Column(name = "Id_value", nullable = false)
    public int getIdValue() {
        return idValue;
    }

    public void setIdValue(int idValue) {
        this.idValue = idValue;
    }
}
