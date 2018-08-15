package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {
    private String name;
    private String userName;
    private int id;
    private List<Folder> folders;

    public Owner(String name, String userName) {
        this.name = name;
        this.userName = userName;
    }

    public Owner() {
    }

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
