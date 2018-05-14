package almundo.com.domain;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

import almundo.com.enums.CallStatus;
import almundo.com.service.Dispatcher;

/**
 * Clase encargada de manejar el concepto de llamada en el sistema de call center,
 * lo cual maneja el tiempo de la llamada y el empleado quien la atienda.
 * 
 * @author Andres Rios
 * */
public class Call implements Serializable, Runnable{

	private static final long serialVersionUID = 7688059458332907322L;
	
	/**
	 * Identificador unico de llamada
	 * */
	private String id;
	
	/**
	 * Numero de intentos para verificar si es posible atender la llamada
	 * */
	private Integer numberIntents;
	
	/**
	 * Estado de la llamada
	 * */
	private CallStatus status;
	
	/**
	 * Tiempo de la llamada entre 5 y 10 segundos
	 * */
	private Integer callTime;
	
	/**
	 * Empleado que atiende la llamada
	 * */
	private Employee employee;
	
	public Call() {
		this.status = CallStatus.NO_ATENTIDA;
		this.id = UUID.randomUUID().toString();
		this.numberIntents = 0;
	}
	
	/**
	 * Hilo de ejecucion encargada de manejar la gestion de la llamada
	 * */
	@Override
	public void run() {
		initCallTime();		
		try {
			System.out.println("Llamada atentida");
			Thread.sleep(1000 * callTime);
			status = CallStatus.FINALIZADA;
			Dispatcher.getInstance().finalizeCall(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
	}	
	
	/**
	 * Metodo encargado de iniciar el tiempo de ejecucion de la llamada
	 * */
	private void initCallTime() {
		Random random= new Random();
		callTime = random.nextInt(10-5+1) + 5;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	

	public Integer getNumberIntents() {
		return numberIntents;
	}

	public void setNumberIntents(Integer numberIntents) {
		this.numberIntents = numberIntents;
	}

	public CallStatus getStatus() {
		return status;
	}

	public void setStatus(CallStatus status) {
		this.status = status;
	}	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numberIntents == null) ? 0 : numberIntents.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}	
		if (obj == null) {
			return false;
		}if (getClass() != obj.getClass()) {
			return false;
		}
		Call other = (Call) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (numberIntents == null) {
			if (other.numberIntents != null) {
				return false;
			}
		} else if (!numberIntents.equals(other.numberIntents)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		return true;
	}

}
