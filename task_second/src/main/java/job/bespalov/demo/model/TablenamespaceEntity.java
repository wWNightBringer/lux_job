package job.bespalov.demo.model;

import job.bespalov.demo.dao.ValuesDAO;

import javax.persistence.*;
/**
 * Create class {@link TablenamespaceEntity} and used hibernate
 *
 * @author Bespalov Andrew
 * @version 1.0
 */
@Entity
@Table(name = "tablenamespace", schema = "job_lux", catalog = "")
public class TablenamespaceEntity {
    private int idTile;
    private String titleFile;

    @Id
    @Column(name = "ID_tile", nullable = false)
    public int getIdTile() {
        return idTile;
    }

    public void setIdTile(int idTile) {
        this.idTile = idTile;
    }

    @Basic
    @Column(name = "title_file", nullable = false, length = 45)
    public String getTitleFile() {
        return titleFile;
    }

    public void setTitleFile(String titleFile) {
        this.titleFile = titleFile;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        TablenamespaceEntity that = (TablenamespaceEntity) object;

        if (idTile != that.idTile) return false;
        if (titleFile != null ? !titleFile.equals(that.titleFile) : that.titleFile != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTile;
        result = 31 * result + (titleFile != null ? titleFile.hashCode() : 0);
        return result;
    }
}
