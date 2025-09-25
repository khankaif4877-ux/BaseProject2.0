package com.ProjectName.generic.FileUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil {
	private static final String DefaultPath = "\\Users\\KAIF KHAN\\Desktop\\TestData\\TestDAtaFB.xlsx";

	/*-----------------------------------------------Get data from excel----------------------------------------------------*/

	public String getDataFromExcel(String Sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fIS = new FileInputStream(DefaultPath);
		Workbook wb = WorkbookFactory.create(fIS);
		String value = wb.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue().toString();
		wb.close();
		fIS.close();
		return value;
	}

	/*-----------------------------------------------Set data in excel----------------------------------------------------*/

	
	public void setDataInExcel(String Sheet, int row, int cell, String value)
			throws EncryptedDocumentException, IOException {
		FileInputStream fIS = new FileInputStream(DefaultPath);
		Workbook wb = WorkbookFactory.create(fIS);
		wb.getSheet(Sheet).getRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fOS = new FileOutputStream(DefaultPath);
		wb.write(fOS);
		wb.close();
		fIS.close();
		fOS.close();
	}

	/*-----------------------------------------------Get last row from excel---------------------------------------------*/

	public int getRowCount(String Sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fIS = new FileInputStream(DefaultPath);
		Workbook wb = WorkbookFactory.create(fIS);
		int lastRowNum = wb.getSheet(Sheet).getLastRowNum();
		wb.close();
		fIS.close();
		return lastRowNum;

	}

	/*-----------------------------------------------Get cell row from excel---------------------------------------------*/
	// Get last row with default path
	public int getcellCount(String path, String Sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fIS = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fIS);
		int lastCellNum = (int) wb.getSheet(Sheet).getRow(0).getLastCellNum();
		wb.close();
		fIS.close();
		return lastCellNum;

	}

}


/*//Get last row with setted path
public int getcellCount( String Sheet) throws EncryptedDocumentException, IOException {
	if (setPath.equals("")) {
		return getcellCount(DefaultPath, Sheet);
		
	} else {
		return getcellCount(setPath, Sheet);
	}
}*/