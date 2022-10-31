package UCN.CL.PA.Logic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import UCN.CL.PA.Domain.Contribution;
import UCN.CL.PA.Domain.Material;
import UCN.CL.PA.Domain.Model;
import UCN.CL.PA.Domain.Part;
import UCN.CL.PA.Domain.Person;
import UCN.CL.PA.Domain.Robot;
import UCN.CL.PA.Domain.Weapon;

public class GumdamSystemImpl implements GumdamSystem
{
	int max = 1000;
	private ModelContainer models = new ModelContainer(max);
	private PartContainer parts = new PartContainer(max);
	private PeopleContainer people = new PeopleContainer(max);
	private TeamContainer teams = new TeamContainer(max);
	private RobotContainer robotos = new RobotContainer(max);
	private MaterialContainer materials = new MaterialContainer(max);
	private ContributionContainer contributions = new ContributionContainer(max);
	private WeaponContainer weapons = new WeaponContainer(max);
	
	public GumdamSystemImpl() {}
	
	public String mostrarPiezasYArmas()
	{
		String exit = "Piezas: ";
		for(int a=0;a<parts.getCant();a++)
		{
			exit+=" ("+parts.obtenerI(a).getName()+" Codigo: "+parts.obtenerI(a).getPartCode()+")";
		}
		exit += " Armas: ";
		for(int a=0;a<weapons.getCant();a++)
		{
			exit+=" ("+weapons.obtenerI(a).getName()+" Codigo: "+weapons.obtenerI(a).getWeaponCode()+")";
		}
		return exit;
	}
	
	
	public String mostrarPersonas()
	{
		String exit="Ensambladores ";
		for(int a=0;a<people.getCant();a++)
		{
			if(people.obtenerI(a).getSpecialty().toLowerCase().equals("ensamblador"))
			{
				exit += "("+people.obtenerI(a).getName()+" ID: "+people.obtenerI(a).getID()+") ";
			}
		}
		exit += "Pilotos ";
		for(int a=0;a<people.getCant();a++)
		{
			if(people.obtenerI(a).getSpecialty().toLowerCase().equals("piloto"))
			{
				exit += "("+people.obtenerI(a).getName()+" ID: "+people.obtenerI(a).getID()+") ";
			}
		}
		return exit;
	}
	
