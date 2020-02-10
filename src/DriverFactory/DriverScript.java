package DriverFactory;

import org.testng.annotations.Test;

import CommonFunctions.PBFunctions;
import Constant.PBConstant;
import Utilities.ExcelFileUtil;

public class DriverScript extends PBConstant {
String inputpath="E:\\Online_Framework\\Orange_HRM\\TestInput\\Controller.xlsx";
String outputpath="E:\\Online_Framework\\Orange_HRM\\TestOutput\\keyword.xlsx";	
String TCSheet="TestCases";
String TSSheet="TestSteps";
@Test
public void stratTest()throws Throwable
{
boolean res=false;
String tcres="";
//creating refernce object to call excel methods
ExcelFileUtil xl=new ExcelFileUtil(inputpath);
//count no of rows in Tcsheet
int TCcount=xl.rowCount(TCSheet);
//count noo f rows in TS Sheet
int TScount=xl.rowCount(TSSheet);
for(int i=1;i<=TCcount;i++)
{
	//read excute column
String execute=xl.getcellData(TCSheet, i, 2);
if(execute.equalsIgnoreCase("Y"))
{
//read tcid column
	String Tcid=xl.getcellData(TCSheet, i, 0);
for(int j=1;j<=TScount;j++)
{
//read tsid column
String Tsid=xl.getcellData(TSSheet, j, 0);
if(Tcid.equalsIgnoreCase(Tsid))
{
//read keyword column
String keyword=xl.getcellData(TSSheet, j, 3);
if(keyword.equalsIgnoreCase("AdminLogin"))
{
res=PBFunctions.verifyLogin("Admin", "Admin");	
}
else if(keyword.equalsIgnoreCase("NewBranchCreation"))
{
PBFunctions.navigatebranches();
res=PBFunctions.verifyBranccreation("Kadiri", "Ananatapur", "12345", 1, 1, 1);
}
else if(keyword.equalsIgnoreCase("UpdateBranch"))
{
PBFunctions.navigatebranches();
res=PBFunctions.verifyBranchUpdation("ameerpet", "Hyderabad23");
}
else if(keyword.equalsIgnoreCase("AdminLogout"))
{
res=PBFunctions.verifyLogout();
}
String tsres;
if(res)
{
 tsres="Pass";
xl.setCellData(TSSheet, j, 4, tsres, outputpath);	
}
else
{
 tsres="Fail";
xl.setCellData(TSSheet, j, 4, tsres, outputpath);	
}
//if not tcres equal to null then write as pass or fail into  TCSheet
if(!tsres.equalsIgnoreCase("Fail"))
{
tcres=tsres;
}
}
}
xl.setCellData(TCSheet, i, 3, tcres, outputpath);
}
else
{
//write as not executed in results column in TCsheet
xl.setCellData(TCSheet, i, 3, "Not Executed", outputpath);
}
}
}
}





















