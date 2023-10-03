package basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataTOExcel {
public static void main(String[] args) throws Exception {
	File path=new File("./src/test/resources/writetestdata.xlsx");
	FileInputStream fis=new FileInputStream(path);
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("Sheet1"); 
	FileOutputStream fos=new FileOutputStream(path);
	Row row=sh.createRow(1);
    row.createCell(2).setCellValue("hello");
    book.write(fos);
	fos.flush();
	 System.out.println("written");
	 
	
}
}
