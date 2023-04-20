package Practise;

import org.testng.annotations.Test;

//@Test
public class SampleTestNg {
	
	//@Test
	//@Test(priority=3)
	//@Test(invocationcount=3)
	public  void CreateContact() 
	{
		//int[] arr= {1,2,3};
		//System.out.println(arr[5]);
		System.out.println("contact created");	
	}
	
	
	//@Test(priority=2)
	//@Test(dependsOnMethods = "CreateContact")
	public  void ModifyContact()
	{
		System.out.println("modified contact");
	}
	
	
	//@Test(priority=1)
	//@Test(dependsOnMethods = "CreateContact")
	public  void DeleteContact()
	{
		System.out.println("delete contact");
	}
}
