package UCN.CL.PA.Logic;

import UCN.CL.PA.Domain.Contribution;

public class ContributionContainer
{
	private Contribution[] contributions;
	private int cant;
	private int max;
	
	public ContributionContainer(int max)
	{
		this.max = max;
		contributions = new Contribution[max];
	}
	
	public Contribution obtenerI(int i)
	{
		return contributions[i];
	}
	
	public boolean add(Contribution c)
	{
		if(cant<max)
		{
			contributions[cant] = c;
			cant++;
			return true;
		}else {return false;}
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
