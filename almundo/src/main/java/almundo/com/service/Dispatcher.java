package almundo.com.service;

import java.util.ArrayList;
import java.util.List;

import almundo.com.domain.Call;
import almundo.com.domain.Employee;
import almundo.com.enums.CallStatus;
import almundo.com.enums.EmployeeStatus;
import almundo.com.enums.EmployeeType;
import almundo.com.service.interfaces.IEmployeeService;
import almundo.com.utils.Utils;

/**
 * Clase encargada de gestionar las llamadas y los empleados que se tiene disponible en
 * el sistema con el fin de asignar las llamadas entrantes en los empleados que se tiene
 * disponible.
 * 
 * @author Andres Rios
 * */
public class Dispatcher {
	
	/**
	 * Numero de llamadas permitidas para gestionar y asignar un empleado
	 * */
	private static final Integer MAXIMUN_NUMBER_CALLS = 10;
	
	/**
	 * Instancia unica para reutilizar en los distintos hilos de ejecucion, volviendo
	 * a la misma clase SINGLETON.
	 * */
	private static Dispatcher INSTANCE;
	
	/**
	 * Interfaz que ofrece los distintos servicios relacionados a los empleados.
	 * */
	private IEmployeeService employeeService;
	
	/**
	 * Gestor de la lista de llamadas en espera.
	 * */
	private ManagerWait manager;
	
	/**
	 * Indicador de numero de llamadas atentidas hasta el momento
	 * */
	private volatile Integer numberCalls;
	
	/**
	 * Lista de empleados con las que se encuenta hasta en el gestor de llamadas
	 * */
	private List<Employee> employees;
	
	/**
	 * Lista de llamadas atendidas por el gestor y que se encuentran en curso.
	 * */
	private List<Call> calls;	
	
	/**
	 * Constructor del gestor de llamadas encargado de inicializar los elementos utilitarios
	 * u necesarios para el funcionamiento del gestor .
	 * */
	public Dispatcher() {
		calls = new ArrayList<Call>();
		numberCalls = 0;
		employeeService = new EmployeeServiceImpl();
		manager = new ManagerWait();
		init();
	}
	
	/**
	 * Metodo encargado de iniciar lista de empleados por defecto, ademas de iniciar el gestor
	 * de llamadas en espera.
	 * */
	public void init() {
		employees = new ArrayList<>();
		Employee employee1 = new Employee();
		employee1.setStatus(EmployeeStatus.LIBRE);
		employee1.setType(EmployeeType.OPERADOR);
		employees.add(employee1);
		
		Thread managerThread = new Thread(manager);
		managerThread.start();
	}
	
	/**
	 * Metodo encargado de instanciar el gestor de llamadas una sola vez.
	 * */
	public static Dispatcher getInstance() {
		if(Utils.isNull(INSTANCE)) {
			INSTANCE = new Dispatcher();
		}
		return INSTANCE;
	}
	
	/**
	 * Metodo encargado de procesar la llamada en el gestor y asignar un operador a la misma,
	 * lo cual se buscara un empleado disponible para atenderla, para ello se tiene como prioridad
	 * los empleados con el rol de OPERADOR, ademas sino se tiene ningun disponible se enviara la llamada
	 * al gestor de llamadas en espera.
	 * 
	 * @param call, llamada a ser atendida.
	 */
	public synchronized void dispatchCall(Call call) {
		if(numberCalls <= MAXIMUN_NUMBER_CALLS) {
			Employee employee = employeeService.searchEmployeeAvaliable(employees);
			if(Utils.isNull(employee)) {
				manager.addCall(call);
			}else {
				numberCalls++;
				call.setStatus(CallStatus.ATENTIDA);
				employee.setStatus(EmployeeStatus.OCUPADO);
				call.setEmployee(employee);
				Thread callThread = new Thread(call);
				calls.add(call);
				manager.checkCall(call);
				callThread.start();
			}
		}else {
			manager.addCall(call);
		}
	}
	
	/**
	 * Metodo encargada de reiniciar la instancia del gestor.
	 * */
	public static void restart() {
		INSTANCE = null;
	}
	
	/**
	 * Metodo encargado de finalizar la llamada cuando esta ya ha sido atendida.
	 * 
	 * @param call, llamada a finalizar su proceso
	 */
	public void finalizeCall(Call call) {
		Employee employee = employeeService.findEmployeeById(call.getEmployee().getIdEmployee(), employees);
		employee.setStatus(EmployeeStatus.LIBRE);
		calls.remove(call);
		numberCalls--;
		System.out.println("Llamada finalizada");
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Call> getCalls() {
		return calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}	
	
}
