import java.util.LinkedList;
import java.util.List;

//  Composite
class Cart implements Product {
    private final List<Product> products;

    public Cart() {
        this.products = new LinkedList<>();
    }

    public boolean add(Product product) {
        return products.add(product);
    }

    public boolean remove(Product product) {
        return products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void setPrice(int price) {

    }

    @Override
    public int getPrice() {
        return products
                .stream()
                .map(Product::getPrice)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
