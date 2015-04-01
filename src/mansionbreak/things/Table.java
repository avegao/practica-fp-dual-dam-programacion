package mansionbreak.things;

/**
 * Clase que implementa una mesa
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Table extends Thing {

	/**
	 * Constructor para las mesas
	 * 
	 * @param location Habitación donde se va a colocar
	 */
	public Table(int[] location) {
		super(location, false);
	}

}
