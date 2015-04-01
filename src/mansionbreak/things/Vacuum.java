package mansionbreak.things;

import mansionbreak.characters.Ghost;

/**
 * Clase que implementa la aspiradora.
 * Se usa para capturar al fantasma.
 * El comando para usarla sera "ua".
 * El comando para cogerla "ca".
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Vacuum extends Thing {
	
	/**
	 * Constructor para la aspiradora
	 * 
	 * @param location Posicion en la que se va a encontrar en la habitacion. En caso de estar en la mochila, marcar como null.
	 */
	public Vacuum(int[] location) {
		super(location, true);
	}
	
	/**
	 * Usar la aspiradora para capturar al fantasma.
	 * 
	 * @param ghost Objeto de tipo Ghost al que se le quiere capturar.
	 * @see Ghost
	 */
	public void use(Ghost ghost) {
		ghost.kill();
	}
	
}
