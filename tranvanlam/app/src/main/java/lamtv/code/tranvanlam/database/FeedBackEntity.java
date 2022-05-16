package lamtv.code.tranvanlam.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "feedback")
public class FeedBackEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String email;
    private String specie;
    private String description;

    public  FeedBackEntity(){

    }
    public FeedBackEntity(String name, String email, String specie, String description) {
        this.name = name;
        this.email = email;
        this.specie = specie;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
