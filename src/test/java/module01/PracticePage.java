package module01;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticePage {

	@Test(dataProvider = "loginData")
	public void testScriptOne(String user,String pass) {

		System.out.println("UserName is "+user+""+" PassWord Is "+pass);
		System.err.println(" ");
		
		
	}
	
	@Test(dataProvider = "loginData02")
	public void testScriptTwo(String user,String pass) {

		System.out.println("UserName is "+user+""+" PassWord Is "+pass);
		System.err.println(" ");
		
		
	}

	@DataProvider
	public Object[][] loginData() {
		Object[][] data = { 
				{"kaif@123","Khan@123"}, 
				{"sadik@123","Khan@321"}, 
				{"parvez@123","Malik@123"} 
				
		};
return data;
	}
	
	
	@DataProvider
	public Object[][] loginData02() {
	    Object[][] objArvs = new Object[4][2];
	    objArvs[0][0] = "Deepak";
	    objArvs[0][1] = "Infigyn";
	    objArvs[1][0] = "John";
	    objArvs[1][1] = "facebook";
	    objArvs[3][0] = "miller";
	    objArvs[3][1] = "whatsapp";
	    objArvs[2][0] = "pankaj";
	    objArvs[2][1] = "relince";
	    return objArvs;
	}
	
	
}




