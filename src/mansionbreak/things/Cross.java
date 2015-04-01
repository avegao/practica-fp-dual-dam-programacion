package mansionbreak.things;

import mansionbreak.characters.Vampire;

/**
 * Clase que implementa la cruz.
 * Se usa para debilitar al vampiro.
 * El comando para usarla sera "uc".
 * El comando para cogerla "cc".
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Cross extends Thing {
	
	/**
	 * Constructor para la cruz
	 * 
	 * @param location Posicion en la que se va a encontrar en la habitacion. En caso de estar en la mochila, marcar como null.
	 */
	public Cross(int[] location) {
		super(location, true);
	}
	
	/**
	 * Debilia al vampiro, pero no lo mata.
	 * 
	 * @param vampire Objeto de tipo Vampire al que se le quiere debilitar.
	 * @see Vampire
	 */
	public void use(Vampire vampire) {
		vampire.weaken();
	}

}
