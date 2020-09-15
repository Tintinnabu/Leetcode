package top.tinn.CS_Notes.DesignPattern.creational_pattern.SingletonPattern.懒汉式;

/**
 * @ClassName LazySingleton
 * @Description 懒汉式单例
 * @Author Tinn
 * @Date 2020/4/12 15:15
 */
public class   LazySingleton {
    /**
     * volatile 保证可见性
     */
    private volatile static LazySingleton instance = null;
    private LazySingleton(){}

    /*synchronized public static LazySingleton getInstance(){
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }*/

    /**
     * 双重检查锁定(Double-Check
     * Locking)
     * @return
     */
     public static LazySingleton getInstance(){
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null)
                    instance = new LazySingleton();
            }
        }
        return instance;
    }
}
