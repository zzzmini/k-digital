package test;

public record BookDto(int id,
                      String name,
                      int age,
                      String addr) {
    public static BookDto of(int id, String name, int age, String address){
        return new BookDto(id, name, age, address);
    }
    public static BookDto from(BookEntity entity){
        return new BookDto(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getAddr()
        );
    }
    public BookEntity toEntity(){
        BookEntity entity = new BookEntity();
        entity.setId(this.id);
        entity.setName(name);
        entity.setAge(age);
        entity.setAddr(addr);
        return entity;
    }
}
