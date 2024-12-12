package repository;

import myInterface.ArrayListInterface;
import vo.Product;

import java.util.ArrayList;
import java.util.List;

public class ListRepository implements ArrayListInterface {

    List<Product> productList = new ArrayList<>();

    @Override
    public boolean insert(Product product) {
        productList.add(product);
        return true;
    }

    @Override
    public boolean update(int index, Product product) {
        productList.set(index, product);
        return true;
    }

    @Override
    public boolean delete(int index) {
        productList.remove(index);
        return false;
    }

    @Override
    public Product findByName(String name) {
        for (Product x : productList) {
            if (x.getItem().equals(name)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
}
