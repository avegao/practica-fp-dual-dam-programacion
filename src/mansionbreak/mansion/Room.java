package mansionbreak.mansion;

import java.util.ArrayList;

import mansionbreak.characters.Character;
import mansionbreak.things.Thing;

/**
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Room {
	
	private int tablesNumber;
	private int chairsNumber;
	private int vasesNumber;
	
	private ArrayList<Character> characters;
	private ArrayList<Thing> things;
	
	/**
	 * Constructor de las habitaciones
	 * 
	 * @param characters Personajes que habrá en la habitación
	 * @param things Objetos que habrá en la habitación
	 */
	public Room(ArrayList<Character> characters, ArrayList<Thing> things){
		this.characters = characters;
		this.things = things;
	}
	
	/**
	 * Devuelve los personajes que hay en la habitación
	 * 
	 * @return ArrayList que contiene a los personajes que habrá en la habitación
	 */
	public ArrayList<Character> getCharacters() {
		return this.characters;
	}
	
	/**
	 * Devuelve los objetos que hay en la habitación
	 * 
	 * @return ArrayList que contiene los objetos que habrá en la habitación
	 */
	public ArrayList<Thing> getThings() {
		return this.things;
	}
	
	/**
	 * Añade un personaje a la habitación
	 * @param character
	 */
	public void addCharacter(Character character) {
		this.characters.add(character);
	}
	
	/**
	 * Añade un objeto en la habitación
	 * @param thing
	 */
	public void addThing(Thing thing) {
		this.things.add(thing);
	}
	
	/**
	 * Devuelve el número de mesas
	 * 
	 * @return Número de mesas
	 */
	public int getTablesNumber() {
		return tablesNumber;
	}
	
	/**
	 * Devuelve el número de sillas
	 * 
	 * @return Número de sillas
	 */
	public int getChairsNumber() {
		return chairsNumber;
	}

	/**
	 * Devuelve el número de jarrones
	 * 
	 * @return Número de jarrones
	 */
	public int getVasesNumber() {
		return vasesNumber;
	}
	
}
