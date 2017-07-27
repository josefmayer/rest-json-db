package data.Product;

public class Product {

    public Product() {}
    public Product(String name, Attributes attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    private String name;
    private Attributes attributes;

    public String getName() {
        return name;
    }

    public Attributes getAttributes() {
        return attributes;
    }

}
