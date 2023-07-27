import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product p1 = new Product("Телефон", 200, 0);
        Product p2 = new Product("Машина", 1200, 1);
        Product p3 = new Product("Телевизор", 500, 2);

        Order order = new Order();

        order.addProduct(p1);
        order.addProduct(p2);
        order.addProduct(p3);

        System.out.println(order);

        System.out.print("Введите id для проверки есть ли товар в заказе: ");
        int id = sc.nextInt();

        try {
            Product search = order.searchProductByld(id);
            System.out.println("Товар: " + search);
        }catch(ProductNotFoundException e){
            e.NotFound();
        }

        System.out.println(order);
        System.out.println("Сумма: " + order.calculateTotalsum());
        System.out.println();

        System.out.print("Введите id товара которо хотите удалить: ");
        id = sc.nextInt();

        if(order.removeProductByld(id)){
            System.out.println("Товар был успешно удален!");
        }else{
            System.out.println("Такого товара не существует!");
        }
        System.out.println(order);
        System.out.println("Сумма: " + order.calculateTotalsum());

    }
}
