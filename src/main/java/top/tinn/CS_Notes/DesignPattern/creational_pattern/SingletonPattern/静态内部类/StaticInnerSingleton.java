package top.tinn.CS_Notes.DesignPattern.creational_pattern.SingletonPattern.静态内部类;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class StaticInnerSingleton {

    private StaticInnerSingleton(){

    }

    private static class SingletonHolder{
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getSingleton(){
        return SingletonHolder.INSTANCE;
    }
}
