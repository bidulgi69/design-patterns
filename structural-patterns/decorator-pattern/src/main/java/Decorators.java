import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


class RepositoryDecorator<T, K> implements Repository<T, K> {
    private final Repository<T, K> wrappee;

    public RepositoryDecorator(Repository<T, K> wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public T save(T entity) {
        return wrappee.save(entity);
    }

    @Override
    public Optional<T> findById(K id) {
        return wrappee.findById(id);
    }

    @Override
    public Collection<T> findAll() {
        return wrappee.findAll();
    }

    @Override
    public T delete(T entity) {
        return wrappee.delete(entity);
    }

    @Override
    public K deleteById(K id) {
        return wrappee.deleteById(id);
    }
}

class RepositoryLogger extends RepositoryDecorator<Book, Long> {

    public RepositoryLogger(Repository<Book, Long> wrappee) {
        super(wrappee);
    }

    @Override
    public Book save(Book entity) {
        StandardOut.logs.add("(save) Adding new book with id: " + entity.getSn());
        return super.save(entity);
    }

    @Override
    public Optional<Book> findById(Long id) {
        StandardOut.logs.add("(findById) Finding a book with id: " + id);
        return super.findById(id);
    }

    @Override
    public Collection<Book> findAll() {
        StandardOut.logs.add("(findAll) Find all books.");
        return super.findAll();
    }

    @Override
    public Book delete(Book entity) {
        StandardOut.logs.add("(delete) Delete a book with id: " + entity.getSn());
        return super.delete(entity);
    }

    @Override
    public Long deleteById(Long id) {
        StandardOut.logs.add("(deleteById) Delete a book with id: " + id);
        return super.deleteById(id);
    }
}

class StandardOut {
    static final List<String> logs;

    static {
        logs = new ArrayList<>();
    }
}