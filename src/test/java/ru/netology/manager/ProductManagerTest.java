package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Phone;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Book1", 1660, "Author1");
    private Book secondBook = new Book(2, "Book2", 700, "Author2");
    private Phone firstPhone = new Phone(3, "Mi9", 30000, "Xiaomi");
    private Phone secondPhone = new Phone(4, "IphoneX", 60000, "Apple");
    private Phone thirdPhone = new Phone(5, "Iphone7", 20000, "Apple");

    @BeforeEach
    public void setup() {
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(firstPhone);
        repository.save(secondPhone);
    }


    @Test
    void searchNameInBooks() {
        Product[] actual = manager.searchBy("Book1");
        Product[] expected = new Product[]{firstBook};
        assertArrayEquals(expected, actual);

    }
    @Test
    void searchAuthorInBooks() {
        Product[] actual = manager.searchBy("Author2");
        Product[] expected = new Product[]{secondBook};
        assertArrayEquals(expected, actual);

    }
    @Test
    void searchNameInPhone() {
        Product[] actual = manager.searchBy("Mi9");
        Product[] expected = new Product[]{firstPhone};
        assertArrayEquals(expected, actual);
    }
    @Test
    void searchManufacturerInPhone() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{secondPhone};
        assertArrayEquals(expected, actual);
    }
    @Test
    void returnEmptySet() {
        repository.removeById(1);
        repository.removeById(2);
        repository.removeById(3);
        repository.removeById(4);
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }
    @Test
    void returnSetWithSomeElements() {
        repository.save(thirdPhone);
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{secondPhone,thirdPhone};
        assertArrayEquals(expected, actual);
    }

}