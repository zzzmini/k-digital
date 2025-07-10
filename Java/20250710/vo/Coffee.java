package vo;

public class Coffee {
    private String product;
    private int price;
    private int sales = 0;

    // Getter
    public String getProduct() {
        return this.product;
    }

    public int getPrice() {
        return this.price;
    }

    public int getSales() {
        return this.sales;
    }

    // Setter
    public void setProduct(String product) {
        this.product = product;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 판매될 때 금액 누적하기
    public void sumPrice() {
        this.sales = this.sales + this.price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "product='" + product + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                '}';
    }
}
