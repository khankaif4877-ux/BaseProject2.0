package module02;

import org.testng.annotations.Test;

import com.ProjectName.generic.BaseClassUtil.BaseClass;

public class ClassZeroTest extends BaseClass  {


	@Test(groups = "smoke")
	public void firstScenarioTest() {
		
		
		
		System.out.println("firstScenarioTest");
	}
	@Test(groups = "reg")
	public void ScecondScenarioTest() {
		
		System.out.println("ScecondScenarioTest");
	}
	@Test(groups = "reg")
	public void thirdScenarioTest() {
		
		System.out.println("thirdScenarioTest");
	}





}


