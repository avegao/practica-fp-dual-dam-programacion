package mansionbreak.things;

import mansionbreak.characters.Vampire;

/**
 * Clase que implementa el Kit Basico Mata-Vampiros.
 * Permite matar zombies.
 * El comando para usarlo sera "uk".
 * El comando para cogerlo "ck".
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class BasicVampireKillingKit extends Thing {
	
	/**
	 * Constructor para el Kit Basico Mata-Vampiros
	 * 
	 * @param location Posicion en la que se va a encontrar en la habitacion. En caso de estar en la mochila, marcar como null.
	 */
	public BasicVampireKillingKit(int[] location) {
		super(location, true);
	}
	
	/**
	 * Mata al vampiro
	 * 
	 * @param vampire Objeto de tipo Vampire al que se le quiere matar
	 */
	public boolean use(Vampire vampire) {
		return vampire.kill();
	}
}
