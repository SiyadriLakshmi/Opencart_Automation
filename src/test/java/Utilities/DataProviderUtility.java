package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	//DataProvider 1

	@DataProvider(name="LoginData")

	public String [][] getData() throws IOException

	{

	String path=".\\testData\\LogincredentialExcelData.xlsx";//taking xl file for test data

	Excel_Utility xlutil=new Excel_Utility(path);//creating an object for Excel_Utility

	int totalrows=xlutil.getRowCount("Sheet1");//Access the methods from Excel_Utility for row count

	int totalcols=xlutil.getCellCount("Sheet1", 1);//Access the methods from Excel_Utility for column count

	String logindata[][]=new String[totalrows] [totalcols];//create 2 dimensional string Array

	for(int i=1;i<=totalrows;i++) //1 is row //read the data from xl storing in two dimensional array

	{

	for(int j=0;j<totalcols;j++) //0 i is rows j is column
	{
		logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
	}

	}
	return logindata;//returning two dimension array

	}
}
