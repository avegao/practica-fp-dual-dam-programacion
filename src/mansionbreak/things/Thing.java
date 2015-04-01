package mansionbreak.things;

/**
 * Clase madre para todos los objetos, sean usables o no.
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Thing implements ThingInterface {
	
	private int[] location;
	private boolean usable;
	
	/**
	 * Contructor al que se le pasa la posicon dentro de una habitacion
	 * y si el objeto va a poder usarse o no.
	 * 
	 * @param location Array de enteros bidimensional con las coordenadas (x, y) del objeto dentro de la habitacion. En caso de estar en la mochila, marcar como null.
	 * @param usable True si es usable, false si no lo es.
	 * @see mansionbreak.mansion.Room
	 */
	public Thing(int[] location, boolean usable) {
		this.location = location;
		this.usable = usable;
	}
	
	/**
	 * Devuelve la posicion del objeto dentro de la habitacion o si esta en la mochila
	 * 
	 * @return Array de enteros bidimensional con las coordenadas (x, y) del objeto dentro de la habitacion. Si esta en la mochila, devuelve Null.
	 */
	@Override
	public int[] getLocation() {
		return location;
	}
	
	/**
	 * Cambia la posicion del objeto dentro de la habitacion o poner que se encuentra en la mochila
	 * 
	 * @param location Array de enteros bidimensional con las coordenadas (x, y) del objeto dentro de la habitacion. Si se va a poner en la mochila, poner Null.
	 */
	@Override
	public void setLocation(int[] location) {
		this.location = location;
	}
	
	/**
	 * Consulta si el objeto se puede usar
	 * 
	 * @return True si se puede usar el obejto y false si no.
	 */
	@Override
	public boolean isUsable() {
		return usable;
	}
	
	/**
	 * Indica si el objeto se puede usar
	 * 
	 * @param usable True si se puede usar, False si no se puede usar
	 */
	@Override
	public void setUsable(boolean usable) {
		this.usable = usable;
	}

}
