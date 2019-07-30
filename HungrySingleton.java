package singleton;

public class HungrySingleton {

    private HungrySingleton(){
        System.out.println("I am initial...");
    };

    private static final HungrySingleton singleton=new HungrySingleton();

    public static HungrySingleton getInstance(){
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println("begin to do the main work...");
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
    }
}