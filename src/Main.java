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
        products.add(new Product(51961, "Action Figure 1", "boys", 120.0));
        products.add(new Product(61531, "Action Figure 2", "boys", 90.0));
        products.add(new Product(81651, "Action Figure 3", "boys", 200.0));

        System.out.println("-----------------------esercizio 1------------------");
        List<Product> filterBooks = products.stream()
                .filter(product -> "books".equals(product.getCategory()) && product.getPrice() > 100)
                .toList();

        filterBooks.forEach(product ->
                System.out.println("nome del libro: " + product.getName() + " al costo di: " + product.getPrice() + "€"));


        System.out.println("-----------------------esercizio 3------------------");
        List<Product> filterBoys = products.stream()
                .filter(product -> "boys".equals(product.getCategory())).map(product -> {
                    product.setPrice(product.getPrice() * 0.9);
                    return product;
                }).toList();

        filterBoys.forEach(product ->
                System.out.println("nome action figure: " + product.getName() + " al prezzo scontato del 10%: " + product.getPrice() + "€"));
    }
}