package UCN.CL.PA.Logic;

import UCN.CL.PA.Domain.Robot;

public class RobotContainer
{
	private Robot[] robots;
	private int cant;
	private int max;
	public RobotContainer(int max)
	{
		this.max = max;
		robots = new Robot[max];
	}
	
	public Robot buscar(String name)
	{
		int a=0;
		for(a=0;a<cant;a++)
		{
			if(robots[a].getName().toLowerCase().equals(name.toLowerCase()))
			{
				break;
			}
		}
		if(cant == a)
		{
			return null;
		}
		else {
			return robots[a];
		}
	}
	
	public boolean add(Robot r)
	{
		if(cant<max)
		{
			robots[cant] = r;
			cant++;
			return true;
		}else {return false;}
	}
	
	public Robot obtenerI(int i)
	{
		return robots[i];
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
