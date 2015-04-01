package mansionbreak.characters;

/**
 * Clase que implementa al fantasma
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Ghost extends Character {
	
	/**
	 * Constructor para el fantasma
	 * 
	 * @param location Localización en la que se encontrará el fantasma dentro de la mansión.
	 */
	public Ghost(int[] location) {
		super(location);
	}
	
	/**
	 * Mata al fantasma
	 */
	public void kill() {
		this.setAlive(false);
		setLocation(new int[] {-1, -1, -1});
	}

}
