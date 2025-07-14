package interfaceAndAbstract;

public interface Crud {
    public void create();  // 생성

    public String read();  // 데이터 읽기

    public void update(int id);

    public boolean delete(int id);
}
