public class Product {
    private String description;
    private int price;
    private int id;

    public Product(String description, int price, int id) {
        checkPrice(price);
        this.description = description;
        this.price = price;
        this.id = id;
    }

    public Product() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        checkPrice(price);
        this.price = price;
    }

   private void checkPrice(int price){
        if(price < 0){
            throw new IllegalArgumentException("Цена должна быть больше нуля");
        }
   }
    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
