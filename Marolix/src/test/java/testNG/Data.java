package testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "user")
    public Object[][] testData() throws IOException {
        File file = new File("./src/test/resources/DataProvider.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook book = new XSSFWorkbook(fis);
        XSSFSheet sheet = book.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        int cells = sheet.getRow(0).getLastCellNum();
        int totalDataSets = 8; // Specify the total number of data sets you want to use
        Object[][] data = new Object[totalDataSets][2]; // Assuming two columns for username and password

        for (int i = 1; i <= totalDataSets; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                XSSFCell usernameCell = row.getCell(0);
                XSSFCell passwordCell = row.getCell(1);

                String username = "";
                String password = "";

                if (usernameCell != null) {
                    usernameCell.setCellType(CellType.STRING); // Treat username cell as string
                    username = usernameCell.getStringCellValue().trim();
                }

                if (passwordCell != null) {
                    passwordCell.setCellType(CellType.STRING); // Treat password cell as string
                    password = passwordCell.getStringCellValue().trim();
                }

                data[i - 1][0] = username;
                data[i - 1][1] = password;
            }
        }

        return data;
    }
}












/**
	    File file = new File("./src/test/resources/DataProvider.xlsx");
	    FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook book = new XSSFWorkbook(fis);
	    XSSFSheet sheet = book.getSheetAt(0);
	    int rows = sheet.getPhysicalNumberOfRows();
	    int cells = sheet.getRow(0).getLastCellNum();
	    Object[][] data = new Object[rows - 1][cells];
	   for(int i=0;i<rows-1;i++)
	   {
		   XSSFRow row=sheet.getRow(i+1);
		   for(int j=0;j<cells;j++)
		   {
			   XSSFCell cell=row.getCell(j);
			   DataFormatter format=new DataFormatter();
			   data[i][j]=format.formatCellValue(cell);
	        }
	    }
	    return data;
	}**/
    

