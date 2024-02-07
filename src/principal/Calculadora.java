package principal;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import formatoslogs.FormatoHTML;
import menu.Menu;
import operaciones.Operaciones;

public class Calculadora {
	public static final Logger LOGGER = Logger.getLogger("Nombre del logger");

	public static void main(String[] args) throws IOException {
		/**
		 * El main en el que se invocan los metodos.
		 *
		 * @author Janire
		 * @version 23.9.2024
		 */

		LOGGER.setLevel(Level.ALL);
		LOGGER.setUseParentHandlers(false);
		int resultado = 0;
		String operacion = "";
		int[] operandos = new int[2];

		Handler consoleHandler = new ConsoleHandler();
		Handler fileHandler = null;
		LOGGER.addHandler(consoleHandler);
		consoleHandler.setLevel(Level.WARNING);

		try {
			fileHandler = new FileHandler("./logs/ficheroLog"+System.currentTimeMillis()+".html", true);
			LOGGER.addHandler(fileHandler);
			fileHandler.setFormatter(new FormatoHTML());
			fileHandler.setLevel(Level.ALL);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileHandler.setFormatter(new FormatoHTML());
		
		Menu menu = new Menu();
		Operaciones operaciones = new Operaciones();

		do {
			operandos = menu.pedirNumeros();
			operacion = menu.menuOpciones();

			if (operacion.equalsIgnoreCase("+")) {
				resultado = operaciones.sumar(operandos[0], operandos[1]);
				LOGGER.log(Level.FINE, operandos[0] + ";" + operacion + ";" + operandos[1] + ";" + resultado);
				
				System.out.println("Resultado: " + resultado);
			} else if (operacion.equalsIgnoreCase("-")) {
				resultado = operaciones.restar(operandos[0], operandos[1]);
				LOGGER.log(Level.FINE, operandos[0] + ";" + operacion + ";" + operandos[1] + ";" + resultado);
				
				System.out.println("Resultado: " + resultado);
			} else if (operacion.equalsIgnoreCase("*")) {
				resultado = operaciones.multiplicar(operandos[0], operandos[1]);
				LOGGER.log(Level.FINE, operandos[0] + ";" + operacion + ";" + operandos[1] + ";" + resultado);
				
				System.out.println("Resultado: " + resultado);
			} else if (operacion.equalsIgnoreCase("/")) {
				try {
					resultado = operaciones.dividir(operandos[0], operandos[1]);
					LOGGER.log(Level.FINE, operandos[0] + ";" + operacion + ";" + operandos[1] + ";" + resultado);
					
				} catch (ArithmeticException e) {
					LOGGER.log(Level.WARNING, "Intento de dividir por cero");
					resultado = 0;
				}
				System.out.println("Resultado: " + resultado);
			} else if (operacion.equalsIgnoreCase("%")) {
				resultado = operaciones.resto(operandos[0], operandos[1]);
				LOGGER.log(Level.FINE, operandos[0] + ";" + operacion + ";" + operandos[1] + ";" + resultado);
				
				System.out.println("Resultado: " + resultado);
			} else {
				System.out.println("Operaci�n no v�lida");
			}
		} while (menu.repetir());
	}
}