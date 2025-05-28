package Pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ddt_use {

	public static void main(String[] args) throws IOException {
		// to read data from property file
		FileInputStream pfis = new FileInputStream(".\\src\\test\\resources");
		Properties prop = new Properties();
		prop.load(pfis);
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		String BROWSER = prop.getProperty("browser");
		
		// TO read data from exel file
		FileInputStream efis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
	 	String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).toString();
 
	}

}
