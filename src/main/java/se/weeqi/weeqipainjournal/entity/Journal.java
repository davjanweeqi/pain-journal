package se.weeqi.weeqipainjournal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "journal")
public class Journal {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPain() {
        return pain;
    }

    public void setPain(int pain) {
        this.pain = pain;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", pain=" + pain + '\'' +
                ", owner=" + owner + '\'' +
                ", notes=" + notes + '\'' +
                "}";
    }

    private @Id @GeneratedValue Long id;
    private int pain;
    private String owner;
    private String notes;
}
