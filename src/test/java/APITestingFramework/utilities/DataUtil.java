package APITestingFramework.utilities;

import java.lang.reflect.*;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import APITestingFramework.setUp.BaseTest;

public class DataUtil extends BaseTest{
	@DataProvider(name="data")
	public Object[][] getData(Method m){
		
		String TestCaseName = m.getName();
		
		int rows = excel.getRowCount(Constants.DATA_SHEET);
		
		int testCaseStartingRowNum = 0;
		int testCaseEndingRowNum = 0;
		//identify the datas for the test case
		for(int rowCounter = 1; rowCounter <=rows;rowCounter++) {
			String cellData = excel.getCellData(Constants.DATA_SHEET, 0, rowCounter);
			System.out.println(cellData);
			if(cellData.equals(TestCaseName)) {
				testCaseStartingRowNum = rowCounter;
			}
			
			if(testCaseStartingRowNum != 0) {
				if(cellData.equals("")) {
					testCaseEndingRowNum = rowCounter-1;
					break;
				}else {
					testCaseEndingRowNum = rowCounter;
				}
			}
		}
		
		//identify the colcount
		int TotNumOfColumnsforTestCase = 0;
		while((excel.getCellData(Constants.DATA_SHEET, TotNumOfColumnsforTestCase, testCaseStartingRowNum+1).equals("")) == false) {
			TotNumOfColumnsforTestCase = TotNumOfColumnsforTestCase + 1;
		}
		
		Object[][] data = new Object[testCaseEndingRowNum - testCaseStartingRowNum -1][1];
		
		//fetch the data
		for(int RowCounter = testCaseStartingRowNum+2; RowCounter <= testCaseEndingRowNum;RowCounter++) {
			HashMap<String,String> dataHashMap = new HashMap<String,String>();
			
			for(int ColCounter = 0; ColCounter <= TotNumOfColumnsforTestCase-1; ColCounter++) {
				dataHashMap.put(excel.getCellData(Constants.DATA_SHEET, ColCounter, testCaseStartingRowNum + 1) , excel.getCellData(Constants.DATA_SHEET, ColCounter, RowCounter));
				System.out.println("key is "+excel.getCellData(Constants.DATA_SHEET, ColCounter, testCaseStartingRowNum + 1));
				System.out.println("value is "+excel.getCellData(Constants.DATA_SHEET, ColCounter, RowCounter));
				System.out.println("----------------------------------");
			}
			System.out.println(RowCounter -testCaseStartingRowNum-2);
			data[RowCounter -testCaseStartingRowNum-2][0] = dataHashMap; 
		}
		
		return data;
	}
	
}
