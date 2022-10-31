package UCN.CL.PA.Domain;

import UCN.CL.PA.Logic.Team;

public class Person
{
	private String name;
	private String ID;
	private String specialty;
	private Team team;
	
	public Person(String name, String iD, String specialty)
	{
		this.name = name;
		ID = iD;
		this.specialty = specialty;
		team = null;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
}
