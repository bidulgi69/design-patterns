import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class DecoratorTests {

    @Test
    @Order(5)
    public void test5() {
        //  without decorator
        Repository<Book, Long> repository = new BookShelf();
        //  with decorator
        Repository<Book, Long> repositoryWithLogger = new RepositoryLogger(
                new BookShelf()
        );

        Book book1 = getInstance();

        repository.save(book1);
        Assertions.assertEquals(
                0,
                StandardOut.logs.size()
        );
        repositoryWithLogger.save(book1);
        Assertions.assertEquals(
                1,
                StandardOut.logs.size()
        );
        Assertions.assertTrue(
                StandardOut.logs.get(0).startsWith("(save)")
        );
    }

    @Test
    @Order(0)
    public void test0_repository_save() {
        Repository<Book, Long> repository = new BookShelf();
        Book book = getInstance();

        Assertions.assertEquals(
                book,
                repository.save(book)
        );
    }

    @Test
    @Order(1)
    public void test1_repository_findById() {
        Repository<Book, Long> repository = new BookShelf();
        Book book = getInstance();

        repository.save(book);

        Assertions.assertEquals(
                book,
                repository.findById(book.getSn())
                        .orElseThrow()
        );
    }

    @Test
    @Order(2)
    public void test2_repository_findAll() {
        Repository<Book, Long> repository = new BookShelf();
        Book book = getInstance();

        repository.save(book);
        Assertions.assertEquals(
                1,
                repository.findAll().size()
        );

        repository.save(book);
        Assertions.assertEquals(
                2,
                repository.findAll().size()
        );
    }

    @Test
    @Order(3)
    public void test3_repository_delete() {
        Repository<Book, Long> repository = new BookShelf();
        Book book = getInstance();

        repository.save(book);
        Assertions.assertEquals(
                book,
                repository.findById(book.getSn())
                        .orElseThrow()
        );

        Assertions.assertEquals(
                book,
                repository.delete(book)
        );
    }

    @Test
    @Order(4)
    public void test4_repository_deleteById() {
        Repository<Book, Long> repository = new BookShelf();
        Book book = getInstance();

        repository.save(book);
        Assertions.assertEquals(
                book,
                repository.findById(book.getSn())
                        .orElseThrow()
        );

        Assertions.assertEquals(
                book.getSn(),
                repository.deleteById(book.getSn())
        );
    }

    private Book getInstance() {
        return new Book(
                1,
                "The Hunger Games",
                "Suzanne Collins"
        );
    }
}
