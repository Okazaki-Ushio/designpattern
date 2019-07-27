package singleton;

public class AnonymousSingleton {

    public static Anonymous getInstance(){
        return Anonymous.instance;
    }

    private static class Anonymous{
        private Anonymous(){
            System.out.println("I am initial...");
        }

        private static Anonymous instance=new Anonymous();
    }

    public static void main(String[] args) {
        System.out.println("begin the main phase...");
        Anonymous instance = AnonymousSingleton.getInstance();
        System.out.println(instance);
        Anonymous instance1 = AnonymousSingleton.getInstance();
        System.out.println(instance1);
    }
}
