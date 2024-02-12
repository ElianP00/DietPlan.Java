package Package;

public class week {
	
	public day[] settimana = new day[7];
	
	//Costruttore
	week()
	{
		
		
		day lunedì = new day();
		day martedì = new day();
		day mercoledì = new day();
		day giovedì = new day();
		day venerdì = new day();
		day sabato = new day();
		day domenica = new day();
		
		settimana[0] = lunedì;
		settimana[1] = martedì;
		settimana[2] = mercoledì;
		settimana[3] = giovedì;
		settimana[4] = venerdì;
		settimana[5] = sabato;
		settimana[6] = domenica;
	}
}
