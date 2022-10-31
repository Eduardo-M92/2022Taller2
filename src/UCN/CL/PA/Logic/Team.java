package UCN.CL.PA.Logic;

import UCN.CL.PA.Domain.Person;

public class Team
{
	private String name;
	private PeopleContainer people;
	
	public Team(String name)
	{
		this.name = name;
		people = new PeopleContainer(6);
	}
	
	public int getCant()
	{
		return people.getCant();
	}
	
	public boolean add(Person p)
	{
		return people.add(p);
	}
	
	public Person buscar(String name)
	{
		return people.buscarNombre(name);
	}
	
	public boolean eliminar(String name)
	{
		return people.eliminar(name);
	}
	
	public Person obtenerI(int i)
	{
		return people.obtenerI(i);
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
}
