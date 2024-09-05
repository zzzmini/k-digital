package japangi;

import java.util.List;

public class JapangiServieImple implements JapangiServiceInterface{

	@Override
	public void newProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println("newProduct(Product product)");
	}

	@Override
	public void deleteProduct(String name) {
		// TODO Auto-generated method stub
		System.out.println("deleteProduct(String name)");
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println("updateProduct(Product product)");
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		System.out.println("List<Product> selectAll()");
		return null;
	}

	@Override
	public List<Product> selectOne() {
		// TODO Auto-generated method stub
		System.out.println("List<Product> selectOne()");
		return null;
	}

	@Override
	public List<Product> searchKeyword() {
		// TODO Auto-generated method stub
		System.out.println("List<Product> searchKeyword()");
		return null;
	}

}
