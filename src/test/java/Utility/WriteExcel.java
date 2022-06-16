package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	XSSFRow row1;
	XSSFRow row2;
	XSSFRow row3;
	XSSFRow row4;
	
	public void writeExcel() throws IOException {
		FileInputStream inputStream = new FileInputStream("C:\\Users\\Jordan Liu\\eclipse-workspace\\Phase2-Swiggy_App_In_Diff_Env\\Excel\\TestData.xlsx");
		XSSFWorkbook WorkB = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = WorkB.getSheet("TestData");
		row1 = sheet.getRow(1);
		row1.getCell(1).setCellValue("Hyderabadi Signature Paneer Bucket Biryani");
		row1.getCell(2).setCellValue("Paneer Makhani Bucket Biryani");
		row1.getCell(2).setCellValue("Awadhi Boneless Chicken Bucket Biryani");
		row1.getCell(2).setCellValue("Hyderabadi Boneless Chicken Bucket Biryani");
		FileOutputStream outputStream = new FileOutputStream(
				"C:\\Users\\Jordan Liu\\eclipse-workspace\\Phase2-Swiggy_App_In_Diff_Env\\Excel\\TestData.xlsx");
		WorkB.write(outputStream);
		WorkB.close();
	}
}