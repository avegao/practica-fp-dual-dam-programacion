package mansionbreak.characters;

/**
 * Clase que implementa al Zombie
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Zombie extends Character {
	
	/**
	 * Constructor para el zombie
	 * 
	 * @param location Localización en la que se encontrará el zombie dentro de la mansión.
	 */
	public Zombie(int[] location) {
		super(location);
	}
	
	/**
	 * Mata al zombie
	 */
	public void kill() {
		this.setAlive(false);
		setLocation(new int[] {-1, -1, -1});
	}
}
