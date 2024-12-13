package vo;

// 제품정보를 담고 있는 클래스
public class Product {
    private String item; // 제품의 이름(콜라, 사이다....)
    private int price; // 제품 단가
    private int stock; // 제품의 재고

    public Product(){}

    public Product(String item, int price, int stock) {
        this.item = item;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "item : '" + item + '\'' +
                ", price : " + price +
                ", stock : " + stock +
                '}';
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
