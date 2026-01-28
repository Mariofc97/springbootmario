package es.cursojava.springbootmario.servicios;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.springbootmario.entities.CaballoEntity;
import es.cursojava.springbootmario.mappers.CaballoMapper;
import es.cursojava.springbootmario.models.CaballoDto;
import es.cursojava.springbootmario.repository.CaballoRepository;
import jakarta.transaction.Transactional;

public class CaballoService {

	private final CaballoRepository repo;
	private final CaballoMapper mapper;
	private static final double distanciaCarrera = 200.00;
	private List<CaballoDto> caballos = new ArrayList<>();
	
	protected static final Logger log = LoggerFactory.getLogger(CaballoEntity.class);
	public CaballoService(CaballoRepository repo, CaballoMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	
	
	@Transactional
	public CaballoDto create(CaballoDto dto) {
		if(dto.getNombre() == null || dto.getNombre().isBlank()) {
			throw new IllegalArgumentException("name is required");
		}
		if(dto.getId() == null) {
			throw new IllegalArgumentException("email is required");
		}
		
		CaballoEntity entity = mapper.toEntity(dto);
		
		CaballoEntity saved = repo.save(entity);
		
		return mapper.toDto(saved);
	}
	
	@Transactional()
	public CaballoDto findById(Long id) {
		CaballoEntity caballo = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Caballo not found"));
		
		return mapper.toDto(caballo);
	}
	
	public List<CaballoDto> getCaballos() {
		return caballos;
	}
	
	public void setCaballos(List<CaballoDto> caballos) {
		this.caballos = caballos;
	}
	
	public double calcularAvanceTurno(CaballoDto dto) {
		double baseAleatoria = Math.random() * 10.0;
		
		double penalizacionPeso = dto.getPeso() / 15.0;
		
		double avance = baseAleatoria + dto.getVelocidad() + dto.getExperiencia() - penalizacionPeso;
		
		if(avance < 0) avance = 0;
		
		double a = Math.round(avance * 100.0)/100.0;
		log.info("{} avanza {} m este turno", dto.getNombre(), a);
		
		return avance;
	}
	
	public double aplicarAvance(CaballoDto dto, double metros) {
		double metrosRecorridos = dto.getMetrosRecorridos() + metros;
		dto.setMetrosRecorridos(metrosRecorridos);
		
		return metrosRecorridos;
	}
	
	public CaballoDto correr() {
		
		if(caballos.size() >= 2) {
			for (CaballoDto c : caballos) {
				c.setMetrosRecorridos(0.0);
			}
			
			CaballoDto ganador = null;
			
			int turno = 0;
			
			while(ganador == null) {
				turno++;
				
				for(CaballoDto c : caballos) {
					double metros = calcularAvanceTurno(c);
					aplicarAvance(c, metros);
					if(c.getMetrosRecorridos() >= distanciaCarrera) {
						break;
					}
					log.info("Turno " + turno + ": " + "caballo " + c.getNombre() + " " + Math.round(metros) + " metros. Total: " + Math.round(c.getMetrosRecorridos()));
					
				}
				
				List<CaballoDto> candidatos = new ArrayList<>();
				double mejor = -1.0;
				CaballoDto candidato = null;
				for (CaballoDto c : caballos) {
					double total = c.getMetrosRecorridos();
					if(total >= distanciaCarrera && total > mejor) {
						mejor = total;
						candidato = c;
					}
				}
				
				if (candidato != null) {
					ganador = candidato;
				}
			}
			
			log.info("Ganador: " + ganador.getNombre());
			return ganador;
		} else {
			log.error("Necesitas al menos dos caballos para hacer una carrera");
			return null;
		}
	}
	
	
	
	
}
