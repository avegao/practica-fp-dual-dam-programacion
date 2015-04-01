package mansionbreak.characters;

import mansionbreak.mansion.Room;

/**
 * Clase madre para todos los personajes, ya sea para
 * el jugador o para los monstruos
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Character implements CharacterInterface {
	
	private int[] location;
	private boolean alive;
	
	/**
	 * Contructor para un personaje
	 * 
	 * @param location Posicion en la que se encontrará el personaje dentro de la habitacion.
	 */
	public Character(int[] location) {
		this.location = location;
		this.alive = true;
	}
	
	/**
	 * Devuelve la posicion en la que se encuentra el personaje
	 * 
	 * @return Array de enteros bidemensional con las coordenadas (x, y)del personaje dentro de la habitacion
	 * @see Room
	 */
	@Override
	public int[] getLocation() {
		return location;
	}
	
	/**
	 * Cambia la posicion del personaje dentro de la habitacion
	 * 
	 * @param location Array de enteros bidimensional con las coordenadas (x, y) del personaje dentro de la habitacion
	 * @see Room
	 */
	@Override
	public void setLocation(int[] location) {
		this.location = location;
	}
	
	/**
	 * Indica si el personaje esta vivo (true) o muerto (false)
	 * 
	 * @return Si es true, el personaje esta vivo, y false si esta muerto 
	 */
	@Override
	public boolean isAlive() {
		return alive;
	}
	
	/**
	 * Cambia la vida del personaje
	 * 
	 * @param alive True si vive, false si muere
	 */
	@Override
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
