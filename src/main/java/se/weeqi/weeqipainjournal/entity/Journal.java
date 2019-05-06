package se.weeqi.weeqipainjournal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Document(collection = "journal")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Journal {
    @Id
    private Long id;
    private int pain;
    @NotBlank
    private String owner;
    private String notes;
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

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
                ", createdAt=" + createdAt + '\'' +
                "}";
    }
}
