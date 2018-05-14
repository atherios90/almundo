package almundo.com.utils;

import java.util.List;

/**
 * Clase utilitaria encargada de manejar los servicios utilitarios transversales
 * en todos los servicios y ademas son genericos.
 * 
 * @author Andres Rios
 *
 */
public class Utils {

	/**
	 * Metodo encargado de valida si un objeto es nulo
	 * 
	 * @param object, objeto a validar
	 * @return true - es nulo, false-  no lo es.
	 */
	public static boolean isNull(Object object) {
		return object == null;
	}
	
	/**
	 * Metodo encargado de verificar si una lista se encuentras con valores
	 * 
	 * @param list. lista a verificar 
	 * @return true - es una lista vacia, false - la lista contiene elementos
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmptyCollection(List list) {
		return list == null || list.isEmpty();
	}
	
}
