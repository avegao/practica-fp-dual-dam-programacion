package mansionbreak.mansion;

import java.util.ArrayList;

import mansionbreak.Util;
import mansionbreak.characters.Character;
import mansionbreak.characters.Ghost;
import mansionbreak.characters.Vampire;
import mansionbreak.characters.Zombie;
import mansionbreak.things.Ax;
import mansionbreak.things.BasicVampireKillingKit;
import mansionbreak.things.Chair;
import mansionbreak.things.Cross;
import mansionbreak.things.Door;
import mansionbreak.things.FruitJuice;
import mansionbreak.things.Stairway;
import mansionbreak.things.Table;
import mansionbreak.things.Thing;
import mansionbreak.things.Vacuum;
import mansionbreak.things.Vase;
import mansionbreak.things.Window;

public class Mansion {
	
	// Array tridimensional que contiene todas las habitaciones de la mansión según sus coordenadas
	private Room[][][] rooms = new Room[Util.MANSION_MAX_X][Util.MANSION_MAX_Y][Util.MANSION_MAX_Z];
	
	// Guarda las coordenadas de la habitación actual y también en un objeto para su mejor usabilidad
	private int[] currentRoomLocation = new int[3];
	private Room currentRoom;
	
	// Crea todos los mosntruos que habrá en la mansión
	private Ghost ghost = new Ghost(Util.randomLocation());
	private Vampire vampire = new Vampire(Util.randomLocation());
	private Zombie zombie = new Zombie(Util.randomLocation());;
	
	// Crea todos los objetos que se van a usar en la habitación
	private Ax ax = new Ax(Util.randomLocation());
	private BasicVampireKillingKit basicVampireKillingKit = new BasicVampireKillingKit(Util.randomLocation());
	private Cross cross = new Cross(new int[] {-1, -1, -1});
	private FruitJuice fruitJuice = new FruitJuice(Util.randomLocation());
	private Vacuum vacuum = new Vacuum(Util.randomLocation());
	
	/**
	 * Constructor para la mansión
	 */
	public Mansion() {
		// Llama a esta función para mayor comodidad a la hora de recolocar toda la mansión
		reallocate();
	}
	
	/**
	 * Devuelve el fantasma de la mansión
	 * 
	 * @return Fantasma de la mansión
	 */
	public Ghost getGhost() {
		return ghost;
	}
	
	/**
	 * Devuelve el vampiro de la mansión
	 * 
	 * @return Vampiro de la mansión
	 */
	public Vampire getVampire() {
		return vampire;
	}
	
	/**
	 * Devuelve el zombie la mansión
	 * 
	 * @return Zombie de la mansión
	 */
	public Zombie getZombie() {
		return zombie;
	}
	
	/**
	 * Devuelve el hacha de la mansión
	 * 
	 * @return Hacha de la mansión
	 */
	public Ax getAx() {
		return ax;
	}
	
	/**
	 * Devuelve el Kit Básico Mata-Vampiros de la mansión
	 * 
	 * @return Kit Básico Mata-Vampiros de la mansión
	 */
	public BasicVampireKillingKit getBasicVampireKillingKit() {
		return basicVampireKillingKit;
	}
	
	/**
	 * Devuelve la cruz de la mansión
	 * 
	 * @return Cruz de la mansión
	 */
	public Cross getCross() {
		return cross;
	}
	
	/**
	 * Devuelve el zumo de frutas de la mansión
	 * 
	 * @return Zumo de frutas de la mansión
	 */
	public FruitJuice getFruitJuice() {
		return fruitJuice;
	}
	
	/**
	 * Devuelve la aspiradora de la mansión
	 * 
	 * @return Aspiradora de la mansión
	 */
	public Vacuum getVacuum() {
		return vacuum;
	}
	
