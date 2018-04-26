package job.bespalov.logic;

import javax.persistence.*;

@Entity
public class TablenamespaceEntity {
    private int idTile;
    private String titleFile;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdTile() {
        return idTile;
    }

    public void setIdTile(int idTile) {
        this.idTile = idTile;
    }

    public String getTitleFile() {
        return titleFile;
    }

    public void setTitleFile(String titleFile) {
        this.titleFile = titleFile;
    }


}
