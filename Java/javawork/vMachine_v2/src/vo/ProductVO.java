package vo;

public class ProductVO {
    private String drinkName;
    private int drinkPrice;
    private int drinkStock;

    public ProductVO(String drinkName, int drinkPrice, int drinkStock) {
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.drinkStock = drinkStock;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(int drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public int getDrinkStock() {
        return drinkStock;
    }

    public void setDrinkStock(int drinkStock) {
        this.drinkStock = drinkStock;
    }

    @Override
    public String toString() {
        return "제품명 : " + drinkName + " / " +
                "가격 : " + drinkPrice + " / " +
                "재고 개수 : " + drinkStock;
    }
}
