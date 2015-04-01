package mansionbreak.things;

/**
 * Clase que implementa la silla
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Chair extends Thing {
	
	/**
	 * Constructor de una silla
	 * 
	 * @param location Habitación en la que estará la silla
	 */
	public Chair(int[] location) {
		super(location, false);
	}

}
