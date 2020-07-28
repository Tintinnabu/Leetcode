package top.tinn.CS_Notes.DesignPattern.structural_pattern.BridgePattern;

/**
 * @ClassName RefindedAbstraction
 * @Description
 * @Author Tinn
 * @Date 2020/4/13 13:36
 */
public class RefindedAbstraction extends Abstraction {
    @Override
    public void operation() {
        impl.operationImpl();
    }
}
