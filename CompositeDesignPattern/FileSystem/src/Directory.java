import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    private String name;
    private List<FileSystem> fileSystems;

    public Directory(String name) {
        this.name = name;
        this.fileSystems = new ArrayList<>();
    }

    public void add(FileSystem fileSystem) {
        fileSystems.add(fileSystem);
    }

    @Override
    public void list() {
        System.out.println("Directory: " +  name);
        for (FileSystem fileSystem : fileSystems) {
            fileSystem.list();
        }
    }
}
