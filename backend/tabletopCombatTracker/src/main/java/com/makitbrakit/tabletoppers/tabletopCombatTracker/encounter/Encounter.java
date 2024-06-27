import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



@Entity
public class Encounter {

    @Id
    @GeneratedValue
    private Long id;
    private String name; 
    private Date createdAt;
    private Date updatedAt;

    protected Encounter() {}

    public Encounter(String name, Date createdAt) {
        this.name = name; 
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    @Override
    public String toString() {
        return String.format(
            "Encounter[id=%d, name=%s]",
            id, name
        );
    }

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    } 

}