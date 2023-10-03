package basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel2 {
public static void main(String[] args) throws IOException {
	File path=new File("./src/test/resources/Testdata.xlsx");
	FileInputStream fis=new FileInputStream(path);
	XSSFWorkbook book=new XSSFWorkbook(fis);
	Sheet sh=book.getSheetAt(1);
	int rows=sh.getPhysicalNumberOfRows();
	int cells=sh.getRow(0).getLastCellNum();
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<cells;j++) {
			DataFormatter format=new DataFormatter();
			System.out.println(format.formatCellValue(sh.getRow(i).getCell(j)));
		}
	}
	book.close();
	fis.close();
	
	/**File file=new File("./src/test/resources/DataProvider.xlsx");
	FileInputStream fis=new FileInputStream(file);
	XSSFWorkbook book=new XSSFWorkbook();
	Sheet sheet=book.getSheet("Sheet1");
	int rows=sheet.getPhysicalNumberOfRows();
	int cells=sheet.getRow(1).getLastCellNum();
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<cells;j++)
		{
		DataFormatter dg=new DataFormatter();
		String value=dg.formatCellValue(sheet.getRow(i).getCell(j));
		System.out.println(value);
		}
	}
	book.close();
	fis.close();**/
}
}
