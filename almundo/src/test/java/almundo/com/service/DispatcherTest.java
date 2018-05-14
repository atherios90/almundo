package almundo.com.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import almundo.com.domain.Call;
import almundo.com.domain.Employee;
import almundo.com.enums.EmployeeType;
import junit.framework.Assert;

/**
 * Test para verificar el funcionamiento del gestor de llamadas.
 * 
 * @author Andres Rios
 * */
public class DispatcherTest {
	
	
	@Test
	public void seEnviaLlamadaConsecutivas() {
		System.out.println("///////////////////////////////////////////////");
		System.out.println("Test 1");
		List<Employee> empleados = new ArrayList<>();
		Employee empleado = new Employee();
		empleado.setType(EmployeeType.OPERADOR);
		empleados.add(empleado);
		Dispatcher.restart();
		Dispatcher.getInstance().setEmployees(empleados);
		for(int i = 0; i < 10; i++ ) {
			Call llamada = new Call();
			Dispatcher.getInstance().dispatchCall(llamada);
		}
		List<Call> llamadas = Dispatcher.getInstance().getCalls();
		Assert.assertEquals(1, llamadas.size());
	}
	
	@Test
	public void seEnviaLlamadaDiezConsecutivas() {
		System.out.println("///////////////////////////////////////////////");
		System.out.println("Test 2");
		List<Employee> empleados = new ArrayList<>();
		Employee empleado = new Employee();
		empleado.setType(EmployeeType.OPERADOR);
		empleados.add(empleado);
		Employee empleado2 = new Employee();
		empleado2.setType(EmployeeType.OPERADOR);
		empleados.add(empleado2);
		Employee empleado3 = new Employee();
		empleado3.setType(EmployeeType.OPERADOR);
		empleados.add(empleado3);
		Employee empleado4 = new Employee();
		empleado4.setType(EmployeeType.OPERADOR);
		empleados.add(empleado4);
		Employee empleado5 = new Employee();
		empleado5.setType(EmployeeType.OPERADOR);
		empleados.add(empleado5);
		Employee empleado6 = new Employee();
		empleado6.setType(EmployeeType.OPERADOR);
		empleados.add(empleado6);
		Employee empleado7 = new Employee();
		empleado7.setType(EmployeeType.OPERADOR);
		empleados.add(empleado7);
		Employee empleado8 = new Employee();
		empleado8.setType(EmployeeType.OPERADOR);
		empleados.add(empleado8);
		Employee empleado9 = new Employee();
		empleado9.setType(EmployeeType.OPERADOR);
		empleados.add(empleado9);
		Employee empleado10 = new Employee();
		empleado10.setType(EmployeeType.OPERADOR);
		empleados.add(empleado10);
		Dispatcher.restart();
		Dispatcher.getInstance().setEmployees(empleados);
		for(int i = 0; i < 10; i++ ) {
			Call llamada = new Call();
			Dispatcher.getInstance().dispatchCall(llamada);
		}
		List<Call> llamadas = Dispatcher.getInstance().getCalls();
		Assert.assertEquals(10, llamadas.size());

	}
	
	
	
	
	@Test
	public void seEnviaMasDe10LlamadasConsecutivas() {
		System.out.println("///////////////////////////////////////////////");
		System.out.println("Test 3");
		List<Employee> empleados = new ArrayList<>();
		Employee empleado = new Employee();
		empleado.setType(EmployeeType.OPERADOR);
		empleados.add(empleado);
		Employee empleado2 = new Employee();
		empleado2.setType(EmployeeType.OPERADOR);
		empleados.add(empleado2);
		Employee empleado3 = new Employee();
		empleado3.setType(EmployeeType.OPERADOR);
		empleados.add(empleado3);
		Employee empleado4 = new Employee();
		empleado4.setType(EmployeeType.OPERADOR);
		empleados.add(empleado4);
		Employee empleado5 = new Employee();
		empleado5.setType(EmployeeType.OPERADOR);
		empleados.add(empleado5);
		Employee empleado6 = new Employee();
		empleado6.setType(EmployeeType.OPERADOR);
		empleados.add(empleado6);
		Employee empleado7 = new Employee();
		empleado7.setType(EmployeeType.OPERADOR);
		empleados.add(empleado7);
		Employee empleado8 = new Employee();
		empleado8.setType(EmployeeType.OPERADOR);
		empleados.add(empleado8);
		Employee empleado9 = new Employee();
		empleado9.setType(EmployeeType.OPERADOR);
		empleados.add(empleado9);
		Employee empleado10 = new Employee();
		empleado10.setType(EmployeeType.OPERADOR);
		empleados.add(empleado10);
		Dispatcher.restart();
		Dispatcher.getInstance().setEmployees(empleados);
		for(int i = 0; i < 13; i++ ) {
			Call llamada = new Call();
			Dispatcher.getInstance().dispatchCall(llamada);
		}
		List<Call> llamadas = Dispatcher.getInstance().getCalls();
		Assert.assertEquals(10, llamadas.size());

	}

