package mansionbreak.characters;

/**
 * Interfaz que define los metodos basicos que debe tener un personaje
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public interface CharacterInterface {
	
	/**
	 * Metodo obligatorio para todos los personajes
	 * para poder saber su localización dentro de la mansión
	 * 
	 * @return Devuelve un array que contiene
	 * las coordenadas (x, y, z) del personaje dentro de la mansión
	 * 
	 * @see mansionbreak.mansion.Mansion
	 */
	int[] getLocation();
	
	/**
	 * Introduce la posicion del personaje dentro de una
	 * habitacion con coordenadas (x, y, z).
	 * 
	 * @param location Array que contenga
	 * las coordenadas (x, y, z) donde se quiere colocar el
	 * personaje dentro de la mansión.
	 * 
	 * @see mansionbreak.mansion.Mansion
	 */
	void setLocation(int[] location);
	
	/**
	 * Para comprobar si el personaje esta vivo o muerto
	 * 
	 * @return True si el personaje esta vivo. False, si esta muerto.
	 */
	boolean isAlive();
	
	/**
	 * Introduce si el personaje esta vivo o muerto.
	 * 
	 * @param alive True para indicar si esta vivo. False para indicar si esta muerto.
	 */
	void setAlive(boolean alive);
	
}
