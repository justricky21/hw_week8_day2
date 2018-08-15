import db.DBFile;
import db.DBFolder;
import db.DBHelper;
import models.Extension;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner ricardo = new Owner("Ricardo", "ricardo_ruiz");
        DBHelper.save(ricardo);

        Folder bookIdea = new Folder("book idea", ricardo);
        DBHelper.save(bookIdea);
        Folder games = new Folder("games",ricardo);
        DBHelper.save(games);
        Folder oldStuff = new Folder("old stuff",ricardo);
        DBHelper.save(oldStuff);
        Folder presentations = new Folder("presentations",ricardo);
        DBHelper.save(presentations);

        File main = new File("main", 10, oldStuff, Extension.RB);
        DBHelper.save(main);
        File test = new File("never testing lelelel", 0, oldStuff, Extension.RB);
        DBHelper.save(test);
        File book = new File("The Adventure of MechaGodzilla", 5, bookIdea, Extension.TXT);
        DBHelper.save(book);
        File civ = new File("Civilization", 100, games, Extension.EXE);
        DBHelper.save(civ);
        File distraction = new File("very distracting game plz delete me", 80, games, Extension.EXE);
        File glorry = new File("Glorry Presentation", 30, presentations, Extension.PPT);
        DBHelper.save(glorry);

        File foundFile = DBHelper.findById(2, File.class);

        List<File> files = DBHelper.getAll(File.class);
        List<Folder> folders = DBHelper.getAll(Folder.class);
        List<Owner> owners = DBHelper.getAll(Owner.class);

        foundFile.setName("test");
        foundFile.setSize(10);

        DBHelper.update(foundFile);

        List<File> foundOldStuff = DBFile.getFilesFromFolder(oldStuff);
        List<Folder> foundFolders = DBFolder.getFoldersFromOwner(ricardo);

        DBHelper.delete(distraction);
    }
}
