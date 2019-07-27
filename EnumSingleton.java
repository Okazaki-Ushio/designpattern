package singleton;

public enum EnumSingleton {
    ENUM_FIEST,ENUM_SECOND;

    public EnumSingleton getInstance(){
        return ENUM_FIEST;
    }

    public static void main(String[] args) {
        System.out.println("begin the main phase..");
        EnumSingleton instance = EnumSingleton.ENUM_FIEST.getInstance();
        System.out.println(instance.hashCode());
        EnumSingleton instance1 = EnumSingleton.ENUM_SECOND.getInstance();
        System.out.println(instance1.hashCode());
    }
}
