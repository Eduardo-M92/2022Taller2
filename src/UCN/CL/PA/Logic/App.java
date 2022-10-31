package UCN.CL.PA.Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import UCN.CL.PA.Domain.Person;
import UCN.CL.PA.Domain.Robot;

public class App
{
	public static void main(String[] args) throws IOException
	{
		GumdamSystem sistema = new GumdamSystemImpl();
		leerArmas(sistema);
		leerPiezas(sistema);
		leerMateriales(sistema);
		leerPaises(sistema);
		leerRobots(sistema);
		leerPersonas(sistema);
		menu(sistema);
	}

	/**
	 * displays an extensive menu of options
	 */
	private static void menu(GumdamSystem sistema) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		boolean exit = true;
		while(exit)
		{
			
			desplegarMenuPrincipal();
			String option = sc.nextLine();
			
			switch(option)
			{
			case "1":
				boolean check = false;
				System.out.println("¿Que desea ingresar?:");
				System.out.println("1)Piezas");
				System.out.println("2)Armas");
				System.out.print("Su opcion: ");
				option = sc.nextLine();
				if(option.equals("1"))
				{
					check = ingresarPiezaArma(sc, 1, sistema);
				}else if(option.equals("2"))
				{
					check = ingresarPiezaArma(sc, 2, sistema);
				}else
				{
					System.out.println("------------------");
					System.out.println("Opcion incorrecta");
					System.out.println("------------------");
				}
				if(check)
				{
					System.out.println("-------------------------");
					System.out.println("Pieza/Arma Ingresada correctamente");
					System.out.println("-------------------------");
				}else
				{
					System.out.println("-------------------------");
					System.out.println("---- Error ----Pieza/Arma No Ingresada");
					System.out.println("-------------------------");
				}
				break;
			case "2":
				System.out.println("---- Ensamblando Robot ----");
				ensamblarRobot(sc, sistema);
				break;
			case "3":
				System.out.println("---- Crear equipo ----");
				if(crearEquipo(sc, sistema))
				{
					System.out.println("-------------------");
					System.out.println("Equipo creado");
					System.out.println("-------------------");
				}else
				{
					System.out.println("-------------------");
					System.out.println("Equipo NO creado");
					System.out.println("-------------------");
				}
				break;
			case "4":
				System.out.print("Ingresar tipo de pieza(cabeza, torax, etc.): ");
				String type = sc.nextLine().toLowerCase();
				while(!type.equals("brazos")&&!type.equals("piernas")&&!type.equals("pecho")&&!type.equals("cabeza"))
				{
					System.out.println("---- Error ---- Tipo incorrecto");
					System.out.print("Tipo(Brazos, Piernas, Pecho, Cabeza): ");
					type = sc.nextLine().toLowerCase();
				}
				System.out.println(sistema.buscarPorPieza(type));
				break;
			case "5":
				System.out.print("Ingresar Material: ");
				String material = sc.nextLine().toLowerCase();
				System.out.println(sistema.buscarPorMaterial(material));
				break;
			case "6":
				System.out.println("---- Crear Modelo ----");
				System.out.print("Ingrese nombre del robot al cual crear el modelo: ");
				String nameRobot = sc.nextLine();
				sistema.crearModelo(nameRobot);
				break;
			case "7":
				revisarRobot(sc, sistema);
				break;
			case "8":
				System.out.println(sistema.mostrarPersonas());
				System.out.println("Enter para continuar...");
				sc.nextLine();
				break;
			case "9":
				System.out.println(sistema.mostrarGrupos());
				System.out.println("Enter para continuar...");
				sc.nextLine();
				break;
			case "10":
				System.out.println(sistema.mostrarRobots());
				System.out.println("Enter para continuar...");
				sc.nextLine();
				break;
			case "11":
				System.out.println(sistema.revisarMunicion());
				System.out.print("Ingrese Nombre del robot a recargar: ");
				String name = sc.nextLine();
				System.out.print("Ingrese Municion a recargar: ");
				int ammo = Integer.parseInt(sc.nextLine());
				sistema.aumentarMunicion(name, ammo);
				break;
			case "12":
				System.out.println(sistema.mostrarPaises());
				System.out.println("Enter para continuar...");
				sc.nextLine();
				break;
			case "14":
				System.out.print("Ingrese un Pais: ");
				String pais = sc.nextLine();
				System.out.print("Ingrese cantidad a añadir: ");
				int cant = Integer.parseInt(sc.nextLine());
				sistema.añadirStockMateriales(pais, cant);
				System.out.println("Enter para continuar...");
				sc.nextLine();
				break;
			case "13":
				System.out.print("Ingrese un Pais: ");
				pais = sc.nextLine();
				System.out.print("Ingrese cantidad a añadir: ");
				cant = Integer.parseInt(sc.nextLine());
				sistema.añadirStockPiezas(pais, cant);
				System.out.println("Enter para continuar...");
				sc.nextLine();
				break;
			case "15":
				System.out.println(sistema.mostrarPiezasYArmas());
				System.out.println("Enter para continuar...");
				sc.nextLine();
				break;
			case "16":
				cambiarPiezas(sc, sistema);
				break;
			case "17":
				System.out.println("---- Menu ----");
				System.out.print("Ingrese usuario?: ");
				String user = sc.nextLine();
				System.out.print("Ingrese contraseña?: ");
				String pass = sc.nextLine();
				if(user.equals("empanada")&&pass.equals("porotosconriendas"))
				{
					System.out.print("Ingrese Opncion secreta(A - B): ");
					option = sc.nextLine().toUpperCase();
					switch (option) 
					{
					case "A":
						crearSet(sistema);
						break;
					case "B":
						sistema.destruirTodo();
						break;
					}
				}
				break;
			case "18":
				sistema.cerrarSistema();
				System.out.println("Saliendo...");
				exit=false;
				break;
			}
		}
	}
	
	
	public static void crearSet(GumdamSystem sistema)
	{
		sistema.ingresarPieza("casco", "21231", "head", "Area51", 10);
		sistema.ingresarPieza("peto", "62513", "torax", "Area51", 102);
		sistema.añadirMaterial("Uranio", "Area51", 1000000);
	}
	
	public static void cambiarPiezas(Scanner sc, GumdamSystem sistema)
	{
		System.out.print("Ingrese nombre del robot: ");
		String nameRobot = sc.nextLine();
		Robot robot = sistema.revisarRobot(nameRobot);
		System.out.println("Cabeza "+robot.getNameHead());
		System.out.println("Brazos "+robot.getNameArms());
		System.out.println("Piernas  "+robot.getNameLegs());
		System.out.println("Torax "+robot.getNameChest());
		System.out.println("Arma "+robot.getNameWeapon());
		boolean exit = true;
		while(exit)
		{
			System.out.println("Piezas para cambiar");
			System.out.println("1)Brazos");
			System.out.println("2)Piernas");
			System.out.println("3)Cabeza");
			System.out.println("4)Torax");
			System.out.println("5)Arma");
			System.out.print("Ingrese Lo que desea cambiar del robot: ");
			String option = sc.nextLine();
			String name = "";
			switch(option)
			{
			case "1":
				System.out.print("Ingrese Nombre de la Pieza: ");
				name = sc.nextLine();
				if(sistema.buscarNombreDePieza(name))
				{
					robot.setNameArms(name);
				}else {
					System.out.println("----------------------------------");
					System.out.println("Nombre de la pieza no encontrada en el sistema");
					System.out.println("----------------------------------");}
				break;
			case "2":
				System.out.print("Ingrese Nombre de la Pieza: ");
				name = sc.nextLine();
				if(sistema.buscarNombreDePieza(name))
				{
					robot.setNameArms(name);
				}else {
					System.out.println("----------------------------------");
					System.out.println("Nombre de la pieza no encontrada en el sistema");
					System.out.println("----------------------------------");}
				break;
			case "3":
				System.out.print("Ingrese Nombre de la Pieza: ");
				name = sc.nextLine();
				if(sistema.buscarNombreDePieza(name))
				{
					robot.setNameArms(name);
				}else {
					System.out.println("----------------------------------");
					System.out.println("Nombre de la pieza no encontrada en el sistema");
					System.out.println("----------------------------------");}
				break;
			case "4":
				System.out.print("Ingrese Nombre de la Pieza: ");
				name = sc.nextLine();
				if(sistema.buscarNombreDePieza(name))
				{
					robot.setNameArms(name);
				}else {
					System.out.println("----------------------------------");
					System.out.println("Nombre de la pieza no encontrada en el sistema");
					System.out.println("----------------------------------");}
				break;
			case "5":
				System.out.print("Ingrese Nombre del arma: ");
				name = sc.nextLine();
				if(sistema.buscarNombreDeArma(name))
				{
					robot.setNameWeapon(name);
				}else {
					System.out.println("----------------------------------");
					System.out.println("Nombre de la pieza no encontrada en el sistema");
					System.out.println("----------------------------------");}
				break;
			}
		}
	}
	public static void revisarRobot(Scanner sc, GumdamSystem sistema)
	{
		System.out.print("Ingrese nombre del robot a revisar: ");
		String nameRobot = sc.nextLine();
		Robot robot = sistema.revisarRobot(nameRobot);
		boolean exit = true;
		while(exit)
		{
			System.out.println("Piezas para cambiar");
			System.out.println("1)Brazos");
			System.out.println("2)Piernas");
			System.out.println("3)Cabeza");
			System.out.println("4)Torax");
			System.out.print("Ingrese Lo que desea cambiar del robot: ");
			String option = sc.nextLine();
			String name = "";
			switch(option)
			{
			case "1":
				System.out.print("Ingrese Nombre de la Pieza: ");
				name = sc.nextLine();
				if(sistema.buscarNombreDePieza(name))
				{
					robot.setNameArms(name);
				}else {
					System.out.println("----------------------------------");
					System.out.println("Nombre de la pieza no encontrada en el sistema");
					System.out.println("----------------------------------");}
				break;
			case "2":
				System.out.print("Ingrese Nombre de la Pieza: ");
				name = sc.nextLine();
				if(sistema.buscarNombreDePieza(name))
				{
					robot.setNameArms(name);
				}else {
					System.out.println("----------------------------------");
					System.out.println("Nombre de la pieza no encontrada en el sistema");
					System.out.println("----------------------------------");}
				break;
			case "3":
				System.out.print("Ingrese Nombre de la Pieza: ");
				name = sc.nextLine();
				if(sistema.buscarNombreDePieza(name))
				{
					robot.setNameArms(name);
				}else {
					System.out.println("----------------------------------");
					System.out.println("Nombre de la pieza no encontrada en el sistema");
					System.out.println("----------------------------------");}
				break;
			case "4":
				System.out.print("Ingrese Nombre de la Pieza: ");
				name = sc.nextLine();
				if(sistema.buscarNombreDePieza(name))
				{
					robot.setNameArms(name);
				}else {
					System.out.println("----------------------------------");
					System.out.println("Nombre de la pieza no encontrada en el sistema");
					System.out.println("----------------------------------");}
				break;
			}
		}
	}
	/*
	 * i'm proud of this code
	 * check if there are people without a team, and then ask if you want to put together a team with them check that there is only one pilot
	 * and then ask for names and id's for the remaining people
	 */
	public static boolean crearEquipo(Scanner sc, GumdamSystem sistema)
	{
		System.out.println("Personas sin team");
		//int[] cantProfeciones Pos[0] piloto Pos[1] cant ensambladores 
		int[] cantProfeciones = new int[2];
		Person[] names = sistema.getPersonasSinEquipo();
		String[] teamNames = new String[6];
		System.out.print("Ingrese un nombre para el equipo: ");
		String teamName = sc.nextLine();
		
		int cant = 0;
		for(int a=0;a<names.length;a++)
		{
			System.out.println((1+a)+")"+names[a].getName());
		}
		System.out.println("¿Quiere añadir estas personas a su nuevo equpo?");
		System.out.print("(Si - No): ");
		String option = sc.nextLine();
		if(option.toLowerCase().equals("si"))
		{
			for(int a=0;a<names.length;a++)
			{
				if(cant==6){break;}
				if(cantProfeciones[0]==0&&names[a].getSpecialty().toLowerCase().equals("piloto"))
				{
					teamNames[cant]=names[a].getName();
					cantProfeciones[0]+=1;
					cant++;
				}
				else if(cantProfeciones[1]<5&&!names[a].getSpecialty().toLowerCase().equals("piloto"))
				{
					teamNames[cant]=names[a].getName();
					cantProfeciones[1]+=1;
					cant++;
				}
			}
		}
		if(cantProfeciones[0]==1&&cantProfeciones[0]<5)
		{
			int statico = (5-cantProfeciones[1]);
			System.out.println("Faltan ("+(5-cantProfeciones[1])+") ensambladores");
			for(int a=0;a<statico;a++)
			{
				System.out.println("Ingrese datos del ensamblador("+(a+1)+")");
				System.out.print("Nombre: ");
				String name = sc.nextLine();
				System.out.print("Codigo de identificacion(ID): ");
				String ID = sc.nextLine();
				String specialt = "ensamblador";
				String team = teamName;
				cantProfeciones[1]+=1;
				teamNames[cant] = name;
				cant++;
				sistema.añadirPersona(name, ID, specialt, team);
			}
		}else if(cantProfeciones[0]==0&&cantProfeciones[0]<5)
		{
			System.out.println("Ingrese datos del piloto");
			System.out.print("Nombre: ");
			String name = sc.nextLine();
			System.out.print("Codigo de identificacion(ID): ");
			String ID = sc.nextLine();
			String specialt = "piloto";
			String team = teamName;
			teamNames[cant] = name;
			cant++;
			sistema.añadirPersona(name, ID, specialt, team);
			int statico = 5-cantProfeciones[1];
			if(cantProfeciones[1]<5)
			{
				System.out.println("Faltan ("+(5-cantProfeciones[1])+") ensambladores");
				for(int a=0;a<statico;a++)
				{
					System.out.println("Ingrese datos del ensamblador("+(a+1)+")");
					System.out.print("Nombre: ");
					 name = sc.nextLine();
					System.out.print("Codigo de identificacion(ID): ");
					ID = sc.nextLine();
					specialt = "ensamblador";
					team = teamName;
					teamNames[cant] = name;
					cant++;
					cantProfeciones[1]+=1;
					
					sistema.añadirPersona(name, ID, specialt, team);
				}
			}
		}
		return sistema.crearEquipo(teamName, teamNames);
	}
	
	/*
	 * verifies that the entered part exists and then the robot enters it into the system
	 */
	public static void ensamblarRobot(Scanner sc, GumdamSystem sistema)
	{
		System.out.print("Ingrese nombre de la cabeza: ");
		String head = sc.nextLine().toLowerCase();
		if(!sistema.buscarNombreDePieza(head))
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Cabeza no encontrada en el sistema... Regresando al menu");
			System.out.println("------------------------------------------------------------");
			return;
		}
		System.out.print("Ingrese nombre del torax: ");
		String torax = sc.nextLine().toLowerCase();
		if(!sistema.buscarNombreDePieza(torax))
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Torax no encontrado en el sistema... Regresando al menu");
			System.out.println("------------------------------------------------------------");
			return;
		}
		System.out.print("Ingrese nombre de los brazos: ");
		String arms = sc.nextLine().toLowerCase();
		if(!sistema.buscarNombreDePieza(arms))
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Brazos no encontrados en el sistema... Regresando al menu");
			System.out.println("------------------------------------------------------------");
			return;
		}
		System.out.print("Ingrese nombre de las piernas: ");
		String legs = sc.nextLine().toLowerCase();
		if(!sistema.buscarNombreDePieza(legs))
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Piernas no encontradas en el sistema... Regresando al menu");
			System.out.println("------------------------------------------------------------");
			return;
		}
		System.out.print("Ingrese cualidad extra: ");
		String extra = sc.nextLine();
		
		System.out.print("Ingrese nombre del arma: ");
		String gun = sc.nextLine().toLowerCase();
		if(!sistema.buscarNombreDeArma(gun))
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Arma no encontrada en el sistema... Regresando al menu");
			System.out.println("------------------------------------------------------------");
			return;
		}
		
		System.out.print("Ingrese nombre del equipo: ");
		String team = sc.nextLine().toUpperCase();
		if(!sistema.buscarNombreDeEquipo(team))
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Equipo no encontrado en el sistema... Regresando al menu");
			System.out.println("------------------------------------------------------------");
			return;
		}
		System.out.print("Ingrese codigo del piloto: ");
		String pilotCode = sc.nextLine().toLowerCase();
		if(!sistema.buscarCodigoPiloto(pilotCode))
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Piloto no encontrado en el sistema... Regresando al menu");
			System.out.println("------------------------------------------------------------");
			return;
		}
		
		System.out.print("Ingrese nombre del robot: ");
		String name = sc.nextLine().toLowerCase();
		
		sistema.ensamblarRobot(name, arms, legs, torax, head, extra, gun, team, pilotCode);
		System.out.println("------------------");
		System.out.println("Robot ensamblado...");
		System.out.println("------------------");
	}
	
	
	/*
	 * verifies that the entered part exists and then enters it into the system
	 */
	public static boolean ingresarPiezaArma(Scanner sc, int x, GumdamSystem sistema)
	{
		int necessaryMaterial = 0;
		String name = "";
		String code = "";
		String country = "";
		
		if(x==1)
		{
			System.out.println("Ingresando Pieza...");
			System.out.print("Nombre: ");
			name = sc.nextLine();
			System.out.print("Codigo: ");
			code = sc.nextLine();
			System.out.print("Pais: ");
			country = sc.nextLine();
			System.out.print("Tipo(Brazos, Piernas, Pecho, Cabeza): ");
			String type = sc.nextLine().toLowerCase();
			
			while(!type.equals("brazos")&&!type.equals("piernas")&&!type.equals("pecho")&&!type.equals("cabeza"))
			{
				System.out.println("---- Error ---- Tipo incorrecto");
				System.out.print("Tipo(Brazos, Piernas, Pecho, Cabeza): ");
				type = sc.nextLine().toLowerCase();
			}
			
			System.out.print("Material necesario: ");
			necessaryMaterial = Integer.parseInt(sc.nextLine());
			
			while(necessaryMaterial<=0)
			{
				System.out.println("---- Error ---- Valor ingresado incorrecto");
				System.out.print("Material necesario: ");
				necessaryMaterial = Integer.parseInt(sc.nextLine());
			}
			
			return sistema.ingresarPieza(name, code, type, country, necessaryMaterial);
		}
		else
		{
			System.out.println("Ingresando Arma...");
			System.out.print("Nombre: ");
			name = sc.nextLine();
			System.out.print("Codigo: ");
			code = sc.nextLine();
			System.out.print("Pais: ");
			country = sc.nextLine();
			System.out.print("Municion: ");
			int ammo = Integer.parseInt(sc.nextLine());
			
			while(ammo<0)
			{
				System.out.println("---- Error ---- Valor ingresado incorrecto");
				System.out.print("Municion: ");
				ammo = Integer.parseInt(sc.nextLine());
			}
			
			System.out.print("Material necesario: ");
			necessaryMaterial = Integer.parseInt(sc.nextLine());
			
			while(necessaryMaterial<=0)
			{
				System.out.println("---- Error ---- Valor ingresado incorrecto");
				System.out.print("Material necesario: ");
				necessaryMaterial = Integer.parseInt(sc.nextLine());
			}
			
			return sistema.ingresarArma(name, code, country, ammo, necessaryMaterial);
		}
	}
	
	public static void desplegarMenuPrincipal()
	{
		System.out.println("----------------------------------------------");
		System.out.println("Bienvenido al sistema de defensa planetaria");
		System.out.println("----------------------------------------------");
		System.out.println("1)Ingresar pieza o arma");
		System.out.println("2)Ensamblar robot");
		System.out.println("3)Crear equipo");
		System.out.println("4)Buscar por tipo de piesa");
		System.out.println("5)Buscar por material");
		System.out.println("6)Crear Modelo");
		System.out.println("7)Revisar piezas");
		System.out.println("8)Mostrar todas las personas");
		System.out.println("9)Mostrar todos los grupos");
		System.out.println("10)Mostrar todos los robots");
		System.out.println("11)revisar municion");
		System.out.println("12)Mostrar todos los paises");
		System.out.println("13)Añadir stock piezas");
		System.out.println("14)Añadir stock Materiales");
		System.out.println("15)Mostrar todas las Piezas y armas");
		System.out.println("16)Cambiar piezas");
		System.out.println("17)Opciones administrativas");
		System.out.println("18)Cerrar sistema");
		System.out.print("Ingrese opcion: ");
	}

	public static void leerRobots(GumdamSystem sistema) throws FileNotFoundException
	{
		Scanner arch = new Scanner(new File("robots.txt"));
		while(arch.hasNext())
		{
			String[] parts = arch.nextLine().split(",");
			String name = parts[0];
			String nameArms = parts[1];
			String nameLegs = parts[2];
			String nameChest = parts[5];
			String nameHead = parts[3];
			String extraQuality = parts[4];
			String nameWeapon = parts[6];
			String nameTeam = parts[7];
			String pilotCode = parts[8];
			
			sistema.ensamblarRobot(name, nameArms, nameLegs, nameChest, nameHead, extraQuality, nameWeapon, nameTeam, pilotCode);
		}
	}
	
	public static void leerPersonas(GumdamSystem sistema) throws FileNotFoundException
	{
		Scanner arch = new Scanner(new File("personas.txt"));
		while(arch.hasNext())
		{
			String[] parts = arch.nextLine().split(",");
			String name = parts[0];
			String ID = parts[1];
			String specialty = parts[2];
			String team = parts[3];
			
			
			sistema.añadirPersona(name, ID, specialty, team);
		}
	}

	public static void leerPiezas(GumdamSystem sistema) throws FileNotFoundException
	{
		Scanner arch = new Scanner(new File("piezas.txt"));
		while(arch.hasNext())
		{
			String[] parts = arch.nextLine().split(",");
			String name = parts[0];
			String code = parts[1];
			String type = parts[2];
			String country = parts[3];
			int necessaryMaterial = Integer.parseInt(parts[4]);
			
			sistema.ingresarPieza(name, code, type, country, necessaryMaterial);
		}
	}

	public static void leerPaises(GumdamSystem sistema) throws FileNotFoundException
	{
		Scanner arch = new Scanner(new File("paises.txt"));
		while(arch.hasNext())
		{
			String[] parts = arch.nextLine().split(",");
			String name = parts[0];
			String partType = parts[1];
			int amount = Integer.parseInt(parts[2]);
			String partCode = parts[3];
			String material = parts[4];
			
			sistema.añadirContribucion(name, partType, partCode, material, amount);
		}
	}

	public static void leerMateriales(GumdamSystem sistema) throws FileNotFoundException
	{
		Scanner arch = new Scanner(new File("materiales.txt"));
		while(arch.hasNext())
		{
			String[] parts = arch.nextLine().split(",");
			String name = parts[0];
			int stock = Integer.parseInt(parts[1]);
			String country = parts[2];
			System.out.println("Material");
			sistema.añadirMaterial(name, country, stock);
		}
	}

	public static void leerArmas(GumdamSystem sistema) throws FileNotFoundException
	{
		Scanner arch = new Scanner(new File("armas.txt"));
		while(arch.hasNext())
		{
			String[] parts = arch.nextLine().split(",");
			String name = parts[0];
			String code = parts[1];
			int ammo = Integer.parseInt(parts[2]);
			String country = parts[3];
			int necessaryMaterial = Integer.parseInt(parts[4]);
			
			sistema.ingresarArma(name, code, country, ammo, necessaryMaterial);
		}
		
	}
}
