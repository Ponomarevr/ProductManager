import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    @Test
    public void testWhenFewProductsFound() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "BookTitle1", 500, "Author1");
        Book book2 = new Book(2, "Book2", 550, "Author2");
        Book book3 = new Book(3, "BookTitle3", 600, "Author3");
        Smartphone smart1 = new Smartphone(5, "SmartPhone1", 12_000, "ChinaTown");
        Smartphone smart2 = new Smartphone(6, "SmartPhone2", 11_000, "ChinaTown");
        Smartphone smart3 = new Smartphone(7, "SmartPhone3", 8_000, "ChinaTown");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("Title");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testWhenNothingFound() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "BookTitle1", 500, "Author1");
        Book book2 = new Book(2, "Book2", 550, "Author2");
        Book book3 = new Book(3, "BookTitle3", 600, "Author3");
        Smartphone smart1 = new Smartphone(5, "SmartPhone1", 12_000, "ChinaTown");
        Smartphone smart2 = new Smartphone(6, "SmartPhone2", 11_000, "ChinaTown");
        Smartphone smart3 = new Smartphone(7, "SmartPhone3", 8_000, "ChinaTown");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        Product[] expected = {};
        Product[] actual = manager.searchBy("Netology");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testWhenOneProductFound() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "BookTitle1", 500, "Author1");
        Book book2 = new Book(2, "Book2", 550, "Author2");
        Book book3 = new Book(3, "BookTitle3", 600, "Author3");
        Smartphone smart1 = new Smartphone(5, "SmartPhone1", 12_000, "ChinaTown");
        Smartphone smart2 = new Smartphone(6, "SmartPhone2", 11_000, "ChinaTown");
        Smartphone smart3 = new Smartphone(7, "SmartPhone3", 8_000, "ChinaTown");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        Product[] expected = {smart2};
        Product[] actual = manager.searchBy("SmartPhone2");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveWhenExist() {
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(1, "BookTitle1", 500, "Author1");
        Book book2 = new Book(2, "Book2", 550, "Author2");
        Book book3 = new Book(3, "BookTitle3", 600, "Author3");
        Smartphone smart1 = new Smartphone(5, "SmartPhone1", 12_000, "ChinaTown");
        Smartphone smart2 = new Smartphone(6, "SmartPhone2", 11_000, "ChinaTown");
        Smartphone smart3 = new Smartphone(7, "SmartPhone3", 8_000, "ChinaTown");

        repo.Save(book1);
        repo.Save(book2);
        repo.Save(book3);
        repo.Save(smart1);
        repo.Save(smart2);
        repo.Save(smart3);
        repo.removeById(3);
        Product[] expected = {book1, book2, smart1, smart2, smart3};
        Product[] actual = repo.findAll();

        Assert.assertArrayEquals(expected, actual);


    }
}


