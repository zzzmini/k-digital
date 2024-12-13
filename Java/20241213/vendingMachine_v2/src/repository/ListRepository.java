package repository;

import myInterface.ArrayListInterface;
import vo.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRepository implements ArrayListInterface {
    @Override
    public boolean insert(Product product) {
        InitArrayList.productList.add(product);
        System.out.println(InitArrayList.productList);
        return true;
    }

    @Override
    public boolean update(int index, Product product) {
        InitArrayList.productList.set(index, product);
        return true;
    }

    @Override
    public boolean delete(int index) {
        InitArrayList.productList.remove(index);
        return false;
    }

    @Override
    public Product findByName(String name) {
        for (Product x : InitArrayList.productList) {
            if (x.getItem().equals(name)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public int findIndex(String name) {
        for (Product x : InitArrayList.productList) {
            if (x.getItem().equals(name)) {
                return InitArrayList.productList.indexOf(x);
            }
        }
        return -1;
    }

    @Override
    public List<Product> findAll() {
        return InitArrayList.productList;
    }
}
