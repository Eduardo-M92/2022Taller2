package UCN.CL.PA.Logic;

import UCN.CL.PA.Domain.Part;

public class PartContainer
{
	private Part[] parts;
	private int cant;
	private int max;
	public PartContainer(int max)
	{
		this.max = max;
		parts = new Part[max];
	}
	
	public Part buscarPorCodigo(String code)
	{
		int a=0;
		for(a=0;a<cant;a++)
		{
			if(parts[a].getPartCode().toLowerCase().equals(code.toLowerCase()))
			{
				break;
			}
		}
		if(cant == a)
		{
			return null;
		}
		else {
			return parts[a];
		}
	}
	
	public Part buscarPorNombre(String name)
	{
		int a=0;
		for(a=0;a<cant;a++)
		{
			if(parts[a].getName().toLowerCase().equals(name.toLowerCase()))
			{
				break;
			}
		}
		if(cant == a)
		{
			return null;
		}
		else {
			return parts[a];
		}
	}
	
	public boolean add(Part p)
	{
		if(cant<max)
		{
			parts[cant] = p;
			cant++;
			return true;
		}else {return false;}
	}
	
	public Part obtenerI(int i)
	{
		return parts[i];
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
