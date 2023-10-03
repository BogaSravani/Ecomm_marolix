package testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Datax {
	@DataProvider(name="user")
	public Object[][] testData() throws IOException {
        File file = new File("./src/test/resources/DataProvider.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook book = new XSSFWorkbook(fis);
        XSSFSheet sheet = book.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        int cells = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rows - 1][2]; // Assuming two columns for username and password
        int validRowCount = 0;

        for (int i = 1; i < rows; i++) {
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

                // Check if both username and password are empty; if both are empty, exit the loop
                if (username.isEmpty() && password.isEmpty()) {
                    break;
                }

                data[validRowCount][0] = username;
                data[validRowCount][1] = password;
                validRowCount++;
            }
        }

        // Resize the data array to exclude any null values
        Object[][] finalData = new Object[validRowCount][2];
        System.arraycopy(data, 0, finalData, 0, validRowCount);

        return finalData;
    }
}







