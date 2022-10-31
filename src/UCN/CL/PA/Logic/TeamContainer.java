package UCN.CL.PA.Logic;

public class TeamContainer
{
	private Team[] teams;
	private int cant;
	private int max;
	public TeamContainer(int max)
	{
		this.max = max;
		teams = new Team[max];
	}
	
	public Team buscar(String name)
	{
		int a=0;
		for(a=0;a<cant;a++)
		{
			if(teams[a].getName().toLowerCase().equals(name.toLowerCase()))
			{
				break;
			}
		}
		if(cant == a)
		{
			return null;
		}
		else {
			return teams[a];
		}
	}
	
	public boolean add(Team t)
	{
		if(cant<max&&buscar(t.getName())==null)
		{
			teams[cant] = t;
			cant++;
			return true;
		}else {return false;}
	}
	
	public Team obtenerI(int i)
	{
		return teams[i];
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
