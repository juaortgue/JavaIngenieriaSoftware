package fp.ovnis.clases;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AvistamientoImpl1 implements Avistamientos {

	private Set<Avistamiento> avistamientos;
	public AvistamientoImpl1(List<Avistamiento> avistamientos) {
		this.avistamientos = new HashSet<Avistamiento>(avistamientos);
	}
	
	public boolean equals(Object o) {
		boolean result = false;
		if(o instanceof Avistamientos) {
			Avistamiento av = (Avistamiento) o;
			result = av.equals(o);
		}
		return result;
	}
	
	
	public void anyadirAvistamiento(Avistamiento av) {
		// TODO Auto-generated method stub
		getAvistamientos().add(av);
	}

	
	public Integer getNumeroAvistamientosFecha(LocalDate f) {
		return null;
	}

	@Override
	public Set<Avistamiento> getAvistamientosCercanosUbicacion(Coordenadas c, Double d) {
		return null;
	}

	@Override
	public Boolean existeAvistamientoLugarAnyo(String l, Integer a) {
		return null;
	}

	@Override
	public Avistamiento getAvistamientoMayorDuracion() {
		return null;
	}
	//No devolvemos copia porque no se puede modificar el original, si no la copia, ya que es un map
	@Override
	public Map<LocalDate, Set<Avistamiento>> getAvistamientosPorFecha() {
		Map<LocalDate, Set<Avistamiento>> result = new HashMap<LocalDate, Set<Avistamiento>>();
		
		for (Avistamiento av: getAvistamientos()) {
			LocalDate clave = av.getFecha();
			if(!result.containsKey(clave)) {
				Set<Avistamiento> valor = new HashSet<Avistamiento>();
				//caso inicial: no hay par <clave, valor>
				valor.add(av);
				result.put(clave, valor);
			}else {
				//caso normal: hay una colision
				Set<Avistamiento> valor = result.get(clave);
				valor.add(av);
				result.put(clave, valor);
			}
		}
		return result;
	}

	@Override
	public Map<Integer, Long> getNumeroAvistamientosPorAno() {
		Map<Integer, Long> result = new HashMap<Integer, Long>();		
		for(Avistamiento av : getAvistamientos()) {
			if(!result.containsKey(av.getAnyo())) {
				//caso inicial: no hay par <clave, valor>
				result.put(av.getAnyo(), 1l);
			}else {
				//caso normal: hay una colision
				result.put(av.getAnyo(),  result.get(av.getAnyo())+1);
			}
			
		}
		return result;
	}

	@Override
	public Set<Avistamiento> getAvistamientos() {
		// TODO Auto-generated method stub
		return null;
	}

}