	/**
	 * Reorganiza toda mansión como por ejmplo cuando te encuentras al fantasma.
	 */
	public void reallocate() {
		
		boolean ghostInRoom = false;
		boolean vampireInRoom = false;
		boolean zombieInRoom = false;
		
		boolean axInRoom = false;
		boolean basicVampireKillingKitInRoom = false;
		boolean crossInRoom = false;
		boolean fruitJuicetInRoom = false;
		boolean vacuumInRoom = false;
		
		int roomNumber = 0;
			
		for (int x = 0; x < Util.MANSION_MAX_X; x++) { // Avanza por el eje x
			
			for (int y = 0; y < Util.MANSION_MAX_Y; y++) { // Avanza por el eje y
				
				for(int z = 0; z < Util.MANSION_MAX_Z; z++) { // Avanza por el eje z
					
					// Guarda los personajes y los objetos que pueda haber en la habitación
					ArrayList<Character> characters = new ArrayList<Character>();
					ArrayList<Thing> things = new ArrayList<Thing>();
					
					int[] thisRoom = {x, y, z}; // Guarda las coordenadas de la habitación actual
					
					// Si el fantasma está en estas coordenadas, se guarda en la habitación
					if (Util.compareLocations(thisRoom, ghost.getLocation())) {
						characters.add(ghost);
						ghostInRoom = true;
					}
					
					// Si el vampiro está en estas coordenadas, se guarda en la habitación
					if (Util.compareLocations(thisRoom, vampire.getLocation())) {
						
						// Si está en alguna ventana de estas, se guarda en la habitación incluido el segundo if
						if ((x == 0 && (y == 0 || y == 2)) || x == 2 && (y == 0 || y == 2)) {
							
							characters.add(vampire);
							
						} else if ((x == 0 && y == 1) || (x == 1 && (y == 0 || y == 2)) || (x == 2 && (y == 0 || y == 2)) || (x == 3 && y == 1)) {
							
							characters.add(vampire);
							
						} else {
							 // Sino se obliga a guardar en la pared de la izquierda
							vampire.setLocation(new int[] {Util.randomNumber(0, 3), 0, Util.randomNumber(0, 2)});
						}
						
						vampireInRoom = true;
						
					}
					
					// Si el zombie está en estas coordenadas, se guarda en la habitación
					if (Util.compareLocations(thisRoom, zombie.getLocation())) {
						
						// Pero si coincide con algún otro monstruo, se vuelven a crear una coordenadas para él
						if (Util.compareLocations(zombie.getLocation(), vampire.getLocation()) || Util.compareLocations(zombie.getLocation(), ghost.getLocation())) {
						
							if (x < 3 && y < 2 && z < 2 ) {
								zombie.setLocation(new int[] {x + 1, y + 1, z + 1});
							} else {
								zombie.setLocation(new int[] {x - 1, y - 1, z - 1});
								
								rooms[x - 1][y - 1][z - 1].addCharacter(zombie);
							}
							
						} else {
							
							// Sino simplemente se guarda en esta habitación
							characters.add(zombie);
							zombieInRoom = true;							
						}
						
					}
					
					// Si el hacha está en estas coordenadas, se guarda en la habitación
					if (Util.compareLocations(thisRoom, ax.getLocation())) {
						things.add(ax);
						axInRoom = true;
					}
					
					// Si el Kit Básico Mata-Vampiros está en estas coordenadas, se guarda en la habitación
					if (Util.compareLocations(thisRoom, basicVampireKillingKit.getLocation())) {
						things.add(basicVampireKillingKit);
						basicVampireKillingKitInRoom = true;
					}
					
					// Si la cruz está en estas coordenadas, se guarda en la habitación
					if (Util.compareLocations(thisRoom, cross.getLocation())) {
						things.add(cross);
						crossInRoom = true;
					}
					
					// Si el zumo de frutas está en estas coordenadas, se guarda en la habitación
					if (Util.compareLocations(thisRoom, fruitJuice.getLocation())) {
						things.add(fruitJuice);
						fruitJuicetInRoom = true;
					}
					
					// Si la aspiradora está en estas coordenadas, se guarda en la habitación
					if (Util.compareLocations(thisRoom, vacuum.getLocation())) {
						
						if (!ghostInRoom) {
							things.add(vacuum);
							vacuumInRoom = true;
						} else {
							// Pero si coincide que se encuentra en la misma habitación que fantasma se le daotra localización
							while (Util.compareLocations(vacuum.getLocation(), ghost.getLocation()))
								vacuum.setLocation(Util.randomLocation());
							
						}
						
					}
					
					int tablesNumber = 0;
					int chairsNumber = 0;
					int vasesNumber = 0;
					
					final int MAX_TABLES_NUMBER = 2;
					final int MAX_CHAIRS_NUMBER = 4;
					final int MAX_VASES_NUMBER = 2;
					
					// Crea las mesas aleatoriamente
					for (int i = 0; i <= Util.randomNumber(0, MAX_TABLES_NUMBER); i++) {
						things.add(new Table(thisRoom));
						tablesNumber++;
					}
					
					// Crea las sillas aleatoriamente
					for (int i = 0; i <= Util.randomNumber(0, MAX_CHAIRS_NUMBER); i++) {
						things.add(new Chair(thisRoom));
						chairsNumber++;
					}
					
					// Crea los jarrones aleatoriamente
					for (int i = 0; i <= Util.randomNumber(0, MAX_VASES_NUMBER); i++) {
						things.add(new Vase(thisRoom));
						vasesNumber++;
					}
					
					// Crea las puertas y las ventanas si es necesario
					// Se comprueba si la habitacion pertenece a algun borde exterior 
					if ((x == 0 && (y == 0 || y == 2)) || x == 2 && (y == 0 || y == 2)) {
						
						things.add(new Window(thisRoom));
						things.add(new Window(thisRoom));
						
					} else if ((x == 0 && y == 1) || (x == 1 && (y == 0 || y == 2)) || (x == 2 && (y == 0 || y == 2)) || (x == 3 && y == 1)) {
						
						things.add(new Window(thisRoom));
						
					}
						
					// Se comprueba si la habitación debe tener 2, 3 o 4 puertas
					if (
							(x == 0 && (y == 0 || y == 2)) ||
							(x == 2 && (y == 0 || y == 2))) {
						
						things.add(new Door(thisRoom));
						things.add(new Door(thisRoom));
						
					} else if (
								(y == 0 && (x == 1 || x == 2)) ||
								(y == 1 && (x == 0 || x == 3)) ||
								(y == 2 && (x == 1 || x == 2)) ) {
						
						things.add(new Door(thisRoom));
						things.add(new Door(thisRoom));
						things.add(new Door(thisRoom));
						
					} else {
						
						things.add(new Door(thisRoom));
						things.add(new Door(thisRoom));
						things.add(new Door(thisRoom));
						things.add(new Door(thisRoom));
						
					}
					
					if (x == 1 && y == 1) {
						things.add(new Stairway(thisRoom));
					}
					
					this.rooms[x][y][z] = new Room(characters, things);
					
					if (roomNumber != (36 - 1))
						roomNumber++;
				}
				
			}
			
		}
		
		// Se guarda la loclización de una haitación aleatoria y también su respectivo objeto
		currentRoomLocation[Util.X] = Util.randomNumber(0, Util.MANSION_MAX_X);
		currentRoomLocation[Util.Y] = Util.randomNumber(0, Util.MANSION_MAX_Y);
		currentRoomLocation[Util.Z] = Util.randomNumber(0, Util.MANSION_MAX_Z);
		
		currentRoom = rooms[currentRoomLocation[Util.X]][currentRoomLocation[Util.Y]][currentRoomLocation[Util.Z]];
		
	}
	
	/**
	 * Devuelve la localización de la habitación actual
	 * 
	 * @return Array que devuelve las coordenadas (x, y, z) de la habitación actual
	 */
	public int[] getCurrentRoomLocation() {
		return this.currentRoomLocation;
	}
	
	/**
	 * Nueva localización actual
	 * 
	 * @param currentRoomLocation Array de 3 elementos con la nueva localización que se va a tener
	 */
	public void setCurrentRoomLocation(int[] currentRoomLocation) {
		this.currentRoomLocation = currentRoomLocation;
	}
	
	/**
	 * Devuelve la habitación actual
	 * 
	 * @return Habitación actual
	 */
	public Room getCurrentRoom() {
		return this.currentRoom;
	}

}
