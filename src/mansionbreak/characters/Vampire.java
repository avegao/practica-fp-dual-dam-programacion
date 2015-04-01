package mansionbreak.characters;

/**
 * Clase que implementa al vampiro
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Vampire extends Character {
	
	private boolean weakened;
	
	/**
	 * Constructor del vampiro
	 * 
	 * @param location Localización en la que se encontrará el vampiro dentro de la mansión.
	 */
	public Vampire(int[] location) {
		super(location);
		this.setWeakened(false);
	}

	/**
	 * Indica si esta debiliado o no el vampiro
	 * 
	 * @return True si esta debilitado, false si lo esta.
	 */
	public boolean isWeakened() {
		return weakened;
	}

	/**
	 * Poner si esta debilitado o no el vampiro.
	 * 
	 * @param weakened True si esta debilitado, False si no lo esta.
	 */
	public void setWeakened(boolean weakened) {
		this.weakened = weakened;
	}
	
	/**
	 * Debilita el vampiro
	 */
	public void weaken() {
		this.setWeakened(true);
	}
	
	/**
	 * Mata al vampiro si antes de ello lo has debilitado con la cruz.
	 * 
	 * @return True si ha conseguido matar al vampiro,
	 * false si antes de ello necesitas debilitarlo.
	 */
	public boolean kill() {
		
		if (this.weakened) {
			this.setAlive(false);
			
			setLocation(new int[] {-1, -1, -1});
			
			return true;
		} else {
			this.setAlive(true);
			return false;
		}
	}

}
