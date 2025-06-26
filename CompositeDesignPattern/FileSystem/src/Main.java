//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      Directory directory = new Directory("All Movies");
      File file = new File("Inception");
      directory.add(file);
      Directory subDirectory = new Directory("Sci-Fi Movies");
      File subFile1 = new File("Interstellar");
      subDirectory.add(subFile1);
      directory.add(subDirectory);
      directory.list();
    }
}