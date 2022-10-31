package UCN.CL.PA.Logic;

import java.io.IOException;

import UCN.CL.PA.Domain.Person;
import UCN.CL.PA.Domain.Robot;

public interface GumdamSystem
{
	/**
	 * 
	 * @return String with information on the pieces and weapons
	 */
	public String mostrarPiezasYArmas();

	public String mostrarPersonas();
	/**
	 *  returns people without equipment so that the user can assemble a team with these
	 * @return a vector with people
	 */
	public Person[] getPersonasSinEquipo();

	public String mostrarGrupos();

	public String mostrarRobots();

	public String revisarMunicion();
	/**
	 * deploy the robots with their ammunition information
	 */
	public String buscarPorPieza(String typePart);
	/**
	 * enter a string as a parameter, check if the material exists
	 * @return true if material exists false otherwise
	 */
	public String buscarPorMaterial(String material);

	public String mostrarPaises();
	/**
	 * doing some mathematical calculations create a name for the model
	 * @return the model name
	 */
	public String crearModelo(String nombreDelRobot);
	
	public void ensamblarRobot(String name, String nameArms,String nameLegs, String nameChest, String nameHead, String extraQuality, String nameWeapon, String team, String pilotCode);
	
	public void añadirStockPiezas(String pais, int cantidad);
	
	public void añadirStockMateriales(String pais,int cantidad);
	
	public void aumentarMunicion(String nombreDelRobot, int cantidad);
	
	public void destruirTodo();
	
	public void cerrarSistema() throws IOException;
	
	public boolean crearEquipo(String nameTeam,String [] team);
	
	public boolean añadirPersona(String name, String ID, String speciality, String team);
	
	public boolean añadirMaterial(String name, String country, int Stock);
	
	public boolean añadirContribucion(String country, String partType, String partCode, String material, int amount);
	
	public boolean ingresarPieza(String name, String partCode, String typePart, String country, int necessaryMaterial);
	
	public boolean ingresarArma(String name, String code, String country, int ammo, int necessaryMaterial);
	/*
	 * name of a robot
	 * @return Robot
	 */
	public Robot revisarRobot(String nombreDelRobot);
	
	public boolean buscarNombreDePieza(String name);
	
	public boolean buscarNombreDeArma(String name);
	
	public boolean buscarNombreDeEquipo(String name);
	
	public boolean buscarCodigoPiloto(String code);
	
}
