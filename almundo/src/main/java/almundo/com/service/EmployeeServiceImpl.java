package almundo.com.service;

import java.util.List;

import almundo.com.domain.Employee;
import almundo.com.enums.EmployeeStatus;
import almundo.com.service.interfaces.IEmployeeService;


/**
 * Clase encargada de implementar los servicios relacionada a los empleados, como son busquedas u otra operacion.
 * 
 * @author Andres Rios
 *
 */
public class EmployeeServiceImpl implements IEmployeeService{

	public Employee searchEmployeeAvaliable(List<Employee> employees) {
		employees.sort((e1,e2)-> Integer.compare(e1.getType().getPriority(), e2.getType().getPriority()));
		return employees.stream().filter(employee -> employee.getStatus().equals(EmployeeStatus.LIBRE)).findFirst()
				.orElse(null);
	}

	@Override
	public Employee findEmployeeById(Integer id, List<Employee> employees) {
		return employees.stream().filter(employee-> employee.getIdEmployee().equals(id)).findFirst().orElse(null);
	}

}
