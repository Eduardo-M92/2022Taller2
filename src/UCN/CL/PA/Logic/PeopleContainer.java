package UCN.CL.PA.Logic;

import UCN.CL.PA.Domain.Person;

public class PeopleContainer
{
	private Person[] people;
	private int cant;
	private int max;
	public PeopleContainer(int max)
	{
		this.max = max;
		people = new Person[max];
	}
	
	public Person buscarNombre(String name)
	{
		int a=0;
		for(a=0;a<cant;a++)
		{
			if(people[a].getName().toLowerCase().equals(name.toLowerCase()))
			{
				break;
			}
		}
		if(cant == a)
		{
			return null;
		}
		else {
			return people[a];
		}
	}
	
	public Person buscarCodigo(String code)
	{
		int a=0;
		for(a=0;a<cant;a++)
		{
			if(people[a].getID().toLowerCase().equals(code.toLowerCase()))
			{
				break;
			}
		}
		if(cant == a)
		{
			return null;
		}
		else {
			return people[a];
		}
	}
	
	public boolean add(Person p)
	{
		if(cant<max)
		{
			people[cant] = p;
			cant++;
			return true;
		}else {return false;}
	}
	
	public boolean eliminar(String name)
	{
		for(int a=0;a<cant;a++)
		{
			if(people[a].getName().equals(name))
			{
				for(int b=a;b<cant-1;b++)
				{
					people[b] = people[b+1];
				}
				people[cant] = null;
				cant--;
				return true;
			}
		}return false;
	}
	
	public Person obtenerI(int i)
	{
		return people[i];
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
