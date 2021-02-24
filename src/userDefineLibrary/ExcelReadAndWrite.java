package userDefineLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadAndWrite {

	public static File src;
	public static String exfilepath = "C:\\Users\\User\\eclipse-workspace\\HandleDifferentAlerts\\ExcelReadWriteFile\\AlertReadWrite.xlsx";
	public static FileInputStream fileip;
	public static FileOutputStream fileop;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static String val1;
	public static int row;
	public static XSSFCell cell;
	public static XSSFRow Row;
	public static String promptInput,expected1,expected2;
	

	// READING THE DATA FROM AN EXCEL FILE
	public static int readexcel() throws IOException {
		try {
			src = new File(exfilepath);
			fileip = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileip);
			sheet = workbook.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++)
			{
				if (i == 1) 
				{
					promptInput = (sheet.getRow(i).getCell(0)).getStringCellValue();
					expected1 =(sheet.getRow(i).getCell(1)).getStringCellValue(); 
					expected2 =(sheet.getRow(i).getCell(3)).getStringCellValue(); 
					// System.out.println(promptInput);
					// System.out.println(expected1);
					// System.out.println(expected2);
					row = i;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return row;
	}

	// WRITING THE DATA TO AN EXCELFILE
	public static void writeexcel() {
		try {
			// CLOSE INPUT STREAM
			fileip.close();
			/* CREATE AN OBJECT OF FILEOUTPUT STREAM AND TO WRITE DATA IN AN EXCEL FILE */
			fileop = new FileOutputStream(new File(exfilepath));
			//WRITE DATA IN EXCEL FILE 
			workbook.write(fileop);
			// CLOSE OUTPUT STREAM
			fileop.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
