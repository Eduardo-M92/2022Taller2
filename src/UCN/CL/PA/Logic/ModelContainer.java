package UCN.CL.PA.Logic;

import UCN.CL.PA.Domain.Model;

public class ModelContainer
{
	private Model[] models;
	private int cant;
	private int max;
	public ModelContainer(int max)
	{
		this.max = max;
		models = new Model[max];
	}
	
	public Model buscar(String code)
	{
		int a=0;
		for(a=0;a<cant;a++)
		{
			if(models[a].getModelCode().toLowerCase().equals(code.toLowerCase()))
			{
				break;
			}
		}
		if(cant == a)
		{
			return null;
		}
		else {
			return models[a];
		}
	}
	
	public boolean add(Model m)
	{
		if(cant<max)
		{
			models[cant] = m;
			cant++;
			return true;
		}else {return false;}
	}
	
	public Model obtenerI(int i)
	{
		return models[i];
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
