package almundo.com.domain;

import java.io.Serializable;

import almundo.com.enums.EmployeeStatus;
import almundo.com.enums.EmployeeType;

/**
 * Clase encargada de manejar la informacion relacionada al empleado
 * con sus respectivos tipos y estados que pueden disponer este concepto
 * 
 * @author Andres Rios
 * */
public class Employee  implements Serializable{

	private static final long serialVersionUID = -1104488363444474989L;
	
	/**
	 * Identificador unico del empleado
	 * */
	private Integer idEmployee;
	
	/**
	 * Tipo de empleado que permite conocer si el empleado es de un rol especifico
	 * OPERADOR, SUPERVISOR y DIRECTOR
	 * */
	private EmployeeType type;
	
	/**
	 * Estado del empleado con la que se dispone
	 * LIBRE, OCUPADO
	 * */
	private EmployeeStatus status;	
	
	public Employee() {
		this.status = EmployeeStatus.LIBRE;
	}
	
	public Integer getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}

	public EmployeeType getType() {
		return type;
	}

	public void setType(EmployeeType type) {
		this.type = type;
	}

	public EmployeeStatus getStatus() {
		return status;
	}

	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEmployee == null) ? 0 : idEmployee.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		if (idEmployee == null) {
			if (other.idEmployee != null) {
				return false;
			}
		} else if (!idEmployee.equals(other.idEmployee)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}	
	
	
}
