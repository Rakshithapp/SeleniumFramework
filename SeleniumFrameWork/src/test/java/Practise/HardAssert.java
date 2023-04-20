package Practise;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	
	/*public void createContact()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, false);
		System.out.println("Step3");
		System.out.println("Step4");
		
	}
	@Test
	public void deleteContact()
	{
		System.out.println("Step5");
		System.out.println("Step6");
		
}*/
	
	@Test
	public void m1()
	{
		String expdata = "qspiders";
		String actdata = "qspiders";			
		Assert.assertEquals(actdata,expdata);
		
}
}