package es.cursojava.springbootmario.mappers;

import org.springframework.stereotype.Component;

import es.cursojava.springbootmario.entities.CaballoEntity;
import es.cursojava.springbootmario.models.CaballoDto;

@Component
public class CaballoMapper {

	public CaballoEntity toEntity(CaballoDto dto) {
		return new CaballoEntity(dto.getId(), dto.getNombre(), dto.getDorsal(), dto.getVelocidad(), dto.getPeso(), dto.getExperiencia());
	}
	
	public CaballoDto toDto(CaballoEntity entity) {
		return new CaballoDto(entity.getId(), entity.getNombre(), entity.getDorsal(), entity.getVelocidad(), entity.getPeso(), entity.getExperiencia());
	}
}
