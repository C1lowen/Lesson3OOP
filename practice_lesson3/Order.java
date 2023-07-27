import java.util.Arrays;

public class Order {
    private final Product[] products;

     public Order() {
        products = new Product[100];
    }

    public Product[] getProducts() {
        return products;
    }


    public void addProduct(Product product){
       if(product != null){
           for(int i = 0; i < products.length; i++){
               if(products[i] == null){
                   products[i] = product;
                   return;
               }
           }
       }else{
           System.out.println("Вы не передали никакой товар");
       }
    }

    public Product searchProductByld(int id) throws ProductNotFoundException{
        for(int i = 0; i < products.length; i++){
            if(products[i] != null && products[i].getId() == id){
                return products[i];
            }
        }
        throw new ProductNotFoundException();
    }

    public boolean removeProductByld(int id){
        for(int i = 0; i < products.length; i++){
            if(products[i] != null && products[i].getId() == id){
                products[i] = null;
                return true;
            }
        }
        return false;
    }

    public int calculateTotalsum(){
        int sum = 0;
        for(int i = 0; i < products.length; i++){
            if(products[i] != null ){
               sum += products[i].getPrice();
            }
        }
        return sum;
    }
    @Override
    public String toString() {
        String result = "Order" + System.lineSeparator();

        for(int i = 0; i < products.length; i++){
            if(products[i] != null){
                result += products[i].toString() + System.lineSeparator();
            }
        }
        return result;
    }
}
