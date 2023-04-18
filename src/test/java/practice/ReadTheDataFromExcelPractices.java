package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;







public class ReadTheDataFromExcelPractices {

	public static void main(String[] args) throws Exception {
		//step1:open the file in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step2:create workbook
	Workbook wb=	WorkbookFactory.create(fis);
	//step3:get control of sheet
	Sheet sh=wb.getSheet("CONTACTS");
	
	//step4:get control of row
	Row rw=sh.getRow(4);
	
	//step5:get control of cell
	Cell ce=rw.getCell(2);
	
	//step6:
	String value=ce.getStringCellValue();
	System.out.println(value);
	
		

	}

}
