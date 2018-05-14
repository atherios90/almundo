package almundo.com.enums;

/**
 * Enumerado que contiene los tipos de empleado que existen en el sistema
 * 
 * @author Andres Rios
 * */
public enum EmployeeType {

	OPERADOR(1),SUPERVISOR(2),DIRECTOR(3);
	
	/**
	 * Prioridad de atender las llamadas, entre mas pequeño sea sera 
	 * los primeros en atender las llamadas.
	 * */
	private int priority;
	
	private EmployeeType(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}	
	
}