	public Person[] getPersonasSinEquipo()
	{
		Person[] temp = new Person[100];
		int cant=0;
		for(int a=0;a<people.getCant();a++)
		{
			if(people.obtenerI(a).getTeam()==null)
			{
				temp[cant] = people.obtenerI(a);
				cant++;
			}
		}
		Person[] exit = new Person[cant];
		for(int a=0;a<cant;a++)
		{
			exit[a]=temp[a];
		}
		return exit;
	}
	
	
	public String mostrarGrupos()
	{
		String exit = "Grupos";
		for(int a=0;a<teams.getCant();a++)
		{
			exit+= " ("+teams.obtenerI(a).getName()+")";
		}
		return exit;
	}
	
	
	public String mostrarRobots()
	{
		String exit = "robotos:";
		for(int a=0;a<robotos.getCant();a++)
		{
			exit+=" ("+(a+1)+") "+robotos.obtenerI(a).getName();
		}
		return exit;
	}
	
	
	public String revisarMunicion()
	{
		String exit = "robotos:";
		for(int a=0;a<robotos.getCant();a++)
		{
			exit+=" ("+(a+1)+") "+robotos.obtenerI(a).getName()+" Municion: "+weapons.buscar(robotos.obtenerI(a).getNameWeapon()).getAmmo();
		}
		return exit;
	}
	
	
	public String buscarPorPieza(String typePart)
	{
		String exit = "";
		for(int a=0;a<parts.getCant();a++)
		{
			if(parts.obtenerI(a).getTypePart().equals(typePart.toLowerCase()))
			{
				exit += "("+parts.obtenerI(a).getName()+" Code: "+parts.obtenerI(a).getPartCode()+" Pais:"+parts.obtenerI(a).getCountry()+") ";
			}
		}
		
		return exit;
	}
	
	
	public String buscarPorMaterial(String material)
	{
		for(int a=0;a<parts.getCant();a++)
		{
			if(materials.buscar(material).getName().toLowerCase().equals(material.toLowerCase()))
			{
				return "("+materials.obtenerI(a).getCountry()+", Stock: "+materials.obtenerI(a).getStock()+") ";
			}
		}
		
		return null;
	}
	
	
	public String mostrarPaises()
	{
		String exit="Paises:";
		for(int a=0;a<materials.getCant();a++)
		{
			exit+=" ("+materials.obtenerI(a).getCountry()+" Material: "+materials.obtenerI(a).getName()+" Cantidad: "+materials.obtenerI(a).getStock()+")";
		}
		return exit;
	}
	
	
	public String crearModelo(String nombreDelRobot)
	{
		String nameModelo = "";
		Robot robot = robotos.buscar(nombreDelRobot);
		String inicales = "";
		Part head = parts.buscarPorNombre(robot.getNameHead());
		Part arms = parts.buscarPorNombre(robot.getNameArms());
		Part legs = parts.buscarPorNombre(robot.getNameLegs());
		Part chest = parts.buscarPorNombre(robot.getNameChest());
		Weapon gun = weapons.buscar(robot.getNameWeapon());
		int suma = Integer.parseInt(head.getPartCode())+Integer.parseInt(arms.getPartCode())+Integer.parseInt(legs.getPartCode())+Integer.parseInt(chest.getPartCode())+Integer.parseInt(gun.getWeaponCode());
		for(int a=0;a<teams.buscar(robot.getTeam()).getCant();a++)
		{
			System.out.println(a);
			inicales += teams.buscar(robot.getTeam()).obtenerI(a).getName().charAt(0);
		}
		nameModelo = suma+inicales;
		Model m = new Model(nameModelo, nombreDelRobot);
		models.add(m);
		return nameModelo;
	}

	
	public void ensamblarRobot(String name, String nameArms, String nameLegs, String nameChest, String nameHead, String extraQuality, String nameWeapon, String team, String pilotCode)
	{
		Person pilot = people.buscarCodigo(pilotCode);
		if(pilot!=null)
		{
			if(pilot.getTeam()!=null)
			{
				pilot.getTeam().eliminar(name);
			}
			pilot.setTeam(teams.buscar(team));
			teams.buscar(team).add(pilot);
		}
		robotos.add(new Robot(name, nameArms, nameLegs, nameChest, nameHead, nameWeapon, extraQuality, team, pilotCode));
	}
	
	
	public void añadirStockPiezas(String pais, int cantidad)
	{
		
		for(int a=0;a<contributions.getCant();a++)
		{
			if(contributions.obtenerI(a).getCountry().toLowerCase().equals(pais.toLowerCase()))
			{
				contributions.obtenerI(a).setAmount(contributions.obtenerI(a).getAmount()+cantidad);
				System.out.println("Se añadio "+cantidad+" a "+contributions.obtenerI(a).getPartName());
			}
		}
	}
	
	
	public void añadirStockMateriales(String pais, int cantidad)
	{
		for(int a=0;a<materials.getCant();a++)
		{
			if(materials.obtenerI(a).getCountry().toLowerCase().equals(pais.toLowerCase()))
			{
				materials.obtenerI(a).setStock(materials.obtenerI(a).getStock()+cantidad);
				System.out.println("Se añadio "+cantidad+" al "+materials.obtenerI(a).getName());
			}
		}
	}
	
	
	public void aumentarMunicion(String nombreDelRobot, int cantidad)
	{
		weapons.buscar(robotos.buscar(nombreDelRobot).getNameWeapon()).setAmmo(weapons.buscar(robotos.buscar(nombreDelRobot).getNameWeapon()).getAmmo()+cantidad);;
	}
	
	
	public boolean crearEquipo(String nameTeam, String [] team)
	{
		for(int a=0;a<6;a++)
		{
			people.buscarNombre(team[a]).setTeam(teams.buscar(nameTeam));
		}
		return true;
	}
	
	
	public boolean añadirPersona(String name, String ID, String speciality, String team)
	{
		Person p = new Person(name, ID, speciality);
		if(teams.buscar(team)==null&&!team.toLowerCase().equals("no")&&!team.toLowerCase().equals("administracion"))
		{
			Team t = new Team(team);
			p.setTeam(t);
			
			if(people.add(p))
			{
				t.add(p);
				teams.add(t);
				return true;
			}
			else
			{
				return false;
			}
			
		}else if(team.toLowerCase().equals("no"))
		{
			p.setTeam(null);
			if(people.add(p))
			{
				return true;
			}
			else
			{
				return false;
			}
		}else if(teams.buscar(team)!=null)
		{
			Team t = teams.buscar(team);
			p.setTeam(t);
			
			if(people.add(p))
			{
				t.add(p);
				return true;
			}
			else
			{
				return false;
			}
		}else if(team.toLowerCase().equals("administracion"))
		{
			p.setTeam(null);
			if(people.add(p))
			{
				return true;
			}
			else
			{
				return false;
			}
		}else
		{
			return false;
		}
	}

	
	public boolean ingresarPieza(String name, String partCode, String typePart, String country, int necessaryMaterial)
	{
		if(parts.add(new Part(name, partCode, typePart, country, necessaryMaterial)))
		{
			return true;
		}else {return false;}
	}

	
	public boolean ingresarArma(String name, String code, String country, int ammo, int necessaryMaterial)
	{
		if(weapons.add(new Weapon(name, code, country, ammo, necessaryMaterial)))
		{
			return true;
		}else {return false;}
	}

	
	public Robot revisarRobot(String nombreDelRobot)
	{
		int cont = 0;
		if(!parts.buscarPorNombre(robotos.buscar(nombreDelRobot).getNameArms()).getTypePart().toLowerCase().equals("brazos"))
		{
			System.out.println("Brazos incorrectos");
			cont++;
		}
		if(!parts.buscarPorNombre(robotos.buscar(nombreDelRobot).getNameLegs()).getTypePart().toLowerCase().equals("piernas"))
		{
			System.out.println("Piernas incorrectas");
			cont++;
		}
		if(!parts.buscarPorNombre(robotos.buscar(nombreDelRobot).getNameChest()).getTypePart().toLowerCase().equals("torax"))
		{
			System.out.println("Torax incorrecto");
			cont++;
		}
		if(!parts.buscarPorNombre(robotos.buscar(nombreDelRobot).getNameHead()).getTypePart().toLowerCase().equals("cabeza"))
		{
			System.out.println("Cabeza incorrecta");
			cont++;
		}
		
		if(cont==0)
		{
			System.out.println("Nada malo con el Robot");
		}
		
		return robotos.buscar(nombreDelRobot);
	}
	
