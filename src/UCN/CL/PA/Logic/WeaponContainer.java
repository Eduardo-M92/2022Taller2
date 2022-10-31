package UCN.CL.PA.Logic;

import UCN.CL.PA.Domain.Weapon;

public class WeaponContainer
{
	private Weapon[] weapons;
	private int cant;
	private int max;
	public WeaponContainer(int max)
	{
		this.max = max;
		weapons = new Weapon[max];
	}
	
	public Weapon buscar(String name)
	{
		int a=0;
		for(a=0;a<cant;a++)
		{
			if(weapons[a].getName().toLowerCase().equals(name.toLowerCase()))
			{
				break;
			}
		}
		if(cant == a)
		{
			return null;
		}
		else {
			return weapons[a];
		}
	}
	
	public boolean add(Weapon w)
	{
		if(cant<max)
		{
			weapons[cant] = w;
			cant++;
			return true;
		}else {return false;}
	}
	
	public Weapon obtenerI(int i)
	{
		return weapons[i];
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
