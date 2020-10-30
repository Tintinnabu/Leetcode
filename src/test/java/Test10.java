import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Tinn
 * @Date: 2020/10/23 8:53
 */
public class Test10 {
    public static void main(String[] args) {

        List<String> userNames = new ArrayList<String>() {{   add("BMW");   add("BENZ");   add("ford");   add("AUDI");}};
        for (String userName : userNames) {
            if (userName.equals("ford")) {
                userNames.remove("ford");
            }
        }
    }
}
