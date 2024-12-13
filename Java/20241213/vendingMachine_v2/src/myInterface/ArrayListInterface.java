package myInterface;

import vo.Product;

import java.util.List;

public interface ArrayListInterface {
    public boolean insert(Product product);

    public boolean update(int index, Product product);

    boolean delete(int index);

    Product findByName(String name);

    List<Product> findAll();
}
