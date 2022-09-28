import java.util.*;

interface Repository<T, K> {

    default T save(T entity) {
        return null;
    }

    Optional<T> findById(K id);
    Collection<T> findAll();
    T delete(T entity);
    K deleteById(K id);
}

class BookShelf implements Repository<Book, Long> {

    private final List<Book> books;

    public BookShelf() {
        this.books = new LinkedList<>();
    }


    @Override
    public Book save(Book entity) {
        books.add(entity);
        return entity;
    }

    @Override
    public Optional<Book> findById(Long id) {
        int loc = getIdx(id);
        return Optional.ofNullable(
                loc > -1 ? books.get(loc) : null
        );
    }

    @Override
    public Collection<Book> findAll() {
        return Collections.unmodifiableCollection(books);
    }

    @Override
    public Book delete(Book entity) {
        books.remove(entity);
        return entity;
    }

    @Override
    public Long deleteById(Long id) {
        int loc = getIdx(id);
        if (loc > -1) {
            books.remove(loc);
        }
        return id;
    }

    private int getIdx(Long id) {
        int loc = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getSn() == id) {
                loc = i;
                break;
            }
        }
        return loc;
    }
}

class Book {
    private final long sn;
    private String title;
    private String author;

    public Book(long sn, String title, String author) {
        this.sn = sn;
        this.title = title;
        this.author = author;
    }

    public long getSn() {
        return sn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Book) {
            return this.sn == ((Book) o).getSn();
        } else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sn);
    }
}