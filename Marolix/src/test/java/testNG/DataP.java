package testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataP {
	@DataProvider(name="user")
public Object[][] m1() throws IOException
{	 
		File file=new File("./src/test/resources/DataProvider.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheetAt(0);
		int rows=sheet.getPhysicalNumberOfRows();
		int cells=sheet.getRow(1).getLastCellNum();
		 Object[][] data= new Object[rows-1][cells];
		for(int i=0;i<rows-1;i++)
		{
			for(int j=0;j<cells;j++)
			{
				 if(sheet.getRow(i+1).getCell(j,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)==null)
				 {
					 data[i][j]=" ";
				 }                                                                        
						DataFormatter df=new DataFormatter();
					  data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				 
			}
		}
		 
		 return data;
}

}
