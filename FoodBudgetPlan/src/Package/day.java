package Package;

import java.util.ArrayList;

public class day {
	
	ArrayList<Food> meal;
	
	//Costruttore
	day()
	{
		meal = new ArrayList<Food>();

	}
	void addAlimento(Food food)
	{
		meal.add(food);
		System.out.println(food.getName() + " " + food.getQuantity());
	}

}
