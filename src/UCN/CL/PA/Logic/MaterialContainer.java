package UCN.CL.PA.Logic;

import UCN.CL.PA.Domain.Material;

public class MaterialContainer
{
	private Material[] materials;
	private int cant;
	private int max;
	public MaterialContainer(int max)
	{
		this.max = max;
		materials = new Material[max];
	}
	
	public Material buscar(String name)
	{
		int a=0;
		for(a=0;a<cant;a++)
		{
			if(materials[a].getName().toLowerCase().equals(name.toLowerCase()))
			{
				break;
			}
		}
		if(cant == a)
		{
			return null;
		}
		else {
			return materials[a];
		}
	}
	
	public boolean add(Material m)
	{
		if(cant<max)
		{
			materials[cant] = m;
			cant++;
			return true;
		}else {return false;}
	}
	
	public Material obtenerI(int i)
	{
		return materials[i];
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
