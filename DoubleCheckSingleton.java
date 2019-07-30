package singleton;

import java.util.stream.IntStream;

public class DoubleCheckSingleton {

    private DoubleCheckSingleton(){
        System.out.println("I am initial...");
    }

    private static DoubleCheckSingleton instance;

    public static DoubleCheckSingleton getInstance(){
        if(null==instance){
            synchronized (DoubleCheckSingleton.class){
                if(null==instance){
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance=new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).boxed().forEach(i->{
            new Thread(()->{
                try {
                    while(true){
                        System.out.println(Thread.currentThread().getName()+" "+getInstance());
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }
}