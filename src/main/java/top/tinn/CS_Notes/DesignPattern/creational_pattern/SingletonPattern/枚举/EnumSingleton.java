package top.tinn.CS_Notes.DesignPattern.creational_pattern.SingletonPattern.枚举;

public enum EnumSingleton {
    INSTANCE("EnumSingleton");

    private String objName;

    public String getObjName(){
        return objName;
    }

    private EnumSingleton(String name){
        objName = name;
    }

    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        System.out.println(singleton.getObjName());
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        System.out.println(singleton == singleton1);
    }
}
