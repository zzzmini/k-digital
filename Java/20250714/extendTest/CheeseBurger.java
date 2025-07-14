package extendTest;

public class CheeseBurger extends Hamburger {
    private String name = "치즈햄버거";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CheeseBurger{" +
                "name='" + this.name + '\'' +
                ", mat_1 = " + super.getMat_1() + "\" + " +
                ", mat_2 = " + super.getMat_2() + "\" + " +
                '}';
    }
}
