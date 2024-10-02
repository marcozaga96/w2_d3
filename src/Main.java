import Classi.Customer;
import Classi.Order;
import Classi.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //creazione prodotti
        List<Product> products = new ArrayList<>();
        products.add(new Product(11561, "libro 1", "books", 120.0));
        products.add(new Product(21561, "lavatrice", "elettrodomestici", 200.0));
        products.add(new Product(34165, "libro 3", "books", 9.9));
        products.add(new Product(41165, "libro 4", "books", 170.7));
        products.add(new Product(51961, "Action Figure 1", "boys", 120.0));
        products.add(new Product(61531, "Action Figure 2", "boys", 90.0));
        products.add(new Product(81651, "Action Figure 3", "boys", 200.0));
        products.add(new Product(1L, "bambola 1", "baby", 15.0));
        products.add(new Product(2L, "bambola 2", "baby", 25.0));
        products.add(new Product(3L, "bambola 3", "boys", 120.0));

        //creazione utenti
        Customer utente1 = new Customer(1, "marco", 2);
        Customer utente2 = new Customer(2, "giuseppe", 1);
        Customer utente3 = new Customer(3, "luca ", 3);
        Customer utente4 = new Customer(4, "aldo", 2);

        //creazione ordini
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1, "spedito", LocalDate.of(2024, 9, 29), LocalDate.of(2024, 10, 4), List.of(products.get(0), products.get(9)), utente1));
        orderList.add(new Order(2, "consegnato", LocalDate.of(2024, 9, 15), LocalDate.of(2024, 9, 23), List.of(products.get(2), products.get(5)), utente2));
        orderList.add(new Order(3, "in cosegna", LocalDate.of(2024, 9, 25), LocalDate.of(2024, 9, 2), List.of(products.get(8), products.get(9)), utente3));
        orderList.add(new Order(2, "consegnato", LocalDate.of(2024, 9, 17), LocalDate.of(2024, 9, 25), List.of(products.get(3), products.get(7)), utente4));


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

        System.out.println("-----------------------esercizio 2------------------");
        List<Order> filterBaby = orderList.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> "baby".equals(product.getCategory())))
                .toList();
        filterBaby.forEach(order -> System.out.println("ordine con id: " + order.getId() + " si trova in stato di: " + order.getStatus()));

        System.out.println("-----------------------esercizio 4------------------");


    }
}