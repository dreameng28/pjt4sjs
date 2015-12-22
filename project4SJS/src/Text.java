import java.util.HashMap;

/**
 * Created by dreameng on 15/12/22.
 */
public class Text {
    public static void main(String[] args) {
        MyExcelHandler handler = new MyExcelHandler();
        HashMap<String, KeyWord> hm;
        hm = handler.readKeyWord("/Users/dreameng/github/pjt4sjs/keyword.xls");
        for (String key : hm.keySet()) {
            System.out.println(key);
            System.out.println(hm.get(key).getCategory() + "  " + hm.get(key).getScore() + "\n");
        }
    }
}
