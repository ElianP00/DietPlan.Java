package Package;

import java.util.Scanner;

public class dietManager {
	
	private Scanner scan;
	private pasto meal;
	private day currentDay;
	private week currentWeek;
	private year anno;
	private Account current;
	
	//Costruttore
	dietManager ()
	{
		meal = new pasto();
		currentDay = new day();
		currentWeek = new week();
		anno = new year();
		current = new Account("example", "example");
		scan = new Scanner (System.in);
	}
	
	//Opzioni dell'account corrente
	void dietOptions (Account account)
	{
		current = account;
		
		System.out.println("Create/Modify Diet");
	}	
	
	void addPasto()
	{
		Food food = getFood();
		float quantity = addQuantity();
		if(quantity == 0)
		{
			System.out.println("The quantity has to be more than zero");
			addQuantity();
		}
		food.changeQuantity(quantity);
		//meal.addAlimento(food);
	}
	
	Food getFood()
	{
		System.out.println("Type the name of a food:");
		String food = scan.nextLine();
		if(foodCheck(food, current) !=null)
				return foodCheck(food, current);
		else
		{
			System.out.println("The name of the food does not exist in your Food List");
			System.out.println("Will you:");
			System.out.println("1 - Type again");
			System.out.println("2 - Create a new food");
			getFood();
			
		}
		return null;
	}
	Food foodCheck(String foodName, Account account)
	{
		for(int i = 0; i < account.getFoods().size(); i++)
			if(foodName.equalsIgnoreCase(account.getFoods().get(i).getName()))
				return account.getFoods().get(i);
		
		return null;
	}
	float addQuantity()
	{
		System.out.println("Insert the quantity:");
		float quantity = scan.nextFloat();
		scan.nextLine();
			
		if(quantity>=0)
			return quantity;
		else
		{
			return 0;
		}
	}
	
	boolean listDiet(Account x)
	{
		if(x.getFoods().size()!= 0)
		{
			System.out.println("The foods you added to your list are:");
			for(int i = 0; i < x.getFoods().size(); i++)
			{
				String name = x.getFoods().get(i).getName();
				float cost = x.getFoods().get(i).getCost();
				System.out.println(name + ", "+ cost+" euro/kg");
			}
			return true;
		}
		else
			return false;
		
	}
}
