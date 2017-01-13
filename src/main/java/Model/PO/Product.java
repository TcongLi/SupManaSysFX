package Model.PO;

public class Product {
    private String id;

    private String name;

    private Double price;

    private String info;

    public Product(){}
    public Product(String id, String name, Double price, String info) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}