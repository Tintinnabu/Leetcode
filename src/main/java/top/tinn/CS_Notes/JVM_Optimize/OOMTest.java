package top.tinn.CS_Notes.JVM_Optimize;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Tinn
 * @Date: 2020/10/15 9:17
 */
public class OOMTest {
    //JVM设置


    //-Xms30M -Xmx30M -Xmn10M -XX:+PrintGCDetails -XX:PermSize=10m -XX:MaxPermSize=10m -XX:+UseConcMarkSweepGC -XX:+HeapDumpOnOutOfMemoryError


    static  class  OOMObject {
    }





    public  static  void  main(String[] args) {

        List<OOMObject> list =  new ArrayList<OOMObject>();





        while  ( true ) {


            list.add( new  OOMObject());


        }


    }
}
