package GenericUtility;

import java.util.Random;

public class Java_Utility {
	
	
	/**
	 * This method is 
	 * @return
	 */
	public int getRandomNum()
	{
		
		Random ran=new Random();
		int RamNum = ran.nextInt(1000);
		return RamNum ;
		
		
	}

}
