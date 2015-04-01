package mansionbreak.things;

/**
 * Clase que implementa una ventana
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Window extends Thing {
	
	/**
	 * Constructor para las ventanas
	 * 
	 * @param location Habitación donde se va a colocar
	 */
	public Window(int[] location) {
		super(location, false);
	}

}
