import Classi.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(11561, "libro 1", "books", 120.0));
        products.add(new Product(21561, "lavatrice", "elettrodomestici", 200.0));
        products.add(new Product(34165, "libro 3", "books", 9.9));
        products.add(new Product(41165, "libro 4", "books", 17.7));


        List<Product> filterProducts = products.stream()
                .filter(product -> "books".equals(product.getCategory()) && product.getPrice() > 100)
                .toList();

        filterProducts.forEach(product -> System.out.println("nome del libro: " + product.getName() + " al costo di: " + product.getPrice() + "€"));
    }
}