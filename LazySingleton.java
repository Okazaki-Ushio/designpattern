package singleton;

import java.util.stream.IntStream;

public class LazySingleton {

    private LazySingleton(){
        System.out.println("I am initial...");
    }

    private static LazySingleton instance;

    public static LazySingleton getInstance(){
        if(null==instance){
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance=new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
     /*   System.out.println("begin the main phase");
        LazySingleton instance = getInstance();
        System.out.println(instance);
        LazySingleton instance1 = getInstance();
        System.out.println(instance1);*/
        IntStream.rangeClosed(1,100).boxed().forEach(i->{
            new Thread(()->{
                while (true) {
                    LazySingleton instance = getInstance();
                    System.out.println(Thread.currentThread().getName()+" "+instance);
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
    }
}
