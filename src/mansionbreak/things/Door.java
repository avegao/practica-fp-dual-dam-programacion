package mansionbreak.things;

/**
 * Clase que implementa una puerta
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Door extends Thing {
	
	/**
	 * Constructor de una puerta
	 * 
	 * @param location Habitación en la que se va a colocar la puerta
	 */
	public Door(int[] location) {
		super(location, false);
	}

}
