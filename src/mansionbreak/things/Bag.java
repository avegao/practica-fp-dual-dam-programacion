package mansionbreak.things;

/**
 * Clase para la mochila en la que se almacenan
 * los objetos que va recogiendo el jugador.
 * 
 * @author Alvaro de la Vega Olmedilla <alvarodlvo@gmail.com>
 */
public class Bag {
	
	/**
	 * Constante que define el limite de objetos que guarda la mochila
	 * Actualmente el limite es 5 objetos como máximo en la mochila
	 */
	private final static int DEFAULT_BAG_LIMIT = 5;
	
	/**
	 * Array que guarda todos los objetos que hay en la mochila
	 */
	private Thing[] things;
	
	/**
	 * Contiene el numero de objetos que contiene la mochila actualmente
	 */
	private int thingsNumber;
	
	/**
	 * Crea una mochila con los objetos que se
	 * le pasen en el array.
	 * <b>El limite de la mochile se define en este array, asi que ten cuidado</b>
	 * 
	 * @param things Array que contiene los objetos con los que se quiere empezar en la mochila
	 * @see Thing
	 */
	public Bag(Thing[] things) {
		this.things = things; 
	}
	
	/**
	 * Crea una mochila con el limite de capacidad que se le indique
	 * 
	 * @param limit Limite que se impondra a la capacidad de la mochila
	 */
	public Bag(int limit) {
		this.things = new Thing[limit];
	}
	
	/**
	 * Constructor de la mochila vacio.
	 * Crea la mochila con hueco para 5 objetos
	 */
	public Bag() {
		// Crea la longitud del array según se indica en la costante
		this.things = new Thing[DEFAULT_BAG_LIMIT];
	}
	
	/**
	 * Devuelve los objetos presentes en la mochila
	 * 
	 * @return Devuelve en forma de array todos
	 * los objetos presentes en la mochila.
	 */
	public Thing[] getThings() {
		return things;
	}
	
	/**
	 * Guarda todos los objetos deseados a la mochila
	 * <b>OJO Se van a borrar todos los objetos
	 * anteriores.</b>
	 * 
	 * @param things Array que contenga todos los objetos
	 * que se quieran guardar.
	 */
	public void setThings(Thing[] things) {
		this.things = things;
	}
	
	/**
	 * Devuelve el numero de objetos presentes en la mochila
	 * 
	 * @return Devuelve un entero con el numero de objetos
	 * que hay en la mochila
	 */
	public int getThingsNumber() {
		return thingsNumber;
	}
	
	/**
	 * Devuelve el limite de objetos que puede haber en la mochila
	 * 
	 * @return Devuelve el limite que puede haber en la mochila
	 */
	public static int getDefaultBagLimit() {
		return DEFAULT_BAG_LIMIT;
	}

	/**
	 * Anyade un nuevo objeto a la mochila
	 * va recorriendo el array things y cuando encuentre
	 * un hueco libre (Null), guarda ahi el nuevo objeto.
	 * Tambien comprueba si dicho objeto es usable o no.
	 * 
	 * @param thing Objeto que se quiere añadir a la mochila
	 * @return Devuelve true si ha conseguido guardar el objeto
	 * y false si no lo ha conseguido
	 */
	public boolean addThing(Thing thing) {
		if (things.length != thingsNumber) {
			
			things[thingsNumber] = thing;
			thingsNumber++;
			
			return true;
			
		} else return false;
	}
	
	/**
	 * Elimina el objeto de que se le pasa por parametro si
	 * se encuentra en la mochila previamente
	 * 
	 * @param thing Objeto que se quiere quitar de la mochila
	 * @return Devuelve true si ha conseguido borrar el objeto de la mochila,
	 * false si no lo ha conseguido.
	 */
	public boolean deleteThing(Thing thing) {
		
		// Si no hay ningun objeto en la mochila devuelve false
		if (thingsNumber == 0) {
			return false;
		} else {
			
			for (int i = 0; i < thingsNumber; i++) {
				
				// Si el objeto qeu se queire elinar coincide con laguno de la mochila
				// lo borra
				if (things[i].equals(thing)) {
					
					// Mueve los objetos de la mochila para localizarlos más facilemtne después
					for (int j = i; j < thingsNumber; j++) {
						things[i] = things[i + 1];
					}
					
					thingsNumber--;
					
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	/**
	 * Vacía la mochila
	 */
	public void empty() {
		for (int i = 0; i < thingsNumber; i++) { // Recorre toda la mochila y pone todos los valores a null
			things[i] = null;
		}
	}
}
