package almundo.com.service.interfaces;

import java.util.List;

import almundo.com.domain.Employee;

/**
 * Interfaz que tiene los distintos servicios relacionados a los empleados
 * 
 * @author Andres Rios
 *
 */
public interface IEmployeeService {

	/**
	 * Servicio encargado de buscar un empleado que tenga disponibilidad acorde a
	 * la prioridad.
	 * 
	 * @param employees, lista de empleados
	 * @return Empleado libre o null(no existe empleados libres)
	 */
	Employee searchEmployeeAvaliable(List<Employee> employees);
	
	/**
	 * Servicio encargado de buscar un empleado especifico mediante su id(identificador unico).
	 * 
	 * @param id, Identificador unico del empleado
	 * @param employees, Lista de empleados disponibles
	 * @return Empleado identificado con el id enviado por parametro, de lo contrario null si no
	 *         existe tal empleado
	 */
	Employee findEmployeeById(Integer id,List<Employee> employees);
	
}
