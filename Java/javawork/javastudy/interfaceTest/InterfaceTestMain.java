package interfaceTest;

public class InterfaceTestMain {
    static void joystick(WildAnimalImpl wildAnimal){
        wildAnimal.down();
        wildAnimal.up();
        wildAnimal.left();
        wildAnimal.right();
        wildAnimal.attack();
    }
    static void joystick(MildAnimalImpl mildAnimal){
        mildAnimal.down();
        mildAnimal.up();
        mildAnimal.left();
        mildAnimal.right();
        System.out.println(mildAnimal.hide());
        mildAnimal.gathering();
    }

    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.gathering();
        System.out.println(cow.hide());
        System.out.println("===========================");
        Tiger tiger = new Tiger();
        Rhino rhino = new Rhino();
        joystick(cow);
        System.out.println("===========================");
        tiger.attack();
        tiger.down();
    }
}
