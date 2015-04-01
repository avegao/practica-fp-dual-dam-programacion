package mansionbreak.characters;

import mansionbreak.Util;
import mansionbreak.mansion.Mansion;
import mansionbreak.things.Bag;

/**
 * Clase que implementa al jugador
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Player extends Character {
	
	private Bag bag = new Bag();
	private Mansion mansion;
	
	/**
	 * Contructor del jugador
	 * 
	 * @param mansion Mension en la que se va a mover el jugador
	 * @param bag Mochila que se le va a asignar al jugador
	 */
	public Player(Mansion mansion, Bag bag) {
		super(mansion.getCurrentRoomLocation());
		this.mansion = mansion;
		this.setBag(bag);
	}

	/**
	 * Devuelve la mochila que tiene asignada actualmente el jugador
	 * 
	 * @return Devuelve la mochila asignada al jugador
	 */
	public Bag getBag() {
		return bag;
	}

	/**
	 * Guarda una nueva mochila al jugador
	 * 
	 * @param bag Se le pasa la mochila que le será asignada al jugador
	 */
	public void setBag(Bag bag) {
		this.bag = bag;
	}
	
	/**
	 * Mueve al personaje a través de la mansión 
	 * 
	 * @param movement Cadena de dos carácteres que indican los movimientos posibles del jugador (mn, ms, mo, ms, s, b)
	 */
	public void move(String movement) {
		
		// Guarda la localización actual del jugador
		int[] location = mansion.getCurrentRoomLocation();
		
		if (movement.equals("mn")) { // Mover al norte
			
			--location[Util.Y];
			
		} else if (movement.equals("ms")) { // Mover al sur
			
			++location[Util.Y];
			
		} else if (movement.equals("mo")) { // Mover al oeste
			
			--location[Util.X];
			
		} else if (movement.equals("me")) { // Mover al este
			
			++location[Util.X];
			
		} else if (movement.equals("s")) { // Subir escaleras
			
			++location[Util.Z];
			
		} else if (movement.equals("b")) { // Bajar escaleras
			
			--location[Util.Z]; 
			
		}
		
		mansion.setCurrentRoomLocation(location); // Guarda la nueva localización del jugador
		
	}
	
}
