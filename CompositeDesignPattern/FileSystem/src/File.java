public class File implements FileSystem {
    String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void list() {
        System.out.println("File name is " + name);
    }
}
