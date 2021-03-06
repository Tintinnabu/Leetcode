package top.tinn.CS_Notes.DesignPattern.creational_pattern.PrototypePattern.DeepCopy;

import java.io.Serializable;

/**
 * @ClassName Attachment
 * @Description
 * @Author Tinn
 * @Date 2020/4/12 16:39
 */
public class Attachment implements Serializable {

    private String name;
    public void download(){
        System.out.println("下载"+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
