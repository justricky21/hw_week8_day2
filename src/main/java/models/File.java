package models;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class File {
    private String name;
    private int size;
    private Folder folder;
    private Extension extension;
    private int id;

    public File(String name, int size, Folder folder, Extension extension) {
        this.name = name;
        this.size = size;
        this.folder = folder;
        this.extension = extension;
    }

    public File() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "size")
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    @Enumerated(value = EnumType.STRING)
    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
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
