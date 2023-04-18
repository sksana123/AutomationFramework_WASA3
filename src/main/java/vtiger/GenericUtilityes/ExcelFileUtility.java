package vtiger.GenericUtilityes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileUtility {
	


	public String readDataFromExcel(String sheet,int row,int cel) throws Exception
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelPath);
		
		Workbook wb=WorkbookFactory.create(fis);
		
		 Sheet sh=wb.getSheet(sheet);
		String value=sh.getRow(row).getCell(cel).getStringCellValue();
		
		return value;
	}
	
	
	
	
public int getRowCount(String sheet) throws Exception
{
	FileInputStream fis=new FileInputStream(IConstantUtility.ExcelPath);
	
	Workbook wb=WorkbookFactory.create(fis);
	
	 Sheet sh=wb.getSheet(sheet);
	 
	 int rowcount=sh.getLastRowNum();
	 return rowcount;
	
}

public void writeDataIntoExcel(String sheet,int row,int cel,String value) throws Exception
{
FileInputStream fis=new FileInputStream(IConstantUtility.ExcelPath);
	
	Workbook wb=WorkbookFactory.create(fis);
	
	 Sheet sh=wb.getSheet(sheet);
	 
	 Row rw=sh.getRow(row);
	 
	 rw.createCell(cel).setCellValue(value);
	 
	 FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	 
	 wb.write(fos);
	 System.out.println("data added");
	 
}





public Object[][] readTheDataFromExcelToDataProvider(String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IConstantUtility.ExcelPath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetname);
	 int lastrow=sh.getLastRowNum();
	 int lastcell=sh.getRow(0).getLastCellNum();
	 
	 Object[][] data=new Object[lastrow][lastcell];
	 
	 for(int i=0;i<lastrow;i++)
	 {
		 for(int j=0;j<lastcell;j++)
			 
		 {
			 data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			 
		 }
	 }
	 
	 return data;
}








}