	@Test
	public void seEnviaMasDeDiezLlamadasConsecutivasYSeTieneDistintosRoles() {
		System.out.println("///////////////////////////////////////////////");
		System.out.println("Test 4");
		List<Employee> empleados = new ArrayList<>();
		Employee empleado7 = new Employee();
		empleado7.setType(EmployeeType.SUPERVISOR);
		empleados.add(empleado7);
		Employee empleado8 = new Employee();
		empleado8.setType(EmployeeType.SUPERVISOR);
		empleados.add(empleado8);
		Employee empleado = new Employee();
		empleado.setType(EmployeeType.OPERADOR);
		empleados.add(empleado);
		Employee empleado2 = new Employee();
		empleado2.setType(EmployeeType.OPERADOR);
		empleados.add(empleado2);
		Employee empleado3 = new Employee();
		empleado3.setType(EmployeeType.OPERADOR);
		empleados.add(empleado3);
		Employee empleado4 = new Employee();
		empleado4.setType(EmployeeType.OPERADOR);
		empleados.add(empleado4);
		Employee empleado5 = new Employee();
		empleado5.setType(EmployeeType.OPERADOR);
		empleados.add(empleado5);
		Employee empleado6 = new Employee();
		empleado6.setType(EmployeeType.OPERADOR);
		empleados.add(empleado6);	
		Employee empleado9 = new Employee();
		empleado9.setType(EmployeeType.DIRECTOR);
		empleados.add(empleado9);
		Employee empleado10 = new Employee();
		empleado10.setType(EmployeeType.DIRECTOR);
		empleados.add(empleado10);
		Dispatcher.restart();
		Dispatcher.getInstance().setEmployees(empleados);
		for(int i = 0; i < 15; i++ ) {
			Call llamada = new Call();
			Dispatcher.getInstance().dispatchCall(llamada);
		}
		List<Call> llamadas = Dispatcher.getInstance().getCalls();
		Assert.assertEquals(10, llamadas.size());

	}
	
	@Test
	public void seEnviaDiezLlamadaConcurrentes() {
		System.out.println("///////////////////////////////////////////////");
		System.out.println("Test 5");
		List<Employee> empleados = new ArrayList<>();
		Employee empleado = new Employee();
		empleado.setIdEmployee(1);
		empleado.setType(EmployeeType.OPERADOR);
		empleados.add(empleado);
		Employee empleado2 = new Employee();
		empleado2.setIdEmployee(2);
		empleado2.setType(EmployeeType.OPERADOR);
		empleados.add(empleado2);
		Employee empleado3 = new Employee();
		empleado3.setIdEmployee(3);
		empleado3.setType(EmployeeType.OPERADOR);
		empleados.add(empleado3);
		Employee empleado4 = new Employee();
		empleado4.setIdEmployee(4);
		empleado4.setType(EmployeeType.OPERADOR);
		empleados.add(empleado4);
		Employee empleado5 = new Employee();
		empleado5.setIdEmployee(5);
		empleado5.setType(EmployeeType.OPERADOR);
		empleados.add(empleado5);
		Employee empleado6 = new Employee();
		empleado6.setIdEmployee(6);
		empleado6.setType(EmployeeType.OPERADOR);
		empleados.add(empleado6);
		Employee empleado7 = new Employee();
		empleado7.setIdEmployee(7);
		empleado7.setType(EmployeeType.OPERADOR);
		empleados.add(empleado7);
		Employee empleado8 = new Employee();
		empleado8.setIdEmployee(8);
		empleado8.setType(EmployeeType.SUPERVISOR);
		empleados.add(empleado8);
		Employee empleado9 = new Employee();
		empleado9.setIdEmployee(9);
		empleado9.setType(EmployeeType.DIRECTOR);
		empleados.add(empleado9);
		Dispatcher.restart();
		Dispatcher.getInstance().setEmployees(empleados);
		for(int i = 0; i < 14; i++ ) {
			Thread hilo = new Thread() {
				@Override
				public void run() {
					Call llamada = new Call();
					Dispatcher.getInstance().dispatchCall(llamada);
				}
			};
			hilo.start();
		}
	}

}
