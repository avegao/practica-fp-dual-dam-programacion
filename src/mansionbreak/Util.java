package mansionbreak;

public class Util {
	
	// Constantes que guardan las dimensiones máximas de la mansión
	public static final int MANSION_MAX_X = 4;
	public static final int MANSION_MAX_Y = 3;
	public static final int MANSION_MAX_Z = 3;
	
	// Constantes que guardan las dimensiones máximas de una habitación
	public static final int ROOM_MAX_X = 5;
	public static final int ROOM_MAX_Y = 7;
	
	// Para los arrays que guardan alguna coordenada, para que sea más fácil de visualizar
	public static final int X = 0;
	public static final int Y = 1;
	public static final int Z = 2;
	
	/**
	 * Método que genera unas coordenadas aleatorias (x, y)
	 * 
	 * @return int[] Devuelve un array con dos valores que indica unas coordenadas aleatorias en (x, y)
	 */
	public static int[] randomCoordinates() {
		int x = (int) (Math.random() * (0 - ROOM_MAX_X + 1) + ROOM_MAX_X);
		int y = (int) (Math.random() * (0 - ROOM_MAX_Y + 1) + ROOM_MAX_Y);
		
		return new int[]{x, y};
	}
	
	/**
	 * 
	 * @return int[] Devuelve un array con tres valores que indica una localización dentro de la mansión aleatoria (x, y, z)
	 */
	public static int[] randomLocation() {
		int x = (int) (Math.random() * (0 - MANSION_MAX_X + 1) + MANSION_MAX_X);
		int y = (int) (Math.random() * (0 - MANSION_MAX_Y + 1) + MANSION_MAX_Y);
		int z = (int) (Math.random() * (0 - MANSION_MAX_Z + 1) + MANSION_MAX_Z);
		
		return new int[] {x, y, z};
	}
	
	/**
	 * Genera un número aleatorio entre los dos valores que se le indiquen
	 * 
	 * @param min Número mínimo para generar el número aleatorio
	 * @param max Número máximo para generar el número aleatorio
	 * @return Número aleatorio
	 */
	public static int randomNumber(int min, int max) {
		return (int) (Math.random() * (min - max + 1) + max);
	}
	
	/**
	 * Compara un array unidimensional con 3 valores (x, y, z)
	 * 
	 * @param location1 Localización 1
	 * @param location2 Localización 2
	 * @return Verdadero si es la misma lo calizacióm, Falso si no es la misma localización
	 */
	public static boolean compareLocations(int[] location1, int[] location2) {
		
        boolean b = true;
        
        if (location1 != null && location2 != null) {
        	
        	if (location1.length != location2.length) {
        		
        		b = false;
        		
        	} else {
        		
        		for (int i = 0; i < location2.length; i++) {
                  
        			if (location2[i] != location1[i]) {
        				b = false;    
        			}              
        		}
        	}
        } else {
        	b = false;
        }
        
        return b;
        
    }
	
}
