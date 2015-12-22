import java.util.HashMap;
import jxl.*;
import java.io.File;

/**
 * Created by dreameng on 15/12/22.
 */
public class MyExcelHandler {
     public HashMap<String, KeyWord> readKeyWord(String word_excel) {
        HashMap wordInfo = new HashMap<String, KeyWord>();
        Sheet sheet;
        Workbook book;
        Cell cell1,cell2,cell3;
        try {
            //t.xls为要读取的excel文件名
            book= Workbook.getWorkbook(new File(word_excel));
            //获得第一个工作表对象(ecxel中sheet的编号从0开始
            // ,0,1,2,3,....)
            sheet=book.getSheet(0);
            int i = 0;
            while(true)
            {
                //获取每一行的单元格
                cell1=sheet.getCell(0,i);//（列，行）
                cell2=sheet.getCell(1,i);
                cell3=sheet.getCell(2,i);
                if(("".equals(cell1.getContents())||(cell1.getContents() == null)))    //如果读取的数据为空
                    break;
                KeyWord keyWord = new KeyWord();
                keyWord.setCategory(cell2.getContents());
                keyWord.setScore(Integer.parseInt(cell3.getContents()));
                wordInfo.put(cell1.getContents(), keyWord);
                i++;
            }
            book.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return wordInfo;
    }
}
