package mansionbreak.things;

/**
 * Interfaz para todos los objetos, definiendo todas las caracteristicas obligatorias
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public interface ThingInterface {
	
	/**
	 * Metodo obligatorio para todos los personajes
	 * para poder saber su posicion
	 * 
	 * @return Devuelve un array  que contiene
	 * las coordenadas x, y del personaje dentro de una habitacion
	 * @see mansionbreak.mansion.Room
	 */
	int[] getLocation();
	
	/**
	 * Introduce la posicion del objeto dentro de una
	 * habitacion con coordenadas x, y.
	 * 
	 * @param location Array bidimensional que contenga
	 * las coordenadas x, y donde se quiere colocar el
	 * objeto dentro de una habitacion.
	 */
	void setLocation(int[] location);
	
	/**
	 * Para comprobar si el objeto se puede usar o no.
	 * 
	 * @return True si el el objeto se puede usar. False, si no.
	 */
	boolean isUsable();
	
	/**
	 * Introduce si el objeto se puede usar o no.
	 * 
	 * @param usable True para indicar si se puede usar. False para indicar si no se puede usar.
	 */
	void setUsable(boolean usable);
	
}
