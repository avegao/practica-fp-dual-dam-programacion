package mansionbreak;

import java.util.ArrayList;
import java.util.Scanner;

import mansionbreak.characters.Character;
import mansionbreak.characters.Player;
import mansionbreak.mansion.Mansion;
import mansionbreak.mansion.Room;
import mansionbreak.things.Ax;
import mansionbreak.things.Bag;
import mansionbreak.things.BasicVampireKillingKit;
import mansionbreak.things.Cross;
import mansionbreak.things.FruitJuice;
import mansionbreak.things.Thing;
import mansionbreak.things.Vacuum;

public class Main {
	
	private static Mansion mansion;
	private static Bag bag;
	private static Player player;

	public static void main(String[] args) {
		
		System.out.println("                 __  __          _   _  _____ _____ ____  _   _ ");
		System.out.println("                |  \\/  |   /\\   | \\ | |/ ____|_   _/ __ \\| \\ | |");
		System.out.println("                | \\  / |  /  \\  |  \\| | (___   | || |  | |  \\| |");
		System.out.println("                | |\\/| | / /\\ \\ | . ` |\\___ \\  | || |  | | . ` |");
		System.out.println("                | |  | |/ ____ \\| |\\  |____) |_| || |__| | |\\  |");
		System.out.println("                |_|  |_/_/    \\_\\_| \\_|_____/|_____\\____/|_| \\_|\n\n");
		
		
		System.out.println("                       ____  _____  ______          _  __");
		System.out.println("                      |  _ \\|  __ \\|  ____|   /\\   | |/ /");
		System.out.println("                      | |_) | |__) | |__     /  \\  | ' /");
		System.out.println("                      |  _ <|  _  /|  __|   / /\\ \\ |  <");
		System.out.println("                      | |_) | | \\ \\| |____ / ____ \\| . \\");
		System.out.println("                      |____/|_|  \\_\\______/_/    \\_\\_|\\_\\ \n\n");
		
		mansion = new Mansion();
		
		bag = new Bag();
		
		player = new Player(mansion, bag);
		
		// Guarda las localizaciones de los monstruos en la mansión
		int [] ghostLocation = mansion.getGhost().getLocation();
		int [] vampireLocation = mansion.getVampire().getLocation();
		int [] zombieLocation = mansion.getZombie().getLocation();
		
		// Guarda las localizaciones de los objetos en la mansión
		int [] axLocation = mansion.getAx().getLocation();
		int [] basicVampireKillingKitLocation = mansion.getBasicVampireKillingKit().getLocation();
		int [] fruitJuiceLocation = mansion.getFruitJuice().getLocation();
		int [] vacuumLocation = mansion.getVacuum().getLocation();
		
		// Si se le pasa 1 como argumento al programa, indica donde están todos los monstruos y objetos
		if (args.length >= 0) {
			
			if (args.length > 0 && args[0].equals("1")) {
				
				System.out.println("Localización de los monstruos:");
				System.out.println("------------------------------\n");
				
				System.out.println("Fantasma: Habitación " + ghostLocation[Util.X] + ", " + ghostLocation[Util.Y] + ", piso " + ghostLocation[Util.Z] + "\n");
				System.out.println("Vampiro: Habitación " + vampireLocation[Util.X] + ", " + vampireLocation[Util.Y] + ", piso " + vampireLocation[Util.Z] + "\n");
				System.out.println("Zombie: Habitación " + zombieLocation[Util.X] + ", " + zombieLocation[Util.Y] + ", piso " + zombieLocation[Util.Z] + "\n\n");
				
				System.out.println("Localización de los objetos:");
				System.out.println("---------------------------\n");
				
				System.out.println("Hacha: Habitación " + axLocation[Util.X] + ", " + axLocation[Util.Y] + ", piso " + axLocation[Util.Z] + "\n");
				System.out.println("Kit básico mata-vampiros: Habitación " + basicVampireKillingKitLocation[Util.X] + ", " + basicVampireKillingKitLocation[Util.Y] + ", piso " + basicVampireKillingKitLocation[Util.Z] + "\n");
				System.out.println("Zumo de frutas: Habitación " + fruitJuiceLocation[Util.X] + ", " + fruitJuiceLocation[Util.Y] + ", piso " + fruitJuiceLocation[Util.Z] + "\n");
				System.out.println("Aspiradora: Habitación " + vacuumLocation[Util.X] + ", " + vacuumLocation[Util.Y] + ", piso " + vacuumLocation[Util.Z] + "\n");
				
			} else if (args.length == 0) {
				
				System.out.println("Localización de los monstruos:");
				System.out.println("------------------------------\n");
				
				System.out.println("Fantasma: Habitación " + ghostLocation[Util.X] + ", " + ghostLocation[Util.Y] + ", piso " + ghostLocation[Util.Z] + "\n");
				System.out.println("Vampiro: Habitación " + vampireLocation[Util.X] + ", " + vampireLocation[Util.Y] + ", piso " + vampireLocation[Util.Z] + "\n");
				System.out.println("Zombie: Habitación " + zombieLocation[Util.X] + ", " + zombieLocation[Util.Y] + ", piso " + zombieLocation[Util.Z] + "\n\n");
				
				System.out.println("Localización de los objetos:");
				System.out.println("---------------------------\n");
				
				System.out.println("Hacha: Habitación " + axLocation[Util.X] + ", " + axLocation[Util.Y] + ", piso " + axLocation[Util.Z] + "\n");
				System.out.println("Kit básico mata-vampiros: Habitación " + basicVampireKillingKitLocation[Util.X] + ", " + basicVampireKillingKitLocation[Util.Y] + ", piso " + basicVampireKillingKitLocation[Util.Z] + "\n");
				System.out.println("Zumo de frutas: Habitación " + fruitJuiceLocation[Util.X] + ", " + fruitJuiceLocation[Util.Y] + ", piso " + fruitJuiceLocation[Util.Z] + "\n");
				System.out.println("Aspiradora: Habitación " + vacuumLocation[Util.X] + ", " + vacuumLocation[Util.Y] + ", piso " + vacuumLocation[Util.Z] + "\n");
				
			}
			
		}
		
		// Muestra todo y realiza los comandos
		do {
			
			// Guarda la localizacion de la habitacion actual y su respectivo objeto
			int[] currentRoomLocation = mansion.getCurrentRoomLocation();
			Room currentRoom = mansion.getCurrentRoom();
			
			// Guarda los objetos y los monstruos que hay en la habitación
			ArrayList<Character> characters = currentRoom.getCharacters();
			ArrayList<Thing> things = currentRoom.getThings();
			
			// Variables que indican si hay algun monstruo en la habitacion 
			boolean ghostInRoom = false;
			boolean vampireInRoom = false;
			boolean zombieInRoom = false;
			
			// Variables que indican si hay algun objeto en la habitacion 
			boolean axInRoom = false;
			boolean basicVampireKillingKitInRoom = false;
			boolean crossInRoom = false;
			boolean fruitJuiceInRoom = false;
			boolean vacuumInRoom = false;
			
			// Variable que indica si hay escaleras en la habitacion 
			boolean stairwayInRoom = false;
			
			// Guarda la localización de la cruz
			int [] crossLocation = mansion.getCross().getLocation();
			
			// Muestra los mosntruos que hay en la habitación
			System.out.println("Habitación: " + currentRoomLocation[Util.X] + ", " + currentRoomLocation[Util.Y] + " Piso: " + currentRoomLocation[Util.Z] + "\n");
			
			System.out.println("Monstruos:");
			System.out.println("----------");
			
			// Si es el fantasma
			if (Util.compareLocations(currentRoomLocation, ghostLocation)) {
				System.out.println("Oh no, te has encontrado al fantasma");
				
				ghostInRoom = true;
				
				// Y si hay algo en la mochila
				if (bag.getThingsNumber() > 0) {
					
					System.out.println("El maldito fantasma va a revolverlo todo!");
					
					// Pero si tienes la aspiradora no te hace nada
					for (int i = 0; i < bag.getThingsNumber(); i++) {
						
						if (bag.getThings()[i] instanceof Vacuum) {
							
							System.out.println("Pero tienes la aspiradora en la mochila, rápido, usala introduciendo 'ua' en los comandos");
							
						} else {
							// Sino cambia todo de localización y te vacia la mochila
							if (i == bag.getThingsNumber() - 1) {
								
								mansion.reallocate();
								bag.empty();
								
								if (args.length >= 0) {
									
									if (args.length > 0 && args[0].equals("1")) {
										
										System.out.println("Localización de los monstruos:");
										System.out.println("------------------------------\n");
										
										System.out.println("Fantasma: Habitación " + ghostLocation[Util.X] + ", " + ghostLocation[Util.Y] + ", piso " + ghostLocation[Util.Z] + "\n");
										System.out.println("Vampiro: Habitación " + vampireLocation[Util.X] + ", " + vampireLocation[Util.Y] + ", piso " + vampireLocation[Util.Z] + "\n");
										System.out.println("Zombie: Habitación " + zombieLocation[Util.X] + ", " + zombieLocation[Util.Y] + ", piso " + zombieLocation[Util.Z] + "\n\n");
										
										System.out.println("Localización de los objetos:");
										System.out.println("---------------------------\n");
										
										System.out.println("Hacha: Habitación " + axLocation[Util.X] + ", " + axLocation[Util.Y] + ", piso " + axLocation[Util.Z] + "\n");
										System.out.println("Kit básico mata-vampiros: Habitación " + basicVampireKillingKitLocation[Util.X] + ", " + basicVampireKillingKitLocation[Util.Y] + ", piso " + basicVampireKillingKitLocation[Util.Z] + "\n");
										System.out.println("Zumo de frutas: Habitación " + fruitJuiceLocation[Util.X] + ", " + fruitJuiceLocation[Util.Y] + ", piso " + fruitJuiceLocation[Util.Z] + "\n");
										System.out.println("Aspiradora: Habitación " + vacuumLocation[Util.X] + ", " + vacuumLocation[Util.Y] + ", piso " + vacuumLocation[Util.Z] + "\n");
										
									} else if (args.length == 0) {
										
										System.out.println("Localización de los monstruos:");
										System.out.println("------------------------------\n");
										
										System.out.println("Fantasma: Habitación " + ghostLocation[Util.X] + ", " + ghostLocation[Util.Y] + ", piso " + ghostLocation[Util.Z] + "\n");
										System.out.println("Vampiro: Habitación " + vampireLocation[Util.X] + ", " + vampireLocation[Util.Y] + ", piso " + vampireLocation[Util.Z] + "\n");
										System.out.println("Zombie: Habitación " + zombieLocation[Util.X] + ", " + zombieLocation[Util.Y] + ", piso " + zombieLocation[Util.Z] + "\n\n");
										
										System.out.println("Localización de los objetos:");
										System.out.println("---------------------------\n");
										
										System.out.println("Hacha: Habitación " + axLocation[Util.X] + ", " + axLocation[Util.Y] + ", piso " + axLocation[Util.Z] + "\n");
										System.out.println("Kit básico mata-vampiros: Habitación " + basicVampireKillingKitLocation[Util.X] + ", " + basicVampireKillingKitLocation[Util.Y] + ", piso " + basicVampireKillingKitLocation[Util.Z] + "\n");
										System.out.println("Zumo de frutas: Habitación " + fruitJuiceLocation[Util.X] + ", " + fruitJuiceLocation[Util.Y] + ", piso " + fruitJuiceLocation[Util.Z] + "\n");
										System.out.println("Aspiradora: Habitación " + vacuumLocation[Util.X] + ", " + vacuumLocation[Util.Y] + ", piso " + vacuumLocation[Util.Z] + "\n");
										
									}
									
								}
								
							}
							continue;
						}
						
					}
					
				}
				
			} else if (Util.compareLocations(currentRoomLocation, vampireLocation)) { // Si es el vampiro
				
				System.out.println("Oh no, te has encontrado al vampiro, cuidado que no te chupe la sangre. Vigila tu cuello!\n");
				
				vampireInRoom = true;
				
			} else if (Util.compareLocations(currentRoomLocation, zombieLocation)) { // Si es el zombie
				
				System.out.println("Oh no, te has encontrado al zombie, cuidado que no te coma el cerebro, o ¿acaso quieres que se coma el poco cerebro que te queda?\n");
				
				zombieInRoom = true;
				
			} else { // Y si no hay ningún monstruo
				
				System.out.println("No hay ningun monstruo en esta habitacion, pero anda con cuidado\n");
				
			}
			
			// Muestra todos los objetos que hay en la habitación
			System.out.println("Objetos:");
			System.out.println("--------");
			
			// Si es el hacha
			if (Util.compareLocations(currentRoomLocation, axLocation)) {
				
				System.out.println("Has encontrado el hacha, ya te puedes enfrentar al zombie sin que te coma el cerebro");
				
				axInRoom = true;
				
			} else if (Util.compareLocations(currentRoomLocation, basicVampireKillingKitLocation)) { // Si es el KBMV
				
				System.out.println("Has encontrado el Kit Basico Mata-Vampiros, ya puedes matar al vampiro, pero cuidado que antes lo tienes que debilitar...");
				
				basicVampireKillingKitInRoom = true;
			
			} else if (Util.compareLocations(currentRoomLocation, fruitJuiceLocation)) { // Si es el zumo de frutas
				
				System.out.println("Has encontrado el zumo de frutas. Ummmm ricas vitaminas...");
				
				fruitJuiceInRoom = true;
				
			} else if (Util.compareLocations(currentRoomLocation, vacuumLocation)) { // Si es la aspiradora
				
				System.out.println("Has encontrado la aspiradora. ¿Que haces que no te pones a limpiar el polvo? GUARRO, ¿no ves que esto esta lleno de polvo?");
				
				vacuumInRoom = true;
				
			} else if (Util.compareLocations(currentRoomLocation, crossLocation)) { // Si es la cruz
				
				System.out.println("El zombie ha soltado la cruz");
				
				crossInRoom = true;
				
			}
			
			// Indica el número de ventanas
			if ((currentRoomLocation[Util.X] == 0 && (currentRoomLocation[Util.Y] == 0 || currentRoomLocation[Util.Y] == 2)) || currentRoomLocation[Util.X] == 2 && (currentRoomLocation[Util.Y] == 0 || currentRoomLocation[Util.Y] == 2)) {
				
				System.out.println("Hay dos ventanas, pero no puedes salir por ninguna");
				
			} else if ((currentRoomLocation[Util.X] == 0 && currentRoomLocation[Util.Y] == 1) || (currentRoomLocation[Util.X] == 1 && (currentRoomLocation[Util.Y] == 0 || currentRoomLocation[Util.Y] == 2)) || (currentRoomLocation[Util.X] == 2 && (currentRoomLocation[Util.Y] == 0 || currentRoomLocation[Util.Y] == 2)) || (currentRoomLocation[Util.X] == 3 && currentRoomLocation[Util.Y] == 1)) {
				
				System.out.println("Hay una ventana, pero no puedes salir por ella");
				
			}
			
			// Indica el número de puertas
			if ((currentRoomLocation[Util.X] == 0 && (currentRoomLocation[Util.Y] == 0 || currentRoomLocation[Util.Y] == 2)) || (currentRoomLocation[Util.X] == 2 && (currentRoomLocation[Util.Y] == 0 || currentRoomLocation[Util.Y] == 2))) {
				
				System.out.println("Hay 2 puertas");
				
			} else if ((currentRoomLocation[Util.Y] == 0 && (currentRoomLocation[Util.X] == 1 || currentRoomLocation[Util.X] == 2)) || (currentRoomLocation[Util.Y] == 1 && (currentRoomLocation[Util.X] == 0 || currentRoomLocation[Util.X] == 3)) || (currentRoomLocation[Util.Y] == 2 && (currentRoomLocation[Util.X] == 1 || currentRoomLocation[Util.X] == 2)) ) {
				
				System.out.println("Hay 3 puertas");
				
			} else {
				
				System.out.println("Hay 4 puertas");
				
			}
			
			// Indica si hay escaleras
			if (currentRoomLocation[Util.X] == 1 && currentRoomLocation[Util.Y] == 1) {
				
				System.out.println("Hay unas escaleras, puedes subir o bajar de piso");
				
				stairwayInRoom = true;
				
			}
			
			// Muestra los comandos disponibles
			System.out.println("\nComandos:");
			System.out.println("---------");
			
			// Para moverte al norte o al sur
			switch (currentRoomLocation[Util.Y]) {
				case 0:
					System.out.println("ms\t\t Moverte al sur");
				
					break;
				
				case 1:
					System.out.println("mn\t\t Moverte al norte");
					System.out.println("ms\t\t Moverte al sur");
				
					break;
					
				case 2:
		
					System.out.println("mn\t\t Moverte al norte");

					break;
					
			}
			
			// Para moverte al oeste o al este
			switch (currentRoomLocation[Util.X]) {
				case 0:
					System.out.println("me\t\t Moverte al este");
				
					break;
				
				case 1:
				case 2:
					System.out.println("mo\t\t Moverte al oeste");
					System.out.println("me\t\t Moverte al este");
		
					break;
					
				case 3:
					System.out.println("mo\t\t Moverte al oeste");
		
					break;
				
			}
			
			if (stairwayInRoom) {
				
				// Para subir o bajar las escaleras
				switch (currentRoomLocation[Util.Z]) {
					case 0:
						System.out.println("s\t\t Subir escaleras");
					
						break;
					
					case 1:
						System.out.println("s\t\t Subir escaleras");
						System.out.println("b\t\t Bajar escaleras");
			
						break;
						
					case 2:
						System.out.println("b\t\t Bajar escaleras");
			
						break;
				
				}
				
			}
			
			// Guarda las cosas de la mochila
			Thing[] thingsInBag = bag.getThings();
			
			boolean axInBag = false;
			boolean basicVampireKillingKitInBag = false;
			boolean crossInBag = false;
			boolean fruitJuiceInBag = false;
			boolean vacuumInBag = false;
			
			// Si hay un hacha en la habitación y no está ya en la mochila
			if (axInRoom && !axInBag)
				System.out.println("ch\t\t Coger hacha");
			
			// Si hay una cruz y no está ya en la mochila
			if (crossInRoom && !crossInBag)
				System.out.println("cc\t\t Coger cruz");
			
			// Si hay un KBMV y no está ya en la mochila
			if (basicVampireKillingKitInRoom && !basicVampireKillingKitInBag)
				System.out.println("ck\t\t Coger Kit básico mata-vampiros");
			
			// Si hay un zumo de frutas y no está ya en la mochila
			if (fruitJuiceInRoom && !fruitJuiceInBag)
				System.out.println("cz\t\t Coger zumo de frutas");
			
			// Si hay una aspiradora y no está ya en la mochila
			if (vacuumInRoom && !vacuumInBag)
				System.out.println("ca\t\t Coger aspiradora");
			
			// Si el vampiro está muerto y estás en la habitación donde estaba el vampiro
			if (!mansion.getVampire().isAlive() && vampireInRoom)
				System.out.println("e\t\t Salir de la mansión por la ventana");
			
			// Comandos de uso
			
			// Recorre la mochuila para saber que objetos hay en ella
			for (int i = 0; i < bag.getThingsNumber(); i++) {
				
				// Si hya un hacha
				if (thingsInBag[i] instanceof Ax) {
					
					System.out.println("uh\t\t Usar hacha");
					
					axInBag = true;
					
				} else if (thingsInBag[i] instanceof BasicVampireKillingKit) { // Si hay un KBMV
					
					System.out.println("uk\t\t Usar Kit básico mata-vampiros");
					
					basicVampireKillingKitInBag = true;
					
				} else if (thingsInBag[i] instanceof Cross) { // Si hay una cruz
					
					System.out.println("uc\t\t Usar cruz");
					
					crossInBag = true;
					
				} else if (thingsInBag[i] instanceof FruitJuice) { // Si hay un zumo de frutas
					
					System.out.println("uz\t\t Usar zumo de frutas");
					
					fruitJuiceInBag = true;
					
				} else if (thingsInBag[i] instanceof Vacuum) { // Si hay una aspiradora
					
					System.out.println("ua\t\t Usar aspiradora");
					
					vacuumInBag = true;
					
				}
				
			}
			
			Scanner scanner = new Scanner(System.in);
			
			// Pide los comandos al usuario por teclado
			System.out.print("\n\nIntroduce un comando de los anteriores: ");
			String command = scanner.nextLine();
			
			// Compara los comandos y los ejecuta
			if (command.equals("mn")) { // Mover al norte
				
				switch (currentRoomLocation[Util.Y]) {
					case 1:
					case 2:
						player.move("mn");
					
						break;
					
					default:
						System.out.println("No puedes moverte al norte");
					
				}
				
			} else if (command.equals("ms")) { // Mover al sur
				
				switch (currentRoomLocation[Util.Y]) {
					case 0:
					case 1:
						player.move("ms");
					
						break;
					
					default:
						System.out.println("No puedes moverte al sur");
				}
				
			} else if (command.equals("mo")) { // Mover al oeste
				
				switch (currentRoomLocation[Util.X]) {
					case 1:
					case 2:
					case 3:
						player.move("mo");
			
						break;
						
					default:
						System.out.println("No puedes moverte al oeste");
						
						break;
				}
				
			} else if (command.equals("me")) { // Mover al este
				
				switch (currentRoomLocation[Util.X]) {
					case 0:
					case 1:
					case 2:
						player.move("me");
						break;
					
					default:
						System.out.println("No puedes moverte al este");
						
						break;
					
				}
				
			} else if (command.equals("s")) { // Subir escaleras
				
				switch (currentRoomLocation[Util.Z]) {
					case 0:
					case 1:
						player.move("s");
					
						break;
					
					default:
						System.out.println("No puedes subir las escaleras");
						
						break;
				
				}
				
			} else if (command.equals("b")) { // Bajar escaleras
				
				switch (currentRoomLocation[Util.Z]) {
					case 1:
					case 2:
						player.move("b");
					
						break;
					
					default:
						System.out.println("No puedes bajar las escaleras");
						
						break;
				
				}
				
			} else if (command.equals("e")) { // Salir de la mansion
				
				if (!mansion.getVampire().isAlive() && vampireInRoom) {
					
					System.out.println("Has conseguido salir por la ventana y has huido de esa maldita mansion. Pero... La pregunta es... ¿Cómo has conseguido salir vivo de ahí si eres un inutil?");
					
					if (currentRoomLocation[Util.Z] != 0)
						System.out.println("Pero has saltado desde mucha altura y te has lesionado el tobillo");
					
					scanner.close();
					
					return;
					
				} else {
					System.out.println("No puedes escapar mientras el vampiro siga vivo o si no estás en la misma habiación que la ventana abierta");
				}
					
			} else if (command.equals("ch")) { // Coger el hacha
				
				if (axInRoom && !axInBag) {
					
					bag.addThing(mansion.getAx());
					axInBag = true;
					axInRoom = false;
					things.remove(mansion.getAx());
					mansion.getAx().setLocation(new int[] {-1, -1, -1});
					
					System.out.println("Has cogido el hacha, se ha guardado en la mochila");
					
				} else {
					System.out.println("No puedes coger el hacha");
				}
				
			} else if (command.equals("cc")) { // Coger la cruz
				
				if (crossInRoom && !crossInBag) {
					
					bag.addThing(mansion.getCross());
					crossInBag = true;
					crossInRoom = false;
					things.remove(mansion.getCross());
					mansion.getCross().setLocation(new int[] {-1, -1, -1});
					
					System.out.println("Has cogido la cruz, se ha guardado en la mochila");
					
				} else {
					System.out.println("No puedes coger la cruz");
				}
				
			} else if (command.equals("ck")) { // Coger el KBMV
				
				if (basicVampireKillingKitInRoom && !basicVampireKillingKitInBag) {
					
					bag.addThing(mansion.getBasicVampireKillingKit());
					basicVampireKillingKitInBag = true;
					basicVampireKillingKitInRoom = false;
					things.remove(mansion.getBasicVampireKillingKit());
					mansion.getBasicVampireKillingKit().setLocation(new int[] {-1, -1, -1});
					
					System.out.println("Has cogido el kit básico mata-vampiros, se ha guardado en la mochila");
					
				} else {
					System.out.println("No puedes coger el kit básico mata-vampiros");
				}
				
			} else if (command.equals("cz")) { // Coger zumo
				
				if (fruitJuiceInRoom && !fruitJuiceInBag) {
					
					bag.addThing(mansion.getFruitJuice());
					fruitJuiceInBag = true;
					fruitJuiceInRoom = false;
					things.remove(mansion.getFruitJuice());
					mansion.getFruitJuice().setLocation(new int[] {-1, -1, -1});
					
					System.out.println("Has cogido el zumo de frutas, se ha guardado en la mochila");
					
				} else {
					System.out.println("No puedes coger el zumo de frutas");
				}
				
			} else if (command.equals("ca")) { // Coger aspiradora
				
				if (vacuumInRoom && !vacuumInBag) {
					
					Vacuum vacuum = mansion.getVacuum();
					
					bag.addThing(vacuum);
					vacuumInBag = true;
					vacuumInRoom = false;
					things.remove(vacuum);
					mansion.getVacuum().setLocation(new int[] {-1, -1, -1});
					
					System.out.println("Has cogido la aspiradora, se ha guardado en la mochila");
					
				} else {
					System.out.println("No puedes coger la aspiradora");
				}
				
			} else if (command.equals("uh")) { // Usar hacha
				
				if (axInBag && zombieInRoom && mansion.getZombie().isAlive()) {
					
					System.out.println("Has matado al zombie. Pero... Le has cortado la cabeza ¿no?");
					
					// Cuando matas al zombie suelta la cruz
					mansion.getZombie().kill();
					currentRoom.getCharacters().remove(mansion.getZombie());
					
					currentRoom.addThing(mansion.getCross());
					mansion.getCross().setLocation(currentRoomLocation);
					crossInRoom = true;
					
					bag.deleteThing(mansion.getAx());
					mansion.getAx().setLocation(new int[] {-1, -1, -1});
					
					
				} else if (!zombieInRoom || !mansion.getZombie().isAlive()) {
					
					System.out.println("¿Qué estás intentando atravesar las paredes con hachazos? ¡Pedazo de bestia!");
					
				} else if (!axInBag) {
					
					System.out.println("Aún no tienes el hacha en la mochila");
					
				}
				
			} else if (command.equals("uc")) { // Usar cruz
				
				if (crossInBag && vampireInRoom && !mansion.getVampire().isWeakened()) {
					
					System.out.println("Has debilitado al vampiro, pero no lo has matado");
					
					mansion.getVampire().weaken();
					
					bag.deleteThing(mansion.getCross());
					mansion.getCross().setLocation(new int[] {-1, -1, -1});
					
				} else if (mansion.getVampire().isWeakened()) {
					
					System.out.println("El vampiro ya está debilitado");
					
				} else if (!vampireInRoom) {
					
					System.out.println("El vampiro no está en esta habitación");
					
				} else if (!crossInBag) {
					
					System.out.println("No tienes la cruz en la mochila");
					
				} else if (!mansion.getVampire().isAlive()) {
					
					System.out.println("El vampiro ya está muerto");
					
				}
				
			} else if (command.equals("uk")) { // Usar KBMV
				
				if (basicVampireKillingKitInBag && vampireInRoom && mansion.getVampire().isWeakened() && mansion.getVampire().isAlive()) {
					
					System.out.println("Has matado al vampiro. Ya puedes escapar por la ventana");
					
					mansion.getVampire().kill();
					currentRoom.getCharacters().remove(mansion.getVampire());
					
					bag.deleteThing(mansion.getBasicVampireKillingKit());
					mansion.getBasicVampireKillingKit().setLocation(new int[] {-1, -1, -1});
					
				} else if (!mansion.getVampire().isWeakened()) {
					
					System.out.println("El vampiro aún no está debilitado");
					
				} else if (!vampireInRoom) {
					
					System.out.println("El vampiro no está en esta habitación");
					
				} else if (!basicVampireKillingKitInBag) {
					
					System.out.println("No tienes el kit básico mata-vampiros en la mochila");
					
				} else if (!mansion.getVampire().isAlive()) {
					
					System.out.println("El vampiro ya está muerto");
					
				}
				
			} else if (command.equals("uz")) { // Usar zumo
				
				if (fruitJuiceInBag) {
					System.out.println("Uhhhmmm ricas vitaminas");
					
					bag.deleteThing(mansion.getFruitJuice());
					mansion.getFruitJuice().setLocation(new int[] {-1, -1, -1});
					
				} else {
					System.out.println("No tienes el zumo de frutas en la mochila");
				}
				
			} else if (command.equals("ua")) { // Usar aspiradora
				
				if (vacuumInBag && ghostInRoom && mansion.getGhost().isAlive()) {
					
					System.out.println("Has capturado al fantasma");
					
					mansion.getGhost().kill();
					currentRoom.getCharacters().remove(mansion.getGhost());
					
					bag.deleteThing(mansion.getVacuum());
					mansion.getVacuum().setLocation(new int[] {-1, -1, -1});
					
				} else if (!mansion.getGhost().isAlive()) {
					
					System.out.println("El fantasma ya está capturado");
					
				} else if (!ghostInRoom) {
					
					System.out.println("El fantasma no está en esta habitación");
					
				} else if (!vacuumInBag) {
					
					System.out.println("No tienes la aspiradora en la mochila");
					
				}
				
			} else { // Si el comando no existe
				
				System.out.println("No existe el comando '" + command + "', intentenlo de nuevo");
				
			}
			
			System.out.println("\n\n");
			
		} while(true);
		
	}

}
