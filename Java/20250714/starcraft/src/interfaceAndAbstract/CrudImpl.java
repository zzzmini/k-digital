package interfaceAndAbstract;

public class CrudImpl implements Crud{
    @Override
    public void create() {
        System.out.println("데이터를 입력했어요");
    }

    @Override
    public String read() {
        return "데이터를 읽었어요";
    }

    @Override
    public void update(int id) {
        System.out.println(id + "를 수정했어요");
    }

    @Override
    public boolean delete(int id) {
        System.out.println(id + "를 정상 삭제 했어요");
        return true;
    }
}
