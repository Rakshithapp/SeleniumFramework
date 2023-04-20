package Practise;

import org.testng.annotations.Test;

public class SoftAssert {
	
	@Test
	public void createcontact()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		org.testng.asserts.SoftAssert soft= new org.testng.asserts.SoftAssert();
		soft.assertEquals(false, true);
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	public void m1()
	{
		String expdata = "qspiders";
		String actdata = "qspiders";
		org.testng.asserts.SoftAssert soft= new org.testng.asserts.SoftAssert();
		soft.assertEquals(actdata, expdata);
		soft.assertAll();
		
}
}
