package interfaceAndAbstract;

public class CrudMain {
    public static void main(String[] args) {
        Crud crud = new CrudImpl();
        crud.create();
        crud.read();
        boolean delete = crud.delete(3);
        System.out.println(delete);
        crud.update(7);

    }
}
