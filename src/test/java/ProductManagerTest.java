import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(1, "Книга", 100);
    Product product2 = new Product(2, "Смартфон", 1000);
    Product product3 = new Product(3, "Смартфон2", 2000);
    Product product4 = new Book(4, "Облава", 1000, "В.Быков");
    Product product5 = new Smartphone(5, "Nokia", 10000, "Finland");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
    }

    @Test
    public void shouldAdd() {

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductByNameTwo() {

        Product[] expected = new Product[]{product2, product3};
        Product[] actual = manager.searchBy("Смарт");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductByNameOne() {

        Product[] expected = new Product[]{product1};
        Product[] actual = manager.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductByNameNull() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Мороз");

        Assertions.assertArrayEquals(expected, actual);
    }

}
