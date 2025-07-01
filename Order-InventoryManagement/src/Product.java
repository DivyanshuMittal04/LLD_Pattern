public class Product {
    int id = 0;
    String name;

    public Product(String name) {
        this.name = name;
        id += 1;
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
}