	public boolean buscarNombreDePieza(String name)
	{
		if(parts.buscarPorNombre(name)!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean buscarNombreDeArma(String name)
	{
		if(weapons.buscar(name)!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean buscarNombreDeEquipo(String name)
	{
		if(teams.buscar(name)!=null)
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	
	public boolean buscarCodigoPiloto(String code)
	{
		if(people.buscarCodigo(code)!=null)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean añadirMaterial(String name, String country, int Stock)
	{
		if(materials.add(new Material(name, country, Stock)))
		{
			return true;
		}else {return false;}
	}

	
	public boolean añadirContribucion(String country, String partType, String partCode, String material, int amount)
	{
		Material m = materials.buscar(material);
		if(m==null)
		{
			m = new Material(material, country, 0);
			materials.add(m);
			contributions.add(new Contribution(country, partType, partCode, m, amount));
			return true;
		}
		else if(contributions.add(new Contribution(country, partType, partCode, m, amount)))
		{
			return true;
		}else {return false;}
	}
	
	public void destruirTodo()
	{
		models = null;
		parts = null;
		people = null;
		teams = null;
		robotos = null;
		materials = null;
		contributions = null;
		weapons = null;
	}

	public void cerrarSistema() throws IOException
	{
		FileWriter armas = new FileWriter("armas.txt");
		PrintWriter pw1 = new PrintWriter(armas);
		Weapon w = null;
		for(int a=0;a<weapons.getCant();a++)
		{
			w = weapons.obtenerI(a);
			pw1.println(w.getName()+","+w.getWeaponCode()+","+w.getAmmo()+","+w.getCountry()+","+w.getNecessaryMaterial());
		}
		FileWriter materiales = new FileWriter("materiales.txt");
		PrintWriter pw2 = new PrintWriter(materiales);
		Material m = null;
		for(int a=0;a<materials.getCant();a++)
		{
			m = materials.obtenerI(a);
			pw2.println(m.getName()+","+m.getStock()+","+m.getCountry());
		}
		FileWriter paises = new FileWriter("paises.txt");
		PrintWriter pw3 = new PrintWriter(paises);
		Contribution c = null;
		for(int a=0;a<contributions.getCant();a++)
		{
			c = contributions.obtenerI(a);
			pw3.println(c.getCountry()+","+c.getPartName()+","+c.getAmount()+","+c.getPartCode()+","+c.getMaterial().getName());
		}
		FileWriter personas = new FileWriter("personas.txt");
		PrintWriter pw4 = new PrintWriter(personas);
		Person p = null;
		for(int a=0;a<people.getCant();a++)
		{
			p = people.obtenerI(a);
			if(p.getTeam()==null)
			{
				if(p.getSpecialty().equals("admin"))
				{
					pw4.println(p.getName()+","+p.getID()+","+p.getSpecialty()+","+"ADMINISTRACION");
				}
				else
				{
					pw4.println(p.getName()+","+p.getID()+","+p.getSpecialty()+","+"no");
				}
				
			}else
			{
				pw4.println(p.getName()+","+p.getID()+","+p.getSpecialty()+","+p.getTeam().getName());
			}
			
		}
		FileWriter piezas = new FileWriter("piezas.txt");
		PrintWriter pw5 = new PrintWriter(piezas);
		Part pa = null;
		for(int a=0;a<parts.getCant();a++)
		{
			pa = parts.obtenerI(a);
			pw5.println(pa.getName()+","+pa.getPartCode()+","+pa.getTypePart()+","+pa.getCountry()+","+pa.getNecessaryMaterial());
		}
		FileWriter robots = new FileWriter("robots.txt");
		PrintWriter pw6 = new PrintWriter(robots);
		Robot ro = null;
		for(int a=0;a<robotos.getCant();a++)
		{
			ro = robotos.obtenerI(a);
			pw6.println(ro.getName()+","+ro.getNameArms()+","+ro.getNameLegs()+","+ro.getNameHead()+","+ro.getExtraQuality()+","+ro.getNameChest()+","+ro.getNameWeapon()+","+ro.getTeam()+","+ro.getPilotCode());
		}
		pw1.close();
		pw2.close();
		pw3.close();
		pw4.close();
		pw5.close();
		pw6.close();
		
	}
	
}
