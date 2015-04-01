package mansionbreak.things;

import mansionbreak.characters.Zombie;

/**
 * Clase que implementa el Hacha.
 * Permite matar zombies.
 * El comando para usarla sera "uh".
 * El comando para cogerla "ch".
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Ax extends Thing {

	/**
	 * Constructor para el hacha
	 * 
	 * @param location Posicion en la que se va a encontrar en la habitacion. En caso de estar en la mochila, marcar como null.
	 */
	public Ax(int[] location) {
		super(location, true);
	}
	
	/**
	 * Mata al zombie con el hacha
	 * 
	 * @param zombie Objeto de tipo Zombie al que se le quiere matar con el hacha
	 */
	public void use(Zombie zombie) {
		zombie.kill();
	}
	
}
