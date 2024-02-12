package Package;


import java.util.ArrayList;
import java.util.Scanner;

public class accountManager {
	
	final int MAX_ATTEMPTS = 3;
	
	private Account _admin;
	private Account _admin2;

	
	private codeManager security;
	
	private ArrayList<Account> users = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	validatorPsw val = new validatorPsw();
	
	
	private int attempt = 0;
	
	accountManager()
	{
		attempt = 0;
		security = new codeManager();
		_admin = new Account("Elian", "ADmin00");
		users.add(_admin);
		_admin2 = new Account("Hannah", "GG1ers");
		users.add(_admin2);
	}
	
	void updateCodes()
	{
		security.updateCodes();
	}
	
	Account access()
	{
		System.out.println("Inserire username: ");
		String username = scan.next();
		System.out.println("Enter your password: ");
		String psw = scan.next();
		
		
		if(scanUsername(username, psw)!=null)
			return scanUsername(username, psw);

		return null;
	}
		
	void addUsername()
	{
		System.out.println("Inserire username: ");
		String username = scan.next();
		addPassword(username);
	}
	void addPassword(String username)
	{
		System.out.println("Enter your password: ");
		System.out.println("(The password has to include at least 2 uppercase letters, 3 lowercase letters and 1 digit)");
		String psw = scan.next();
		addAccount(username, psw);
	}
	
	void addAccount(String username, String psw)
	{
		if(val.check(psw))
		{
			Account count = new Account(username, psw);
			users.add(count);
			System.out.println("Your account has been created");
			listAccount();
		}
		else
		{
			System.out.println("Try again");
			addPassword(username);
		}
	}
	
	void removeAccount()
	{
		
	}
	
	boolean adminSingUp()
	{
		System.out.println("Insert the priority pin to verify your identity: ");
		String pin = scan.next();
		boolean check = security.verifiedCode(pin, 0);
		if(!check)
		{	
			if(!(incorrectPin(attempt)))
				return false;
		}
		return true;
	}
	
	boolean workerSingUp()
	{
		System.out.println("Insert the priority pin to verify your identity: ");
		String pin = scan.next();
		boolean check = security.verifiedCode(pin);
		if(!check)
		{	
			if(!(incorrectPin(attempt)))
				return false;
		}
		return true;
	}
	
	void listAccount()
	{
		for(int i = 0; i<users.size(); i++)
		{
			System.out.println(users.get(i).getUser());
			System.out.println(users.get(i).getPsw());
		}
	}
	
	boolean incorrectPin(int index)
	{
		if(index<MAX_ATTEMPTS)
		{
			attempt++;
			workerSingUp();
			return true;
		}
		
		else if(index==MAX_ATTEMPTS)
		{
			System.out.println("You reached the max attempts number");
			System.out.println("You will redirected to the main menu");
			System.out.println();
			return false;
		}
		
		System.out.println("There was a problem with the number of attempts");
		return false;
	}
	
	Account scanUsername(String username, String psw)
	{		
		for(int j=0;j<users.size();j++)
		{
			if(username.equals(users.get(j).getUser()))
				if(psw.equals(users.get(j).getPsw()))				
					return users.get(j);
		}
		return null;
	}
}
