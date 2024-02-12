package Package;

import java.util.ArrayList;

public class Account {
	
	private String username;
	private String psw;
	private ArrayList<Food> foods;
	
	Account(String _username, String _psw)
	{
		this.username = _username;
		this.psw = _psw;
		foods = new ArrayList<Food>();
	}
	
	boolean addFood(String name, float cost)
	{
		//Controllo per verificare che l'alimento non esista già
		if(foods != null)
		{
			for(int i = 0; i<foods.size(); i++)
			{
				if(name.equalsIgnoreCase(foods.get(i).getName()))
				{
					return false;
				}
			}
		}
		
		Food food = new Food(name, cost, 0);
		foods.add(food);
		
		//DEBUG
		System.out.print(food.getName() + "  ");
		System.out.println(food.getCost() + " Euro/Kg");
		
		return true;
	}
	
	String getUser(){
		return username;
	}
	String getPsw(){
		return psw;
	}
	ArrayList<Food> getFoods()
	{
		return foods;
	}
}
