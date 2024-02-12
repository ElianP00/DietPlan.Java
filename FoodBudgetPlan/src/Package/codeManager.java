package Package;


import java.util.ArrayList;

public class codeManager {

	ArrayList<String> workerCodes = new ArrayList<>();
	ArrayList<String> adminCodes;
	
	codeManager()
	{
		adminCodes = new ArrayList<>();
	}
	
	void updateCodes()
	{
		workerCodes.add("Worker20");
		workerCodes.add("Worker22");
		workerCodes.add("Worker24");
		workerCodes.add("Worker26");
		workerCodes.add("Worker28");
		
		adminCodes.add("AdmiN50");
		adminCodes.add("AdmiN52");
		adminCodes.add("AdmiN54");
		adminCodes.add("AdmiN56");
		adminCodes.add("AdmiN58");
	}
	
	boolean verifiedCode(String inCode)
	{	
		for(int i = 0; i<workerCodes.size();i++)
		{				
			if(inCode.equals(workerCodes.get(i)))
			{
				System.out.println("The pin is correct");
				return true;
			}
		}
		logError(0);
		return false;
	}
	
	boolean verifiedCode(String inCode, int index)
	{
		for(int i = 0; i<adminCodes.size();i++)
		{				
			if(inCode.equals(adminCodes.get(i)))
			{
				System.out.println("The pin is correct");
				return true;
			}
		}
		logError(0);
		return false;
	}
	
	void logError(int code)
	{
		switch(code)
		{
		case 0:
			System.out.println("Error: incorrect pin");
			break;
		
		
		default:
			System.out.println("The error code is not registered");
		}
	}
}

