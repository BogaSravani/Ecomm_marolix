package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataPP {
@DataProvider(name="user")
public Object[][] getdata() throws IOException
{
	 FileInputStream fis=new FileInputStream("./src/test/resources/DataProvider.xlsx");
	 XSSFWorkbook book=new XSSFWorkbook(fis);
	XSSFSheet sheet= book.getSheetAt(0);
	int rows=sheet.getPhysicalNumberOfRows();
	int cells=sheet.getRow(1).getLastCellNum();
    Object[][] data=new Object[rows-1][cells];
    try {
    for(int i=0;i<rows-1;i++)
    {
    	for(int j=0;j<cells;j++)
    	{
    		DataFormatter format=new DataFormatter();
    		 data[i][j]=format.formatCellValue(sheet.getRow(i+1).getCell(j));
    	}
    }
    }
    catch(Exception e)
    {
    	 e.printStackTrace();
    }
    return data;
}
}
