import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


public class ProductRepositoryTest {

    Product product1 = new Product(1, "Книга", 100);
    Product product2 = new Product(2, "Смартфон", 1000);
    Product product3 = new Product(3, "Смартфон2", 2000);
    Product product4 = new Book(4, "Облава", 1000, "В.Быков");
    Product product5 = new Smartphone(5, "Nokia", 10000, "Finland");


    @Test
    public void shouldRemove() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAdd() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByID2() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);

        Product[] expected = {product2};
        Product[] actual = {repo.findById(2)};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByID5() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);

        Product[] expected = {product5};
        Product[] actual = {repo.findById(5)};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByID7() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);

        Product[] expected = {null};
        Product[] actual = {repo.findById(7)};

        Assertions.assertArrayEquals(expected, actual);

    }


}
