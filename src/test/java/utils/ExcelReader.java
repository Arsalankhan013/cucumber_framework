package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    static Workbook book;
    static Sheet sheet;


    public static void openExcel(String filepath){


        try {
            FileInputStream fis=new FileInputStream(filepath);
            book=new XSSFWorkbook(fis);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void getSheet(String sheetName) {
      sheet=  book.getSheet(sheetName);
    }

    public static int getRowCount(){
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColsCount(int rowIndex){
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    //this method will give the cell data in string format
    public static String getCellData(int rowIndex, int colIndex){
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }

   public static List<Map<String,String>> excelListintoMap(String filepath, String sheetname){
openExcel(filepath);
getSheet(sheetname);

List<Map<String,String>> listdata=new ArrayList<>();

for(int row=1; row<getRowCount(); row ++){


    Map<String,String> maprow=new LinkedHashMap<>();

    for(int col=0; col<getColsCount(row); col++){
        maprow.put(getCellData(0,col),getCellData(row,col));
    }
    listdata.add(maprow);
}
     return listdata;
   }


}
