package repository;

import myInterface.ArrayListInterface;
import vo.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRepository implements ArrayListInterface {

    // 상품목록(상품명, 금액, 재고) 정보를 담는 저장공간
    List<Product> productList = new ArrayList<>();

    @Override
    public boolean insert(Product product) {
        productList.add(product);
        System.out.println(productList);
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
    public int findIndex(String name) {
        for (Product x : productList) {
            if (x.getItem().equals(name)) {
                return productList.indexOf(x);
            }
        }
        return -1;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
}
