package mansionbreak.things;

/**
 * Clase que implementa las escaleras
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Stairway extends Thing {
	
	/**
	 * Constructor para las escaleras
	 * 
	 * @param location Habitación en la que se van a colocar las escaleras
	 */
	public Stairway(int[] location) {
		super(location, false);
	}

}
