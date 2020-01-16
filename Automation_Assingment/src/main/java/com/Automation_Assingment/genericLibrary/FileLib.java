package com.Automation_Assingment.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Prakriti Priya
 *
 */
public class FileLib implements IFilePaths, IAutoConstants{
	/**
	 * This method is used to fetch data from .properties file
	 * @param Key
	 * @return String value
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String Key)  {

		FileInputStream fis;
		Properties pObj = new Properties();
		try {
			fis = new FileInputStream(PROP);
			pObj.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = pObj.getProperty(Key);
		return value;

	}

	/**
	 * This method is used to fetch data from .xlsx file
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String cellValue
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {

		FileInputStream fis = new FileInputStream(EXCEL);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		String cellValue = row.getCell(cellNum).getStringCellValue();
		workbook.close();
		return cellValue;
	}

	/**
	 * This method is used to set the data inside .xlsx file
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	public void setExcelData(String sheetName, int rowNum, int cellNum, String data) throws Throwable {

		FileInputStream fis = new FileInputStream(EXCEL);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell createCell = row.createCell(cellNum);
		createCell.setCellValue(data);

		FileOutputStream fos = new FileOutputStream(EXCEL);
		workbook.write(fos);
		workbook.close();
	}

}
