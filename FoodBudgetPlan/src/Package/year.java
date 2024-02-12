package Package;

public class year {

	week[] anno = new week[52];
	public week settimana;
	
	//Costruttore
	year()
	{
		settimana = new week();
		
		for(int i = 0;i<52;i++)
		{
			anno[i] = settimana;
		}
	}
}
