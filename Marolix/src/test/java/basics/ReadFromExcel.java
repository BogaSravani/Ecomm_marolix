package basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {
public static void main(String[] args) throws Exception, IOException {
	File path=new File("./src/test/resources/Testdata.xlsx");
	FileInputStream fis=new FileInputStream(path);
	 Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("Sheet1");
	 
	 Row r=sh.getRow(0);
	 
	Cell c= r.getCell(0);
	DataFormatter df=new DataFormatter();
	String value=df.formatCellValue(c);
	System.out.println(value);
	wb.close();
	fis.close();
	}
}
