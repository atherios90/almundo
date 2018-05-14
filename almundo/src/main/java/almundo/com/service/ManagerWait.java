package almundo.com.service;

import java.util.ArrayList;
import java.util.List;

import almundo.com.domain.Call;

/**
 * Gestor de llamadas en espera, lo cual su tarea es intentar una n determinadas veces 
 * para que una llamada sea atendida, lo cual cada 2(segundos) se esta procesando las
 * llamadas.
 * 
 * @author Andres Rios
 * */
public class ManagerWait implements Runnable {
	
	private static final Integer MAXIMUN_INTENTS_CALL = 10;
	
	/**
	 * Lista de llamadas en espera de ser atendidas
	 * */
	private List<Call> callsWaiting;
	
	/**
	 * Variable que indica el estado de ejecucion del gestor de llamadas en espera.
	 * */
	private boolean execution;
	
	/**
	 * Constructor del gestor de llamadas
	 * */
	public ManagerWait() {
		execution = true;
		callsWaiting = new ArrayList<>();
	}
	
	/**
	 * Proceso de ejecucion de la lista de llamadas en espera, lo cual se intentara 
	 * cada 2 segundos procesar las llamadas en espera, para asi re-intentar verificar
	 * la disponibilidad de empleados para atenderlas.
	 * */
	@Override
	public void run() {
		while (execution) {
			try {
				for (int index = callsWaiting.size() -1; index >= 0; index--) {
					Call call = callsWaiting.get(index);
					if (checkIntentsCall(call)) {						
						Dispatcher.getInstance().dispatchCall(call);
						Thread.sleep(2000);
					} else {
						System.out.println(
								"Lo sentimos pero no hay asesores disponibles para atender tu llamada, intente mas tarde. Numero llamada: "
										+ call.getId());
						callsWaiting.remove(index);
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
	/**
	 * Metodo encargado de chequear si una llamada ya cumplio con el numero de intentos  de
	 * verificar si hay disponibilidad
	 * 
	 * @param call, llamada encargada de verificar los numeros de intentos
	 * @return true - Es posible atender la llamada, false - Ya no se puede atender
	 */
	private boolean checkIntentsCall(Call call) {
		return call.getNumberIntents() < MAXIMUN_INTENTS_CALL;
	}
	
	/**
	 * Metodo encargado de detener el gestor de llamadas en espera.
	 * */
	public void stop() {
		execution = false;
	}
	
	
	/**
	 * Metodo encargado de adicionar una llamada a la lista en espera, si la llamada
	 * ya se encontraba en la lista de espera se adiciona un intento a su proceso de la
	 * llamada enviada por parametro.
	 * 
	 * @param call, llamada a adiciona a la lista de espera, si existe se aumenta el numero
	 *        de intentos.
	 */
	public void addCall(Call call) {
		if(existCall(call)) {
			call.setNumberIntents(call.getNumberIntents()+1);
		}else {
			System.out.println("Llamada en espera: "+call.getId());
			System.out.println("Numero de llamadas en espera: "+callsWaiting.size());
			callsWaiting.add(call);
		}
	}
	
	/**
	 * Metodo encargado de chequear si la llamada existe en la lista de espera, ademas
	 * si existe se remueve la llamada de la lista
	 * 
	 * @param call, llamada a verificar si existe en la lista de espera
	 */
	public void checkCall(Call call) {
		if(existCall(call)) {
			callsWaiting.remove(call);
		} 
	}
	
	/**
	 * Metodo encargado de verificar si una llamada se encuentra en la lista de espera
	 * 
	 * @param call, llamada a buscar
	 * @return true- se encuentra en la lista de espera, false - no se encuentra
	 */
	public boolean existCall(Call call) {
		return callsWaiting.contains(call);
	}

}
