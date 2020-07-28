package top.tinn.CS_Notes.DesignPattern.creational_pattern.SingletonPattern.饿汉式;

/**
 * @ClassName EagerSingleton
 * @Description 饿汉式单例类
 * @Author Tinn
 * @Date 2020/4/12 15:14
 */
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() {
    }
    public static EagerSingleton getInstance(){
        return instance;
    }
}
