package job.bespalov.logic;

import javax.persistence.*;

@Entity
public class ArderEntity {
    private int id;
    private int number;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
