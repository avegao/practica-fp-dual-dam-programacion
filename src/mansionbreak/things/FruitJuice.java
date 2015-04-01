package mansionbreak.things;

/**
 * Clase que implementa el zumo de frutas.
 * No tiene ninguna utilidad practica en la aplicacion de momento
 * pero en un futuro se puede probar a usarlo para recuperar vida perdida.
 * El comando para usarla sera "uz".
 * El comando para cogerla "cz".
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class FruitJuice extends Thing {
	
	/**
	 * Costructor para el Zumo de frutas
	 * 
	 * @param location Posicion en la que se va a encontrar en la habitacion. En caso de estar en la mochila, marcar como null.
	 */
	public FruitJuice(int[] location) {
		super(location, true);
	}

}
