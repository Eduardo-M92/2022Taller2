package UCN.CL.PA.Logic;

import UCN.CL.PA.Domain.Country;

public class CountryContainer
{
	private Country[] countrys;
	private int cant;
	private int max;
	
	public CountryContainer(int max)
	{
		this.max = max;
		countrys = new Country[max];
	}
	
	public boolean add(String country)
	{
		for(int a=0;a<cant;a++)
		{
			if(countrys[a].getName().toLowerCase().equals(country.toLowerCase()))
			{
				return false;
			}
		}
		countrys[cant] = new Country(country);
		return true;
	}
	
	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	
}
